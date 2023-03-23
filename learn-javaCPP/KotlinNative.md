# Kotlin Native 调用C语言的简单示例
## 环境最要命，所有一切的症结都在C环境，编译器版本，一定要用C的编译器运行
**需要了解知识**
> gcc 
> 
> clang
> 
> llvm
1. 下载并编译Kotlin native https://github.com/JetBrains/kotlin-native
2. 创建hello.h文件，在其中输入如下代码
```mermaid C
void sayHello();
```
3. 创建hello.c文件，在其中输入如下代码
```mermaid C
#include "hello.h"
#include <stdio.h>
    
void sayHello(){
    printf("Hello Kotlin Native\n");
}
```
4. 创建hello.def文件，在其中输入如下代码
> headers = hello.h
> 
> headerFilter = hello.h

在默认情况下cinterop会分析引入所有的头文件，而此时并无必要，所以配置headerFilter属性为hello.h目的是只分析引入该文件
5. 执行如下命令用以分析hello.h文件，并自动生成kotlin定义
> cinterop -def hello.def -compiler-option -IC:\\Users\\Fengzhiwei\\Documents\\test\learn\\native-demo\\ -o hello

其中-I指的是头文件目录，-o指的是输出名字，该命令执行后将生成目录结构如下图所示
6. 执行如下命令用于生成本机库(native library)文件
> clang -c hello.c -o hello.bc -emit-llvm

该命令将生成hello.bc文件，如下图所示
7. 创建main.kt文件，在其中输入如下代码
```mermaid kotlin
 import hello.*
    
 fun main(args: Array<String>) {
     sayHello()
 }
```
8. 执行如下命令编译该程序
> kotlinc-native main.kt -library hello -native-library hello.bc -o main