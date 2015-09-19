//Good for small arrays

public class Shell {

  public static void sort(Comparable[] list){
    int diff = 1;
    while(diff < list.length/3) {
      diff = 3*diff + 1; // 1, 4, 13, 40, 121, etc.
    }
    while(diff >= 1){
      for(int i = diff; i < list.length; i++){
        for(int j = i; j >= diff && Util.less(list[j], list[j-diff]); j -= diff){
          /*
          >= because it can reach index zero
          Can stop loop at !Util.less(...) because the pairs before were already sorted
          */
          Util.exch(list, j, j-diff);
        }
      }
      diff = (diff-1)/3;
    }
  }

}
