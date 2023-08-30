import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.openqa.selenium.edge.EdgeDriver
import java.io.FileOutputStream
import java.net.URI

fun main() {
    // println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    // println("Program arguments: ${args.joinToString()}")

    System.setProperty("webdriver.edge.driver", "C:\\Users\\Fengzhiwei\\AppData\\Local\\Programs\\Python\\Python310\\Scripts\\msedgedriver.exe")
    val edgeDriver = EdgeDriver()
    // 目录页面URL
    // val url = "https://www.kandzww.com/book/71457/"
    // val url = "https://quanben-xiaoshuo.com"
    val url = "https://m.bqg9527.net"
    val uri = "/book/220073"
    // 打开浏览器，目录页面
    edgeDriver.get("$url$uri")
    // 点击完整列表按钮
    // edgeDriver.findElementByLinkText("[展开完整列表]").click()
    // 获取HTML页面元素
    val pageSource = edgeDriver.pageSource
    // 使用Jsoup解析HTML页面
    val document: Document? = Jsoup.parse(pageSource)
    // 解析xpath，获取章节节点
    val elements = document?.selectXpath("//div[@class='cover']/ul[@class='chapter']/li/a")
    elements?.let {e ->
        FileOutputStream("1000.txt").bufferedWriter().use { bf ->
            e.forEach {
                val href = it.attr("href")
                val parse: Document? = Jsoup.parse(URI.create("$url$href").toURL(), 1000 * 5)
                parse?.let {p ->
                    val title = p.title()
                    println("正在下载\t$title\n")
                    bf.write(title)
                    val content = p.selectXpath("//div[@id='nr1']")
                    content.eachText().forEach { s -> bf.write("$s\n") }
                }
            }
        }
    }

    // FileOutputStream("vetm.txt").bufferedWriter().use { bf ->
    //     for (i in 50..100) {
    //         val parse: Document? = Jsoup.parse(URI.create("https://www.quanben.io/n/zhetian/$i.html").toURL(), 1000 * 60)
    //         parse?.let {p ->
    //             val selectXpath = p.selectXpath("//div[@id='content']")
    //             selectXpath.eachText().forEach { bf.write("$it\n") }
    //         }
    //     }
    // }

}