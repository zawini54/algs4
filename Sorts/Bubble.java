public class Bubble{

  public static void sort(Comparable[] c){
    int k = 0;
    while(true){
      boolean err_seen = false;
      for(int i = 0; i < c.length-1-k; i++){
        if(Util.less(c[i+1], c[i])){
          err_seen = true;
          Util.exch(c, i, i+1);
        }
      }
      k++;
      if(!err_seen) break;
    }
  }

}
