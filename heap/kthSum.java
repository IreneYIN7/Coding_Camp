package heap;
import java.util.*;

public class kthSum {

    public class Pair{
        int x, y;
        int value;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
            this.value = x + y;
        }
    }
    /*
     * https://app.laicode.io/app/problem/27
     * 
     * Given two sorted arrays A and B, of sizes m and n respectively. Define s = a + b, 
     * where a is one element from A and b is one element from B. 
     * Find the Kth smallest s out of all possible s'.
     * Note: if we have sum 2, 2, 2, 3 , ... the 2nd smallest sum is 3! , instead of 2
     * 
     * Using Heap!! data structure
     * using min heap
     * 1. heapify the array into min-heap -- O(n)
     * 2. keep popping k times out of the heap -- each pop O(n), heapify - O(k*logn)
     * 
     * the kth smallest in the last one of the prioprityQueue (minheap)
     * 
     * 
     */
    public int kthSum(int[] A, int[] B, int k) {
        // corner case
        if((A == null && B == null) || (A.length == 0 && B.length== 0)) return 0;
        if(A.length == 0) return B[k];
        if(B.length == 0) return A[k];
        if(k == 1) return A[0] + B[0];

        PriorityQueue<Pair> minheap = new PriorityQueue<>(k, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2){
                return p1.value - p2.value;
            }
        });
        // A: [1,3,5] B: [1,4]
        // [[1+1, 1+4],[3+1, 3+4], [5+1, 5+4]]
        // here: we can't directly build minheap like this, since we don't want to have the duplicated value
        Pair prev = null;
        Pair cur = null;
        for(int i = 0; i< A.length; i++){
            for (int j = 0; j < B.length; j++){
                cur = new Pair(A[i], B[j]);
                // if it is already in minheap, ignore, else add.
                if(prev == null || prev.value != cur.value){
                    minheap.offer(cur);
                    prev = cur;
                }
                
            }
        }
        int res = 0;
        for(int i = 0; i < k; i++){
            res = minheap.poll().value;
        }
        
        return res;
    }
    
    // TC: O(m^n)
    // SC: O(m^n)
}
