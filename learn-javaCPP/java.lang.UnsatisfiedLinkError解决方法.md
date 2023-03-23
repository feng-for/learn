# 如果控制台的消息是
> java.lang.UnsatisfiedLinkError: no XXX in java.library.path,Error loading library XXX

这样的错误信息是因为XXX.dll没有拷贝到java.Library.path下，可以使用 `System.getProperty("java.Library.path")` 输出库加载路径，然后将XXX.dll拷贝到库加载路径中

# 如果控制台的消息是
> Exception in thread "main" java.lang.UnsatisfiedLinkError: HelloWorld.print()V 

loadLibrary()没有问题，找不到方法，用dll export viewer察看，导出的方法为

函数名 地址 偏移量

Java_HelloWorld_print@8 0x67741250 0x00001250

重新安装庞大的visual studio重新来编译，调用成功了！ 再次用dll export viewer查看，发现函数名的前面多了一条下划线

函数名 地址 偏移量

_Java_HelloWorld_print@8 0x67741250 0x00001250

看来是给MinGW少传了某个参数，经过网上查阅资料，终于找到一个解决方案：给MinGW的ld命令指定一个参数--kill-at即可
> gcc -Wl, --kill-at -shared -o jnihello.dll HelloWorld.c

再次用dll export viewer查看，发现导出的函数名称变为

函数名 地址 偏移量

Java_HelloWorld_print 0x67741250 0x00001250

--kill-at指令去掉了函数名称后缀的@，并没有像msvc那样添加前缀的下划线

# 如果控制台的消息是
> java.lang.UnsatisfiedLinkError: Native Library xxx.dll already loaded in another classloader
> 
> at java.lang.ClassLoader.loadLibrary0(ClassLoader.java:1551) 
> 
> at java.lang.ClassLoader.loadLibrary(ClassLoader.java:1511) 
> 
> at java.lang.Runtime.loadLibrary0(Runtime.java:788) 
> 
> at java.lang.System.loadLibrary(System.java:834)

这种错误在我们使用热启动方式发布某个使用了JNI技术的Web应用时，并将调用年native方法的jar包独立部署在该应用下面，当我们的Web应用 有了更新以后，在调用到该jar包封装的native方法时，会抛出该错误。（以上OS为Windows，若是Linux或Unix，应该是xxx.so 报错） 这是因为Web服务器已经在第一次加载该应用时，已经load了该dll，当该应用被再次热启动时，该dll将重新被加载，于是报错。 

解决方案： 

一、将含有JNI调用的jar包部署在Web服务器的公用lib库中。Web应用再发布时可以不用加载； 

二、jar包部署不变，在该Web中实现一个listener，监听是否第一次启动，若不是第一次启动，屏蔽掉该jar包所含dll的加载。