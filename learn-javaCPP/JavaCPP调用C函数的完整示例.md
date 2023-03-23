# JavaCPP调用C函数的完整示例
## 环境最要命，所有一切的症结都在C环境，编译器版本，一定要用C的编译器运行
假设有一个C函数，位于header.h文件中：
```mermaid C
#ifndef HEADER_H
#define HEADER_H

int add(int a, int b);

#endif
```
下面是一个C文件，实现了这个函数：
```mermaid C
#include "header.h"

int add(int a, int b) {
    return a + b;
}
```
使用javacpp可以直接调用这个C函数，无需任何Java本地接口（JNI）代码。
首先需要在pom.xml（或build.gradle等项目构建文件中）添加以下依赖项:
```mermaid xml
<dependency>
  <groupId>org.bytedeco</groupId>
  <artifactId>javacpp</artifactId>
  <version>1.5.4</version>
</dependency>
```
然后创建一个Java类，用于包装C函数。假设C函数位于库文件中libexample.dll，可以像这样定义Java类：
```mermaid java
import org.bytedeco.javacpp.*;

@Platform(include="header.h", linker={"example"})
public class ExampleLibrary {
    static {
        Loader.load();
    }

    public static native int add(int a, int b);
}
```
这个类使用了`@Platform`注释来指定包含C函数的头文件和链接库文件。在静态代码块中，使用`Loader.load()`加载链接库文件。
在Java代码中，可以直接调用C函数：
```mermaid java
public static void main(String[] args) {
    int a = 2;
    int b = 3;
    int c = ExampleLibrary.add(a, b);
    System.out.println(c); // Output: 5
}
```
这个示例展示了如何在Java中使用javacpp调用C函数。注意，需要确保链接库文件的路径已经设置正确，并且链接库文件已经编译为与Java平台相匹配的本机代码。

**编译链接库**

要编译C或C++链接库，通常需要执行以下步骤：
1. 编写C或C++源代码文件和头文件。
2. 编写链接库文件的构建脚本。这通常是一个makefile或CMakeLists.txt文件。
3. 在构建脚本中指定链接库的输出文件名和格式。对于Windows平台，链接库文件通常是一个.dll文件，对于Linux和macOS平台，链接库文件通常是一个.so文件。
4. 编译和链接源代码文件，生成链接库文件。具体的编译和链接命令可能因平台而异。

下面是一个简单的示例Makefile文件，用于构建一个实现add函数的链接库：
```mermaid C
CC = gcc
CFLAGS = -c -Wall
LDFLAGS = -shared
SOURCES = add.c
OBJECTS = $(SOURCES:.c=.o)
LIBRARY = libexample.so

all: $(SOURCES) $(LIBRARY)

$(LIBRARY): $(OBJECTS)
        $(CC) $(LDFLAGS) $(OBJECTS) -o $@

.c.o:
        $(CC) $(CFLAGS) $< -o $@

clean:
        rm -f $(OBJECTS) $(LIBRARY)
```
这个Makefile文件假定add.c是实现add函数的源文件。要构建链接库，可以在命令行上运行“make all”命令。这将编译和链接源代码，并生成一个名为libexample.so的链接库文件。要清除目标文件和链接库文件，可以运行“make clean”命令。

要在Windows上编译链接库，可以使用Visual Studio或MinGW等开发工具。安装MinGW开发环境，并确保将安装目录添加到系统PATH环境变量中。
> gcc -fPIC -shared add.c -o example.dll

**运行命令**
> javac -cp javacpp.jar ExampleLibrary.java
> 
> java -jar javacpp.jar ExampleLibrary
> 
> java -cp javacpp.jar ExampleLibrary

javacpp.jar需要自行下载。