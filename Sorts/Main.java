public class Main{
  public static void main(String[] args){
    String[] sarr = {"d", "a", "c", "b", "t", "e", "j", "n", "g", "q", "s", "r", "p", "o", "f"};
    Bubble.sort(sarr);
    show(sarr);
  }

  public static void show(Comparable[] list){
    for(Comparable c: list){
      System.out.println(c);
    }
  }
}
