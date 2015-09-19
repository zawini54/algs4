#include "BinaryHeap.h"

BinaryHeap::BinaryHeap(int len){
    li = 1;
    this->len = len;
    heap = (int*) calloc(len+1, sizeof(int));
}

void BinaryHeap::add(int val){
    heap[li] = val;
    swim(li);
    li++;
}

void BinaryHeap::delMax(){
    exch(1, len);
    len--;
    sink(1);

}

void BinaryHeap::swim(int index){
    while(heap[index] > heap[index/2] && index > 1){ // comparison with > because elements are integers
	// exchange operation
	exch(index, index/2);
	index /= 2;
    }
}

void BinaryHeap::sink(int index){
    while(heap[index] < heap[2*index] && heap[index] < heap[2*index+1] && index < len){
	int j = 2*index;
	if(heap[j+1] > heap[j]) j++;
	exch(index, j);
	index = j;
    }
}

void BinaryHeap::exch(int a, int b){
    int holder = heap[a];
    heap[a] = heap[b];
    heap[b] = holder;
}

void BinaryHeap::show(){
    for(int i = 1; i <= len; i++){
	printf("%d:%d\n", i, heap[i]);
    }
}

