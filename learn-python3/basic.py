# list
list1 = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h']
# tuple
tuple1 = ('a', 'b', 'c', 'd', 'e')
# set
set1 = {'a', 'b', 'c', 'd', 'e'}
# dict
dict1 = {'a': 1, 'b': 2, 'c': 3, 'd': 4, 'e': 5, 'f': 6}
# 可变对象 lsit set dict 不可变对象 tuple int float str

price = 3200
i = int(input('请输入价格：'))
while True:
    if i < price:
        print('价格不足')
        i = int(input('请输入价格：'))
    elif i > price:
        print('价格过高')
        i = int(input('请输入价格'))
    else:
        break
print('恭喜猜对了')

# 字符串索引、切片
# 切片的语法：[起始:结束:步长] 字符串[start: end: step] 这三个参数都有默认值，默认截取方向是从左往右的 start:默认值为0； end : 默认值未字符串结尾元素； step : 默认值为1；
# 如果切片步长是负值，截取方向则是从右往左的
string = 'Hello world!'
string[2]
string[2:5]
string[3:]
string[8:2:-1]

# 列表生成式
# 1-10之间所有数的平方 
listR = [(n+1)**2 for n in range(10)]
print(listR)
# 1-10之间所有数的平方 构成的字符串列表
listStr = [str((n+1)**2) for n in range(10)]
print(listStr)
[ print(f'我是：{i}') for i in range(10) if i % 2 == 0 ]

# 在 python 中，类型属于对象，对象有不同类型的区分，变量是没有类型的：
a=[1,2,3]
a="Runoob"
# 以上代码中，[1,2,3] 是 List 类型，"Runoob" 是 String 类型，而变量 a 是没有类型，她仅仅是一个对象的引用（一个指针）
# 可以是指向 List 类型对象，也可以是指向 String 类型对象。

# 可更改(mutable)与不可更改(immutable)对象
# 在 python 中，strings, tuples, 和 numbers 是不可更改的对象，而 list,dict 等则是可以修改的对象。
#   不可变类型：变量赋值 a=5 后再赋值 a=10，这里实际是新生成一个 int 值对象 10，再让 a 指向它，而 5 被丢弃，不是改变 a 的值，相当于新生成了 a。
#   可变类型：变量赋值 la=[1,2,3,4] 后再赋值 la[2]=5 则是将 list la 的第三个元素值更改，本身la没有动，只是其内部的一部分值被修改了。
# python 函数的参数传递：
#   不可变类型：类似 C++ 的值传递，如整数、字符串、元组。如 fun(a)，传递的只是 a 的值，没有影响 a 对象本身。如果在 fun(a) 内部修改 a 的值，则是新生成一个 a 的对象。
#   可变类型：类似 C++ 的引用传递，如 列表，字典。如 fun(la)，则是将 la 真正的传过去，修改后 fun 外部的 la 也会受影响
# python 传不可变对象实例
def change(a):
    print(id(a))   # 指向的是同一个对象
    a=10
    print(id(a))   # 一个新对象
a=1
print(id(a))
change(a)
# 以上输出结果
# 4379369136
# 4379369136
# 4379369424
# 传可变对象实例
def changeme( mylist ):
   "修改传入的列表"
   mylist.append([1,2,3,4])
   print ("函数内取值: ", mylist)
   return
# 调用changeme函数
mylist = [10,20,30]
changeme( mylist )
print ("函数外取值: ", mylist)
# 传入函数的和在末尾添加新内容的对象用的是同一个引用。故输出结果如下：
# 函数内取值:  [10, 20, 30, [1, 2, 3, 4]]
# 函数外取值:  [10, 20, 30, [1, 2, 3, 4]]

# 参数
#   必需参数
#   关键字参数
#   默认参数
#   不定长参数


# Python 使用 lambda 来创建匿名函数。
# lambda 只是一个表达式，函数体比 def 简单很多。
# lambda 的主体是一个表达式，而不是一个代码块。仅仅能在 lambda 表达式中封装有限的逻辑进去。
# lambda 函数拥有自己的命名空间，且不能访问自己参数列表之外或全局命名空间里的参数。
# 虽然 lambda 函数看起来只能写一行，却不等同于 C 或 C++ 的内联函数，后者的目的是调用小函数时不占用栈内存从而增加运行效率。
# lambda 函数的语法只包含一个语句
# lambda [arg1 [,arg2,.....argn]]:expression
x = lambda a : a + 10
print(x(5))

sum = lambda arg1, arg2: arg1 + arg2
# 调用sum函数
print ("相加后的值为 : ", sum( 10, 20 ))
print ("相加后的值为 : ", sum( 20, 20 ))


# 可以把列表当做队列用，只是在队列里第一加入的元素，第一个取出来；但是拿列表用作这样的目的效率不高。在列表的最后添加或者弹出元素速度快，
# 然而在列表里插入或者从头部弹出速度却不快（因为所有其他的元素都得一个一个地移动）。
from collections import deque
queue = deque(["Eric", "John", "Michael"])
queue.append("Terry")           # Terry arrives
queue.append("Graham")          # Graham arrives
queue.popleft()                 # The first to arrive now leaves
# 'Eric'
queue.popleft()                 # The second to arrive now leaves
# 'John'
queue                           # Remaining queue in order of arrival
deque(['Michael', 'Terry', 'Graham'])

# 列表可以很方便的作为一个堆栈来使用，堆栈作为特定的数据结构，最先进入的元素最后一个被释放（后进先出）。用 append() 方法可以把一个元素添加到堆栈顶。
# 用不指定索引的 pop() 方法可以把一个元素从堆栈顶释放出来。例如：
stack = [3, 4, 5]
stack.append(6)
stack.append(7)
stack
# [3, 4, 5, 6, 7]
stack.pop()
# 7
stack
# [3, 4, 5, 6]
stack.pop()
# 6
stack.pop()
# 5
stack
# [3, 4]


# 使用 del 语句可以从一个列表中根据索引来删除一个元素，而不是值来删除元素。这与使用 pop() 返回一个值不同。可以用 del 语句从列表中删除一个切割，
# 或清空整个列表（我们以前介绍的方法是给该切割赋一个空列表）。例如：
a = [-1, 1, 66.25, 333, 333, 1234.5]
del a[0]
a
# [1, 66.25, 333, 333, 1234.5]
del a[2:4]
a
# [1, 66.25, 1234.5]
del a[:]
a
# []


# 类定义
class people:
    # 定义基本属性
    name = ''
    age = 0
    # 定义私有属性
    __weight = 0
    def __init__(self, name, age, w):
        self.name = name
        self.age = age
        self.__weight = w
    def speak(self):
        print(f'{self.name} speak: my age is {self.age}!')
# 实例化类
p = people('雏田', 18, 1)
p.speak()

# 类属性与方法
#   类的私有属性
#   __private_attrs：两个下划线开头，声明该属性为私有，不能在类的外部被使用或直接访问。在类内部的方法中使用时 self.__private_attrs。

#   类的方法
#   类的内部，使用 def 关键字来定义一个方法，与一般函数定义不同，类方法必须包含参数 self，且为第一个参数，self 代表的是类的实例。
#   self 的名字并不是规定死的，也可以使用 this，但是最好还是按照约定使用 self。

#   类的私有方法
#   __private_method：两个下划线开头，声明该方法为私有方法，只能在类的内部调用 ，不能在类的外部调用。self.__private_methods。
# 类的私有属性
class JustCounter:
    __secretCount = 0  # 私有变量
    publicCount = 0    # 公开变量
 
    def count(self):
        self.__secretCount += 1
        self.publicCount += 1
        print (self.__secretCount)
counter = JustCounter()
counter.count()
counter.count()
print (counter.publicCount)
print (counter.__secretCount)  # 报错，实例不能访问私有变量
# 类的私有方法
class Site:
    def __init__(self, name, url):
        self.name = name       # public
        self.__url = url   # private
 
    def who(self):
        print('name  : ', self.name)
        print('url : ', self.__url)
 
    def __foo(self):          # 私有方法
        print('这是私有方法')
 
    def foo(self):            # 公共方法
        print('这是公共方法')
        self.__foo()
x = Site('菜鸟教程', 'www.runoob.com')
x.who()        # 正常输出
x.foo()        # 正常输出
x.__foo()      # 报错


# 类的专有方法：
# __init__ : 构造函数，在生成对象时调用
# __del__ : 析构函数，释放对象时使用
# __repr__ : 打印，转换
# __setitem__ : 按照索引赋值
# __getitem__: 按照索引获取值
# __len__: 获得长度
# __cmp__: 比较运算
# __call__: 函数调用
# __add__: 加运算
# __sub__: 减运算
# __mul__: 乘运算
# __truediv__: 除运算
# __mod__: 求余运算
# __pow__: 乘方