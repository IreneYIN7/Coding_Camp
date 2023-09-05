package graphSearch;

import java.util.*;

public class KthClosestPointTo000 {
    public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
    // Write your solution here
    // This is a dijkstra!!

    // k-th closest to <0,0,0> -- k smallest combination
    // euclidean distance sqrt((x0-x2)^2 + ...)
    
    // Importantly!! We can't use int[] in this problem because when we compare visited node exists or not, we need to compare 2 int[]

    // corner case:
    if(a.length == 0 || b.length == 0|| c.length == 0|| k <=1 || k > a.length * b.length* c.length) return new ArrayList<Integer>();
    // minHeap -- Best first search, find the smallest, and continue with the smallest node
    PriorityQueue<int[]> minHeap = new PriorityQueue<>(2*k, new Comparator<int[]>(){
      @Override
      public int compare(int[] point1, int[]point2){
        // calculate distance here!!!
        long a1Dis = eucliDistance(point1, a, b, c);
        long a2Dis = eucliDistance(point2, a,b,c);
        // if(a1Dis == a2Dis) return 0;
        // return a1Dis < a2Dis ? -1 : 1;
        return (int)(a1Dis - a2Dis);
      }
    });
    // Note: We don't need to three nested for loop since a, b, c are sorted int[]!! 
    // we just need to iterate k times to get k smallest
    // the first one has to the smallest!
    // it's possible that 访问的点之前访问过，所以需要设一个visited
    Set<int[]> visited = new HashSet<>();
    int[] cur = new int[]{0, 0, 0};

    minHeap.add(cur);
    visited.add(cur); // Note: it's the index we should keep track of!

    while(k > 0){
      cur = minHeap.poll();
      System.out.println(Arrays.toString(cur));
      // find next  -- 3 different points
      int[] next = new int[]{cur[0] + 1, cur[1], cur[2]};
      
      if(next[0] < a.length && visited.add(next)){
        minHeap.add(next);
      }
      next = new int[]{cur[0], cur[1] + 1, cur[2]};
      if(next[1] < b.length && visited.add(next)) minHeap.add(next);
      next = new int[]{cur[0], cur[1], cur[2] + 1};
      if(next[2] < c.length && visited.add(next)) minHeap.add(next);
      k--;
    }
    return new ArrayList<Integer>(Arrays.asList(a[cur[0]],b[cur[1]],c[cur[2]]));
  }

  private long eucliDistance(int[] point, int[] a, int[] b, int[] c){
    // long dis = 0;
    // dis += a[point[0]] * a[point[0]];
    // dis += b[point[1]] * b[point[1]];
    // dis += c[point[2]] * c[point[2]];
    // return dis;
    return (long) Math.sqrt(Math.pow(a[point[0]], 2) + Math.pow(b[point[1]], 2) + Math.pow(c[point[2]],2));
  }    

  public static void main(String[] args){
    KthClosestPointTo000 sol = new KthClosestPointTo000();
    int[] a = new int[]{1,2,3};
    int[] b = new int[]{2,4};
    int[] c = new int[]{1,2};
    System.out.println(sol.closest(a, b, c, 10).toString());
  }
}
