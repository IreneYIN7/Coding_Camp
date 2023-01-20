package StackQueue;

/**
 * Stack API using Array
 * 物理意义： head: 永远指向Stack的顶部，第一个有意义的element -- head starts with -1.
 * 
 */
public class Stack2 {
    private int[] stack;
    private int head = -1;
    private int size = 0;

    public Stack2(){
        size = 0;
        head = -1;
    }
    
    public Stack2(int value, int capacity){
        stack = new int[capacity];
        size ++;
        head ++;
    }

    /*
     * if not empty, return head value, head --
     * else return null.
     */
    public Integer pop(){
        if(!isEmpty()) return stack[head--];
        return null;

    }

    /*
     * if stack is not full:
     * add the value at the end of the Array, move head ++;
     */
    public boolean push(int value){
          if(stack.length < size +1){
            head++;
            stack[head] = value;
            return true;
        }
        return false;

    }

    public int size(){
        return head++;
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }
}
