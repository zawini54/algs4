class QueuesArray{
  public static void main(String[] args){
    Queue<String> q = new Queue<>();
    String string = "hi i am schwinn - - - hi - there are two birds - - - who is that - - i am schwinn";
    String[] splitted = string.split(" ");
    for(String s: splitted){
      if(s.equals("-")){
        q.dequeue();
      }else{
        q.enqueue(s);
      }
    }
    for(Object item: q.queue)
      System.out.println(item.toString());
  }
}

class Queue<Item>{

  //structure: <-[]<-

  Object[] queue;
  int first_index = 0;
  int last_index = 0;
  int items = 0;

  public Queue(){
    queue = (Item[]) new Object[1];
  }

  public void enqueue(Item item){
    int new_length = queue.length * 2; // items + Math.round(items/2) + 1;
    // + 1 because items is initially 0. First enqueue will not work otherwise.
    if(last_index == queue.length)
      copy_new(new_length);
    queue[last_index] = item;
    last_index++;
    items++;
  }

  public void dequeue(){
    if(first_index > last_index)
      return;
    queue[first_index] = null;
    if(items <= queue.length/2){
      copy_new(items + Math.round(items/2));
    }
    if(first_index < last_index){
      first_index++;
      items--;
    }else if (first_index == last_index){
      first_index = 0;
      items = 0;
    }
  }

  public void copy_new(int length){
    Object[] oldqueue = (Item[]) queue;
    queue = (Item[]) new Object[length];
    int i = 0;
    int newqueue_index = 0;
    boolean ranout = false;
    boolean hasbeennull = false;
    boolean hasbeennonnull = false;
    while(!ranout && i < oldqueue.length){
      if(oldqueue[i] != null){
        queue[newqueue_index] = oldqueue[i];
        newqueue_index++;
        hasbeennonnull = true;
      }else{
        if(hasbeennull && hasbeennonnull){
          ranout = true;
        }else{
          hasbeennull = true;
        }
      }
      i++;
    }
    last_index = newqueue_index;
    first_index = 0;
  }
  /*
  [null, null, null, 1, 2, 3, 4, 5, null, null] there will never be a space in the middle.
  Therefore, this is the only possible format of the array.
  */
}
