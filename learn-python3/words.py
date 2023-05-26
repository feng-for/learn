# 环境依赖
#       在完成对联生成前，需要先完成PaddlePaddle的安装和PaddleHub的安装，并且要求paddlepaddle >= 1.8.0，paddlehub >= 1.7.0；
#       AI Studio已经为各位开发者提供好了PaddlePaddle框架以及PaddleHub预训练模型管理工具，因为我们只需要满足版本，就可以使用相关生成模型，完成一键文本生成。
#       PaddleHub为各位开发者准备了两种方式实现对联生成

# 命令行方式一键生成
#       PaddleHub在设计时，为模型的管理和使用提供了命令行工具，也提供了通过命令行调用PaddleHub模型完成预测的方式。
#       下面是基于命令行的hub run命令完成的对联生成
# 命令行一键情话生成
# !hub run ernie_gen_lover_words --input_text="七夕" --use_gpu False --beam_width 5
# ernie_gen_lover_words ernie_gen_couplet ernie_gen_poetry

# 借助 PaddleHub，服务器端的部署也非常简单，直接用一条命令行在服务器启动情话生成模型（注：由于aistudio上无法获取ip地址，请在本地机器运行以下代码示例）：
# 1.启动PaddleHub Serving
#       运行启动命令
#       hub serving start -m ernie_gen_lover_words -p 8866
#       这样就完成了一个服务化API的部署，默认端口号为8866。
#       NOTE: 如使用GPU预测，则需要在启动服务之前，请设置CUDAVISIBLEDEVICES环境变量，否则不用设置。
# 2.发送预测请求
#       配置好服务端，以下数行代码即可实现发送预测请求，获取预测结果
import requests
import json

# 发送HTTP请求

data = {'texts':['情人节', '七夕', '小编带大家了解一下程序员情人节'],
        'use_gpu':False, 'beam_width':2}
headers = {"Content-type": "application/json"}
url = "http://localhost:8866/predict/ernie_gen_lover_words"
r = requests.post(url=url, headers=headers, data=json.dumps(data))
print(f'test result, connection is finished, {r.status_code}')

# 保存结果
results = r.json()["results"]
for result in results:
    print(result)


# API方式一键生成对联
# 通过预测API，给出上文，程序自动生成下文。
import paddlehub as hub

# 在模型定义时，可以通过设置line=4或8指定输出绝句或律诗，设置word=5或7指定输出五言或七言。
# 默认line=4, word=7 即输出七言绝句。
# module = hub.Module(name="ernie_gen_acrostic_poetry", line=4, word=7)
module = hub.Module(name="ernie_gen_lover_words")

test_texts = ['情人节']
# 调用预测接口生成情话内容
results = module.generate(texts=test_texts, use_gpu=False, beam_width=5)
for result in results:
    print(result)

# 参数
#       texts (list[str]): 情话的开头；
#       use_gpu (bool): 是否使用 GPU；若使用GPU，请先设置CUDA_VISIBLE_DEVICES环境变量；
#       beam_width: beam search宽度，决定每个情话开头输出的下文数目。
# 返回
#       results (list[list][str]): 情话下文，每个情话开头会生成beam_width个下文。