#include<iostream>
#include"NativeLibrary.h"

using namespace NativeLibrary;

int main(){
	MyFunc myFunc;
	int value = myFunc.add(1, 2);
	std::cout << "add value " << value << std::endl;
	return 0;
}
