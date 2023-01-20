package StackQueue;

/*
 * Implement Queue by using LinkedList 
 */
public class Queue {
    private ListNode head;
    private int size;
    private ListNode tail;


    public Queue(){
        head = null; // default is null, not needed/necessary.
        size = 0;
        tail = null; // default is null, not needed/necessary.

    }
    public Queue(int value){
        head = new ListNode(value);
        size = 1;
        tail = head;
    }

    /*
     * If not empty, return the first one and size --;
     */
    public Integer poll(){
        if(!isEmpty()){
            if(size == 1){
                Integer val = head.value;
                size --;
                tail = null;
                head = null;
                return val;
            }
            ListNode oldHead = head;
            head = head.next;
            size --;
            return oldHead.value;
        }
        return null;

    }
    

    public void offer(int value){
        ListNode newVal = new ListNode(value);
        if(isEmpty()){
            head = newVal;
            tail = newVal;
            
        }
        else {
            tail.next = newVal;
            tail = newVal;
        }

        size ++;

    }

    public Integer peek(){
        if(!isEmpty()) return head.value;
        return null;

    }
    
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
}
