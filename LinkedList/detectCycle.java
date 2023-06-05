package LinkedList;

public class detectCycle {
    public class ListNode {
        public int value;
        public ListNode next;
        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head){
        // use slow and fast pointer. 
        // the point where fast and slow meet : P
        // (a-b)C -- 整数圈 for slow pointer. 
        // then let slow start from P and another pointer start from the start Point, 
        // when they meet, it's the start of the cycle 

        
    }
    
}
