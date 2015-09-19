public class QueuesLinkedList{
  public static void main(String[] args){
    Queue<String> q = new Queue<>();
    q.enqueue("hi");
    q.enqueue("i");
    q.enqueue("am");
    q.dequeue();
    System.out.println(q.first.item.toString());
    System.out.println(q.last.item.toString());
  }
}

class Queue<Item>{

  Node first, last = null;

  class Node {
    Item item;
    Node next;
  }
  public void enqueue(Item item){
    //check
    Node oldlast = last;
    last = new Node();
    last.item = item;
    last.next = null;
    if (first == null){
      first = last;
    }else{
      oldlast.next = last; // if no if statement then it will throw null pointer exception
      //layout = [first]->[last]
    }
  }

  public void dequeue(){
    if(first != null && last != null){
      first = first.next;
    }
  }
}
