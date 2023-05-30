package LinkedList;

import java.security.Principal;

import javax.swing.SpinnerDateModel;
import javax.swing.plaf.synth.SynthIcon;

public class MiddleNodeOfLL {
    public class ListNode {
        public int value;
        public ListNode next;
        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }

    public ListNode middleNode(ListNode head) {
        // Write your solution here
        // iterative way: 
        // 1. find the mid index. 
        // 2. find the value of that mid node
    
        // corner case:
        if (head == null || head.next == null) return head;
        System.out.println(printLL(head));

        ListNode dummy = new ListNode(-1);
        ListNode dummy2 = dummy;

        int counter = 0;
        while(head != null){
          dummy.next = new ListNode(head.value);
          dummy = dummy.next;
          head = head.next;
          counter ++;
        }
        int mid = counter / 2;

        while(mid != 0){ // since the dummy2 starts from -1.
          mid --;
          dummy2 = dummy2.next;
        }
        return dummy2;
      }
    
    // Another way - important! 快慢指针 - improve space complexity of O(1)

    public ListNode middleNode2(ListNode head) {
        // Write your solution here
        // use 快慢指针！
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){ // error point: 只需要确保fast的后面两位不是Null就好
          slow = head.next;
          fast = head.next.next;
        }
        return slow;
    }
    // Tc: O(n)
    // Sc: O(1)
    
    
    private String printLL(ListNode head){
        ListNode dummy = head;
        String result = "";
        while(dummy != null){
            result += dummy.value;
            result += " -> ";
            dummy = dummy.next;
        }
        return result;
    }

    public static void main(String[] args){
        MiddleNodeOfLL sol = new MiddleNodeOfLL();
        ListNode a = sol.new ListNode(1);
        ListNode b = sol.new ListNode(2);
        ListNode c = sol.new ListNode(3);
        a.next = b;
        b.next = c;
        sol.middleNode(a);
    }
}
