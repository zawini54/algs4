import java.util.*;

public class Selection {

  public static void sort(Comparable[] list){
    for(int a = 0; a < list.length; a++){
      int smallest = a; // if 0, then the value will be persistent
      for(int i = a+1; i < list.length; i++){ // a+1 because smallest is already a
          if(Util.less(list[i], list[smallest])){
              smallest = i; // order matters, since it works from right to left. If i = smallest then it will reset iterator
          }
      }
      Util.exch(list, a, smallest);
    }
  }

}
