//Good when array is already partially sorted

public class Insertion {

  public static void sort(Comparable[] list){
    for(int i = 1; i < list.length; i++){ // starts at 1 because starting at 0 does nothing anyways; waste of resources
      for(int j = i; j > 0; j--){ // set = i and 0 because otherwise there will be ArrayOutOfBoundsException
        if(Util.less(list[j], list[j-1])){ // use j here because i is persistent
          Util.exch(list, j, j-1); // j and j-1 because i is persistent
        }else{
          break;
        }
      }
    }
  }
  
}
