# learn-jni

# libc 、glibc的关系
libc 和 glibc都是Linux系统下的C函数库。libc是Linux系统下的ASIN C函数库，glibc是Linux系统下的GUN C函数库。

ANSI C 函数库是基本的 C 语言函数库，包含了 C 语言最基本的库函数。
> 1. <ctype.h>：包含用来测试某个特征字符的函数的函数原型，以及用来转换大小写字母的函数原型；
> 2. <errno.h>：定义用来报告错误条件的宏；
> 3. <float.h>：包含系统的浮点数大小限制；
> 4. <math.h>：包含数学库函数的函数原型；
> 5. <stddef.h>：包含执行某些计算 C 所用的常见的函数定义；
> 6. <stdio.h>：包含标准输入输出库函数的函数原型，以及他们所用的信息；
> 7. <stdlib.h>：包含数字转换到文本，以及文本转换到数字的函数原型，还有内存分配、随机数字以及其他实用函数的函数原型；
> 8. <string.h>：包含字符串处理函数的函数原型；
> 9. <time.h>：包含时间和日期操作的函数原型和类型；
> 10. <stdarg.h>：包含函数原型和宏，用于处理未知数值和类型的函数的参数列表；
> 11. <signal.h>：包含函数原型和宏，用于处理程序执行期间可能出现的各种条件；
> 12. <setjmp.h>：包含可以绕过一般函数调用并返回序列的函数的原型，即非局部跳转；
> 13. <locale.h>：包含函数原型和其他信息，使程序可以针对所运行的地区进行修改。
> 14. 地区的表示方法可以使计算机系统处理不同的数据表达约定，如全世界的日期、时间、美元数和大数字；
> 15. <assert.h>：包含宏和信息，用于进行诊断，帮助程序调试。

glibc本身是GNU旗下的C标准库，后来逐渐成为了Linux的标准c库，而Linux下原来的标准c库Linux libc逐渐不再被维护。Linux下面的标准c库不仅有这一个，如uclibc、klibc，以及上面被提到的Linux libc，但是glibc无疑是用得最多的。glibc在/lib目录下的.so文件为libc.so.6。glibc函数库是一种类似于第三方插件的东西。由GUN 组织开发以便让我们更好的利用 C 语言开发基于 Linux 操作系统的程序。 不过现在的不同的 Linux 的发行版本对这两个函数库有不同的处理方法，有的可能已经集成在同一个库里了。

**另外微软也有自己libc的实现，叫 msvcrt**

# JavaCV, JavaCPP,和JavaCPP Presets的关系
JavaCV是对各种常用计算机视觉库的封装后的一组jar包，其中封装了ffmpeg、OpenCV、libdc1394、OpenKinect、videoInput和ARToolKitPlus等计算机视觉编程人员常用库的接口，可以通过其中的utility类方便的在包括Android在内的Java平台上调用这些接口。

JavaCPP提供了在Java中高效访问本地C++的方法。采用JNI技术实现，支持所有Java实现包括Android系统，Avian 和 RoboVM。JavaCPP提供了一系列的Annotation将Java代码映射到C++代码，并使用一个可执行的jar包将C++代码转化为可以从JVM内调用的动态链接库文件。

JavaCPP Presets 包括了java配置及一些被广泛应用的C/C++库接口。