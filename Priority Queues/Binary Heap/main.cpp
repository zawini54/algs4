#include "BinaryHeap.h"

int main(){
    BinaryHeap *b = new BinaryHeap(5);
    for(int i = 0; i < 5; i++){
	int a;
	scanf("%d", &a);
	b->add(a);
    }
    b->delMax();
    b->show();
}
