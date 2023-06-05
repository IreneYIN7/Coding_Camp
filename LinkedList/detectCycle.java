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
        // corner case:
        if(head == null || head.next == null) return null;
        // find the point
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(fast == null || fast.next == null) return null;

        ListNode result = head;
        while(result != slow){
            slow = slow.next;
            result = result.next;
        }

        return result;

    }
    
}
