#ifndef MAXPQ_H
#define MAXPQ_H

#include <stdio.h>

using namespace std;

class MaxPQ
{
private:
    int *queue;
    int index;
    int length;
public:
    MaxPQ(int n);
    void insert(int i);
    int delMax();
    bool isEmpty();
    void show();
};

#endif
