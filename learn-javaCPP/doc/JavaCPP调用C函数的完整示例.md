# JavaCPP调用C函数的完整示例
## 环境最要命，所有一切的症结都在C环境，编译器版本、一定要用C的编译器运行
## 添加依赖
* Maven (inside the `pom.xml` file)
```xml
  <dependency>
    <groupId>org.bytedeco</groupId>
    <artifactId>javacpp</artifactId>
    <version>1.5.8</version>
  </dependency>
```
## 访问本地api
最常见的用例包括访问一些为c++编写的本机库，例如，在名为`NativeLibrary.h`的文件中包含以下c++类:
```cpp
#include <string>

namespace NativeLibrary {
    class NativeClass {
        public:
            const std::string& get_property() { return property; }
            void set_property(const std::string& property) { this->property = property; }
            std::string property;
    };
}
```
**用JavaCPP完成工作**
```java
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

@Platform(include="NativeLibrary.h")
@Namespace("NativeLibrary")
public class NativeLibrary {
    public static class NativeClass extends Pointer {
        static { Loader.load(); }
        public NativeClass() { allocate(); }
        private native void allocate();

        // to call the getter and setter functions 
        public native @StdString String get_property(); public native void set_property(String property);

        // to access the member variable directly
        public native @StdString String property();     public native void property(String property);
    }

    public static void main(String[] args) {
        // Pointer objects allocated in Java get deallocated once they become unreachable,
        // but C++ destructors can still be called in a timely fashion with Pointer.deallocate()
        NativeClass l = new NativeClass();
        l.set_property("Hello World!");
        System.out.println(l.property());
    }
}
```
我们需要在执行它之前使用JavaCPP进行构建，我们可以让它像下面这样做:
```bash
$ java -jar javacpp.jar NativeLibrary.java -exec
Hello World!
```