package LinkedList;

public class ifHasCycle {
    public class ListNode {
        public int value;
        public ListNode next;
        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        // write your solution here
        //用快慢指针，如果快指针和慢指针相等，则有cycle
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
          slow = slow.next;
          fast = fast.next.next;
          if(slow == fast) return true;
        }
        return false;
      }
    
}
