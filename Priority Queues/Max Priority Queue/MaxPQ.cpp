#include "MaxPQ.h"

MaxPQ::MaxPQ(int n)
{
    queue = new int[n];
    length = n;
    index = 0;
}

void MaxPQ::insert(int i)
{
    if(index < length)
    {
        queue[index] = i;
        index++;
    }
    else
    {
        printf("Ran out of spaces\n");
    }
}

int MaxPQ::delMax()
{
    int largest = 0;
    int li = 0;
    for(int i = 0; i <= index; i++)
    {
        if (queue[i] > largest){
            largest = queue[i];
            li = i;
        }
    }
    queue[li] = 0;
    return largest;
}

void MaxPQ::show()
{
    for(int i = 0; i < length; i++){
        printf("%d\n", queue[i]);
    }
}

bool MaxPQ::isEmpty()
{
    bool foundNZ = false;
    for(int i = 0; i < length; i++) // length not defined
    {
        if (i != 0) foundNZ = true;
    }
    return foundNZ;
}
