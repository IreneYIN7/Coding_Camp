package Recursion;
import java.security.Principal;
import java.util.*;

public class reverseLinkedListInPairs {
    
    public class ListNode {
        public int value;
        public ListNode next;
        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }
    /**
     * Reverse pairs of elements in a singly-linked list.
     * eg: 
     * L = 1 -> 2 -> 3 -> null, after reverse is 2 -> 1 -> 3 -> null
     * L = 1 -> 2 -> null, after reverse is 2 -> 1 -> null
     * 
     * use recursion to solve the subproblem
     */
    public ListNode reverseInPairs(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        ListNode reversed = reverseInPairs(head.next.next);
        dummy.next = head.next;
        dummy.next.next = head; // if you don't record the reversed later, here, you are chaning the head.next = head
        head.next = reversed;
        // dummy.next.next.next = reverseInPairs(head.next.next); // It can't be here!!
        return dummy.next;

    }
    public static void main(String[] args){
        reverseLinkedListInPairs sol = new reverseLinkedListInPairs();
        ListNode a = sol.new ListNode(1);
        ListNode b = sol.new ListNode(2);
        a.next = b;
        sol.reverseInPairs(a);

    }
    // head: 1-> 2-> null
    // dummy: -1 -> 2 -> 1 -> 2 -> null
    // dummy: -1 -> 2 -> 1 -> 2 -> null


    // head: 1 -> 2 -> 3 -> 4 -> null
    // dummy: -1 -> 2 -> 1 -> (3 -> 4 -> null)
    // reverse: 3 -> 4 -> null
    // okay... 

    // head: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null
    // dummy: -1 -> 2 -> 1 -> reverse(head.next.next)
    // return: 2 -> 1 -> 4 -> 3 -> 6 -> 5 -> 7 -> null

    // reverse(3 -> 4 -> 5 -> 6 -> 7 -> null ): 
    // head : 3 -> 4 -> 5 -> 6 -> 7 -> null 
    // dummy: -1 -> 4 -> 3 -> reverse(5 -> 6 -> 7 -> null )
    // return: 4 -> 3 -> 6 -> 5 -> 7 -> null
    
    // reverse(5 -> 6 -> 7 -> null):
    // head: 5 -> 6 -> 7 -> null
    // dummy: -1 -> 6 -> 5 -> reverse(7 -> null)
    // return: 6 -> 5 -> 7 -> null


    // reverse(7 -> null):
    // head 7 -> null
    // return 7 -> null

    
}
