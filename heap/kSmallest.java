import java.util.*;

public class kSmallest {

    //Find the K smallest numbers in an unsorted integer array A. The returned numbers should be in ascending order.

    public int[] kSmallest(int[] array, int k) {
        // Write your solution here
        // solution 1: using max heap, create a PQ of k elements. 
        //             then update it 
        // corner case:
        if(array.length ==0 || k == 0) return new int[0];
    
        // generate a max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue(k, new Comparator<Integer>(){
          @Override
          public int compare(Integer o1, Integer o2){
            // don't use '==' here! -> might use reference instead of their value
            if(o1.equals(o2)) return 0;
            // 返回的整数越小（-1），第一个参数优先级越高。整数越大（1），第一个参数优先级越低
            return o1 < o2 ? 1 : -1;
          }
        });
        // update the max heap
        for(int i = 0; i < array.length; i++){
          if(i < k) maxHeap.offer(array[i]);
          else if(array[i] < maxHeap.peek()){
            maxHeap.poll();
            maxHeap.offer(array[i]);
          }
        }
    
        int[] result = new int[k];
        for(int i = k-1; i >=0; i--){
          result[i] = maxHeap.poll();
        }
        return result;
      }
    
}
