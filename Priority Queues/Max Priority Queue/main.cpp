#include "MaxPQ.h"
using namespace std;

int main()
{
    MaxPQ m(7);
    m.insert(3);
    m.insert(4);
    m.delMax();
    m.show();
    return 0;
}
