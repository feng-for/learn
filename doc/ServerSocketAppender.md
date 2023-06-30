# 记录服务器选项
标准的 Logback Classic 发行版包括两个服务器选项，可用于从SocketAppender或SSLSocketAppender接收日志记录事件。

ServerSocketReceiver及其启用 SSL 的副本SSLServerSocketReceiver是接收器组件，可以在应用程序的* logback.xml *配置文件中对其进行配置，以便从远程套接字附加程序接收事件。有关配置的详细信息和用法示例，请参见[Receivers](https://www.docs4dev.com/docs/zh/logback/1.3.0-alpha4/reference/receivers.html)。

SimpleSocketServer及其支持 SSL 的SimpleSSLSocketServer都提供了易于使用的独立 Java 应用程序，该应用程序旨在通过 shell 的命令行界面进行配置和运行。这些应用程序只是 await 来自SocketAppender或SSLSocketAppenderClient 端的日志事件。根据本地服务器策略记录每个收到的事件。使用示例如下。

## Using SimpleSocketServer
SimpleSocketServer应用程序接受两个命令行参数：* port 和 configFile ；其中 port 是要侦听的端口，而 configFile *是 XML 格式的配置脚本。

假设您位于* logback-examples/*目录中，请使用以下命令启动SimpleSocketServer：

java ch.qos.logback.classic.net.SimpleSocketServer 6000\src/main/java/chapters/appenders/socket/server1.xml

其中 6000 是要侦听的端口号，而* server1.xml *是一个配置脚本，该脚本向根 Logger 添加了ConsoleAppender和RollingFileAppender。启动SimpleSocketServer之后，可以使用SocketAppender从多个 Client 端向其发送日志事件。与本手册相关的示例包括两个这样的 Client 端：chapters.appenders.SocketClient1和chapters.appenders.SocketClient2两个 Client 端都 await 用户在控制台上键入一行文本。文本封装在级别为 debug 的日志事件中，然后发送到远程服务器。两个 Client 端的SocketAppender配置不同。 SocketClient1以编程方式配置附加程序，而SocketClient2需要配置文件。

假设SimpleSocketServer在 localhost 上运行，请使用以下命令连接到它：

java chapters.appenders.socket.SocketClient1localhost6000

您键入的每一行都应出现在上一步启动的SimpleSocketServer的控制台上。如果停止并重新启动SimpleSocketServer，则 Client 端将透明地重新连接到新的服务器实例，尽管断开连接时生成的事件将简单(且不可撤消)丢失。

与SocketClient1不同，示例应用程序SocketClient2不会自行配置回传。它需要 XML 格式的配置文件。下面显示的配置文件* client1.xml *创建一个SocketAppender并将其附加到根 Logger。

``` xml
<configuration>
	  
  <appender name="SOCKET" class="ch.qos.logback.classic.net.SocketAppender">
    <remoteHost>${host}</remoteHost>
    <port>${port}</port>
    <reconnectionDelay>10000</reconnectionDelay>
    <includeCallerData>${includeCallerData}</includeCallerData>
  </appender>

  <root level="DEBUG">
    <appender-ref ref="SOCKET" />
  </root>  

</configuration>

```

请注意，在上述配置脚本中，remoteHost，port 和 includeCallerData 属性的值不是直接给出的，而是作为替换变量键给出的。变量的值可以指定为系统属性：

java -Dhost = localhost -Dport = 6000 -DincludeCallerData = false\chapters.appenders.socket.SocketClient2 src/main/java/chapters/appenders/socket/client1.xml

此命令应提供与前面的SocketClient1示例相似的结果。

让我们再次强调一下，日志记录事件的序列化不是侵入性的。反序列化事件携带的信息与任何其他日志记录事件相同。可以像在本地生成一样对其进行操作；除了默认情况下序列化的日志记录事件不包含调用方数据外，其他信息均不包括在内。这是一个例子来说明这一点。首先，使用以下命令启动SimpleSocketServer：

java ch.qos.logback.classic.net.SimpleSocketServer 6000\src/main/java/chapters/appenders/socket/server2.xml

配置文件* server2.xml 创建一个ConsoleAppender，其布局输出呼叫者的文件名和行号以及其他信息。如果像以前一样使用配置文件 client1.xml *运行SocketClient2，则会注意到服务器端的输出将在括号之间包含两个问号，而不是文件名和调用方的行号：

2006 -11-06 17：37：30,968 调试[Thread-0] [？：？] pages.appenders.socket.SocketClient2-嗨

通过将 includeCallerData 选项设置为 true 来指示SocketAppender包含呼叫者数据，可以轻松更改结果。使用以下命令可以解决问题：

    java -Dhost=localhost -Dport=6000 -DincludeCallerData=true \
    chapters.appenders.socket.SocketClient2 src/main/java/chapters/appenders/socket/client1.xml


由于可以用与本地生成的事件相同的方式来处理反序列化事件，因此甚至可以将它们发送到第二台服务器进行进一步处理。作为练习，您可能希望设置两个服务器，其中第一个服务器将其从 Client 端接收的事件传送到第二个服务器。