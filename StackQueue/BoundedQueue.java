package StackQueue;

/*
 * Implement Queue2 by using bounded Array
 * 物理意义：
 * head: 永远指向Queue的头部，第一个element head = 0
 * tail: 永远指向Queue的尾部，第一个可以被赋值的element index
 */
public class BoundedQueue {

    private int[] queue;
    private int size;
    private int head;
    private int tail;

    public BoundedQueue(int capacity){
        queue = new int[capacity];
        size  = 0;
        head = 1;
        tail = 0;
    }

    public int size(){
        return size;
    }
    
    /*
     * 
     */
    public Boolean poll(){
        return true;
    }
    
    /*
     * 
     */
    public Integer peek(){
        return -1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

}
