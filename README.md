# Algorithms Part 1

### Quick Find and Quick Union
* Quick Find
* Quick Union

### Data Structures
* Stacks
* Queues

### Sorts
* Selection Sort
* Insertion Sort
* Shell Sort
* Merge Sort
* Quick Sort

### Priority Queues
* Elementary Implementations
* Binary Heap

***

Top down merge sort and quick sort might be a little confusing because of recursion, so I will be explaining them here.

**Top down merge sort:**
```java
public static void merge(...){...}

public static void sort(Comparable[] a) {
    Comparable[] aux = new Comparable[a.length];
    sort(a, aux, 0, a.length-1);
}

  //recursive function
private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
    if (hi <= lo) return;
    int mid = lo + (hi - lo) / 2;
    sort(a, aux, lo, mid);
    sort(a, aux, mid + 1, hi);
    merge(a, aux, lo, mid, hi);
}
```
This is what happens:<br>
**Note: This will/might change for arrays with different lengths!**
```
[xxxxxxxxxx]sort
[xxxxx]sort(lo, mid)
[xxx]sort(lo, mid)
[xx]sort(lo, mid)
[x]sort(lo, mid) - ignore
 [x]sort(mid+1, hi) - ignore
[xx]merge
  [x]sort(mid+1, hi) - ignore
[xxx]merge
   [xx]sort(mid+1, hi)
   [x]sort(lo, mid) - ignore
    [x]sort(mid+1, hi) - ignore
   [xx]merge
[xxxxx]merge
     [xxxxx]sort(mid+1, hi)
     [xxx]sort(lo, mid)
     [xx]sort(lo, mid)
     [x]sort(lo, mid) - ignore
      [x]sort(mid+1, hi) - ignore
     [xx]merge
       [x]sort(mid+1, hi) - ignore
     [xxx]merge
        [xx]sort(mid+1, hi)
        [x]sort(lo, mid) - ignore
         [x]sort(mid+1, hi) - ignore
        [xx]merge
     [xxxxx]merge
[xxxxxxxxxx]merge
```


The first line stops the recursion because once the highest index becomes the same as the lowest index, then that means that the subarray size is zero and we cannot sort it, so we simply return the function.

**A practical example:**

Let's say we have an array of random alphabetical characters:

[g, a, d, y, n, h, r, f, o, q]

First, we divide the array in half. In this case, the lowest index is 0 and the highest index is 9. Therefore the middle index is 4, since Java rounds 4.5 down to 4 (mid = (hi-lo)/2). Then, we call the same function from inside the function (kind of like a hierarchy), but we halve the subarray size, since we pass in the middle index as the highest index argument. Now we get:

[g, a, d, y, n]

Havle it again:

[g, a, d]

And again:

[g, a]

When the function calls itself again, the highest index is now the same as the lowest index. Therefore the function returns, as mentioned above. If it didn't return, then the array would be just [g] with only one element.

Now the function calls itself for the other half, which is [a]. This call also returns. Then, we merge [g, a] to get [a, g].

Again, the function calls itself, but this time, it calls itself on the other half of [g, a, d], which happens to be [d]. However, this subarray has only one element, which means the function returns.

Finally, we merge [a, g, d] to get [a, d, g]. Yes, the first two elements are already sorted because before each merge, the actual list is copied into the auxiliary array. This means that if we merge two elements, those two elements will still stay sorted. Repeat this process for the rest of the array (according to the program structure above).
Remember, that the strucuture changes for different lengths of arrays.
