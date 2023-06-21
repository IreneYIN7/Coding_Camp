package StackQueue;
import java.util.*;
public class stackByQueue {
    private Deque<Integer> queue;
    /** Initialize your data structure here. */
    public stackByQueue() {
       // using queue -> stack
       // Queue FIFO, stack FILO
       //  q1      
       // 3 2 1    
       queue = new ArrayDeque<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
      queue.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public Integer pop() {
      if(queue.isEmpty()) return null;
      int size = queue.size();
      while(--size != 0){ // while(size -- > 0) wrong
        queue.offer(queue.poll());
      }
      return queue.poll(); // 
      // [3,2,1] size = 3
      // [2,1,3] size = 2
      // [1,2,3] size = 1 - wrong
      // // while(size -- > 1)
        
    }

    /** Get the top element. */
    public Integer top() {
        if(queue.isEmpty()) return null;
        int topE = pop();
        queue.offer(topE);
        return topE;
    }

    /** Returns whether the stack is empty. */
    public boolean isEmpty() {
      return queue.isEmpty();
    }
    
}
