public class BottomUpMerge {

  public static void sort(Comparable[] list){
    int N = list.length;
    Comparable[] aux = new Comparable[N];
    for(int sz  = 1; sz < N; sz *= 2){ // goes through the sizes of 2^x
      for(int lo = 0; lo < N-sz; lo += sz*2){ // goes through the array in increments of sz*2 (merged array size)
        Util.merge(list, aux, lo, lo+sz-1, Math.min(lo+sz*2-1, N-1)); // min bc arrayoutofboundsexception
      }
    }
  }

}
