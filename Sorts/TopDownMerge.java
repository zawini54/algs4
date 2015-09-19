public class TopDownMerge {

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
      Util.merge(a, aux, lo, mid, hi);
  }
}
