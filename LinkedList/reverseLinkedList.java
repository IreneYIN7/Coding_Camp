package LinkedList;

public class reverseLinkedList {
    public class ListNode {
        public int value;
        public ListNode next;
        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }
    public ListNode reverse(ListNode head) {
        // Write your solution here
    
        // base case
        if(head == null || head.next == null) return head;
    
        // recursive case:
        // note: key point is value by reference 
        ListNode reversed = reverse(head.next); // treat head.next as a single listNode.
        head.next.next = head;
        head.next = null;
        return reversed;
      }
    
}
