from selenium import webdriver
from selenium.webdriver.common.by import By
import time
import random
from bs4 import BeautifulSoup
import urllib.request
from fake_useragent import UserAgent


def open_brower():
    brower = webdriver.Edge()
    brower.get('https://www.quanben.io/n/zhetian/list.html')
    brower.find_element(By.LINK_TEXT, "[展开完整列表]").click()
    return brower, brower.page_source

def parse_html(html, f):
    # 生成soup对象
    soup = BeautifulSoup(html, 'html.parser')
    # 查找所有的章节链接和标题内容
    list_name = soup.select('#detail > ul > li > a')
    # 遍历每一个列表中的tag对象，获取链接个目录
    for item in list_name:
        # 获取链接
        #item: <a href="/book/liangjinyanyi/1.html">自序</a>
        #拼接目录链接,此处item类型为<class 'bs4.element.Tag'>，使用下面方法可以值获取href属性值
        href = 'https://www.quanben.io' + item['href']
        # 获取标题
        title = item.text
        print('正在下载:-**--%s--**-......' % title)
        # 获取章节内容函数
        text = get_text(href)
        # 写入文件
        f.write(title + '\n' + text)
        print('结束下载:-**--%s--**-' % title)

# 提取章节内容
def get_text(href):
    #创建请求对象
    request = request_html(href)
    content = urllib.request.urlopen(request).read().decode('utf8')
    soup = BeautifulSoup(content, 'html.parser')
    # 查找包含内容的tag--div
    artist = soup.find('div', id="content")
    #获取tag标签中的文本内容
    return artist.text

def request_html(url):
    request = urllib.request.Request(url)
    ua = UserAgent()
    request.add_header('User-Agent', ua.chrome)
    return request

def run():
    # 打开文件
    f = open('vetm.txt', 'w', encoding='utf8')
    # 打开浏览器，加载目录列表
    brower, page = open_brower()
    # 解析内容
    parse_html(page,f)
    #关闭文件
    f.close()
    time.sleep(5)
    brower.quit()

if __name__ == '__main__':
    run()