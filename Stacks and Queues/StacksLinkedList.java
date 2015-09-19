import java.util.*;

public class StacksLinkedList{

  public static void main(String[] args){
    Stack<Integer> s = new Stack<>();
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    s.pop();
    // prints from newest to oldest
    for(int i : s){
      System.out.println(Integer.toString(i));
    }
  }

}
// linked list implementation
class Stack<Item> implements Iterable<Item>{

    Node first = null;

    class Node{
        Item item;
        Node next;
    }

    private class ListIterator implements Iterator<Item>{
      private Node current = first; // initiation

      public boolean hasNext(){
        return current != null; //current is still unknown after method next()
      }

      public Item next(){
        Item item = current.item;
        current = current.next;
        return item;
      }
      public void remove(){}
    }

    public void push(Item item){
        Node oldfirst = first; // save the oldfirst for later use
        first = new Node(); // override first
        first.item = item; // set first to new item
        first.next = oldfirst; // set first's pointer to the oldfirst; the oldfirst moves back.
    }
    public Item pop(){
        Item item = first.item;
        first = first.next; // only line that matters here. first.next points to node object in memory
        return item; // returns so can print to screen
    }

    public Iterator<Item> iterator(){
      return new ListIterator();
    }
}
