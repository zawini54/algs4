public class Util {
  public static void exch(Comparable[] a, int i, int j){
      Comparable icopy = a[i];
      a[i] = a[j];
      a[j] = icopy;
  }

  public static boolean less(Comparable a, Comparable b){
      return a.compareTo(b) < 0;
  }

  public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
    int i = lo, j = mid+1;
    for(int b = lo; b <= hi; b++){
      aux[b] = a[b];
    }
    for(int c = lo; c <= hi; c++){
      if (i > mid)     a[c] = aux[j++];
      else if (j > hi) a[c] = aux[i++];
      else if (Util.less(aux[j], aux[i])) a[c] = aux[j++];
      else a[c] = aux[i++];
    }
  }
}
