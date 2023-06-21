package binarySearch;
import java.util.*;

public class kClosest {
    public int[] findKclosest(int[] array, int target, int k) {
        // Write your solution here
        // use binary search
        // - out: an int array that is sorted by diff - int[k]
        // 1. find the cloest element to the target
        //    while(left < right)
        // 2. check its neighbours to get k cloests.
        // corner case:
        if(array.length == 0) return array;
        // binary serach - find the closest element
        int closestIndex = findClosest(array, target);
        System.out.println(closestIndex);
        // find k closest
        int[] res = new int[k];
        int index = 0;
        res[index++] = array[closestIndex];
        int left = closestIndex - 1;
        int right = closestIndex + 1;
        // expand left and right
        // 1 2 3 5 10   t= 3 , k= 3, close = 2
        while(index < k){
            if(left >= 0 && right < array.length){
                if(Math.abs(array[left] - target) > Math.abs(array[right] - target)){
                res[index++] = array[right++];
                }
                else {
                res[index++] = array[left--];
                }
            }
            else if(left < 0){
                res[index++] = array[right++];
            }
            else if(right == array.length) res[index++] = array[left--];
        }
        return res;
    }


  private int findClosest(int[] array, int target){
    int left = 0;
    int right = array.length -1;
    while(left < right-1){
      // mid
      int mid = left + (right - left) / 2;
      // check with target
      if(array[mid] <= target) left = mid;
      else right = mid;
    }
    if(Math.abs(array[left] - target) >= Math.abs(array[right] - target)) return right;
    else return left;
  }

  public static void main(String args[]){
        kClosest sol = new kClosest();
        int[] a = new int[]{-3,-2};
        int target = 10;
        // System.out.println(solu.binarySearch(a, target));
        System.out.println(Arrays.toString(sol.findKclosest(a, target, 2)));
    }
    
}
