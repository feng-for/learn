#include <stdio.h>
#include "add.h"

int main()
{
    int a = 10;
    int b = 20;
    int c;
    c = add(a, b);
    printf("c = %d\n", c);
    return 0;
}
