package LinkedList;

import java.util.*;

public class deepCopyLL {

    public class RandomListNode{
        int value;
        RandomListNode next;
        RandomListNode random;
        public RandomListNode(int value){
            this.value = value;
            next = null;
            random = null;
        }
    }
    public RandomListNode copy(RandomListNode head) {
        // Write your solution here.
        // use iteration
    
        // Key point!! You are only caring about the reference of each node (where to point to)! not the value!
    
        // corner case
        if(head == null) return null;
        // to avoid cycle, need a hashMap to keep track the visited node
        Map<RandomListNode, RandomListNode> visitedMap = new HashMap<>();
        // initial value
        RandomListNode node = new RandomListNode(head.value);
        visitedMap.put(head, node);
        RandomListNode dummy = head;
    
        while(dummy != null){
          // copy next
          node.next = copyNode(dummy.next, visitedMap);
          // copy random
          node.random = copyNode(dummy.random, visitedMap);
          dummy = dummy.next;
          node = node.next;
        }
    
        return visitedMap.get(head);
      }
      private RandomListNode copyNode(RandomListNode node, Map<RandomListNode, RandomListNode> visited){
        if(node != null){
          // check if it is visited
          if(visited.containsKey(node)){
            return visited.get(node);
          }
          else{
            visited.put(node, new RandomListNode(node.value));
            return visited.get(node);
          }
        }
        return null;
      }
    
}
