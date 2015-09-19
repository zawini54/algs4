public class QuickSort {

  public static void sort(Comparable[] list, int lo, int hi){
    if(hi <= lo) return;
    int j = partition(list, lo, hi);
    sort(list, lo, j);
    sort(list, j+1, hi);
  }


  private static int partition(Comparable[] list, int lo, int hi){
    int i = lo;
    int j = hi+1;
    Comparable k = list[lo];

    while(true){
      while(Util.less(list[++i], k)){ // ++i bc lo is partition element and we dont want that
        if (i == hi) continue;
      }

      while(Util.less(k, list[--j])){
        if (j == lo) continue;
      }

      if(i >= j) break;

      Util.exch(list, i, j);
    }

    Util.exch(list, lo, j);
    return j;
  }

}
