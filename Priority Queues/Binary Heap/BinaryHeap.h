#include <iostream>
#include <vector>
using namespace std;

class BinaryHeap{
public:
    BinaryHeap(int len);
    void add(int n);
    void delMax();
    void show();
private:
    int * heap; // elements are integers
    int len;
    int li;
    void swim(int index);
    void sink(int index);
    void exch(int a, int b);
};
