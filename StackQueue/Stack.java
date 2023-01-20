package StackQueue;

/*
 * Implement Stack API using LinkedList;
 */
public class Stack {

    private ListNode top;
    private int size;

    // Constructors
    public Stack() {
        top = null;
        size = 0; 
    }

    public Stack(int topValue) {
        top = new ListNode(topValue);
        size = 1;
    }

    public Integer pop(){
        if (isEmpty()) return null;
        ListNode oldTop = top;
        ListNode newTop = top.next;

        oldTop.next = null;
        top = newTop;
        size--;
        return oldTop.value;
    }


        
    public Integer peek() {
        if (isEmpty()) return null;
    
        return top.value;
    }
    

    public void push(int value){
        ListNode newTop = new ListNode(value);
        newTop.next = top;
        top = newTop;
        size ++;
        
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args){
        Stack test = new Stack();
        test.push(0);
        System.out.println(test.peek());

    }
}
