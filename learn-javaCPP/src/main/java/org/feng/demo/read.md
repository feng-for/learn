# 静态库的制作与使用
## 使用gcc编译add.c，生成add.o
> gcc -c add.c

## 使用ar命令生成静态库libadd.a
> ar -cr libadd.a add.o

## 使用gcc编译main.c，生成可执行文件
> gcc main.c libadd.a -o test.exe
> 
> or 
> 
> gcc main.c -ladd -L./ -o test.exe

注意：在命令gcc main.c -ladd -L./ -o test.exe中，-l代表使用的库，由于编译器会按照lib<库名>.a的规则进行搜索，因此这里只需要给出add即可，-L用来指定附加库文件的搜索路径，此处.\代表当前目录。

## 执行test.exe测试
> test.exe
