package binaryTree;
import java.util.Arrays;
import java.util.Dictionary;

import javax.xml.transform.Source;

public class binarySearch{

    // Classical Version 1.0
    public static int ClassicBS(int[] a, int target){
        int left = 0;
        int right = a.length - 1;
        while(left <= right){
            int mid = left + (right - left) /2;
            if(a[mid] < target) left = mid+1;
            else if(a[mid] > target) right = mid - 1;
            else return mid;
        }
        return -1;
    }

    // Classical Binary Search in 2D Space

    public static int[] Classic2DBS(int[][] a, int target){
        if(a == null || a.length == 0 || a[0].length == 0){
            return new int[]{-1,-1};
          }
          int col = a[0].length;
          int row = a.length;
          int left = 0;
          int right = col*row - 1;
          while (left <= right){
            int mid = left + (right - left)/2;
            System.out.println(mid);
            int c = mid % col;
            int r = mid / col;
            if(a[r][c] < target) left = mid +1;
            else if(a[r][c] > target) right = mid -1;
            else{
              return new int[]{r,c};
            }
          }
          return new int[]{-1,-1};
    }

    public static int findClosest(int[] a, int target){
        int left = 0;
        int right = a.length-1;
        
        while( left < right - 1){ // when there is only 2 elements in list, go out of the loop
            int mid = left + (right - left) /2;
            if(a[mid] < target) left = mid;
            else if(a[mid] > target) right = mid;
            else return mid;
        }
        if (Math.abs(a[left] - target) <= Math.abs(a[right] - target)){
            return left;
        }
        else{
            return right;
        }
    }

    public static int findFirst(int[] a, int target){
        // find the first occurrence of the element.

        int left = 0;
        int right = a.length-1;
        // 范围缩小到只有2个，3种case
        while( left < right - 1){
            int mid = left + (right - left) /2;
            if(a[mid] < target) left = mid;       // left = mid + 1 --> Both Ok
            else if(a[mid] > target) right = mid; // right = mid - 1 --> Both Ok
            else right = mid;                     // the right part of the current one is excluded
        }
        // 3种case 
        // 1. 2个都没有target. 
        // 2. 2个都是target. 
        // 3. 2个有一个是target
        if(a[left] != a[right] && a[right] == target) return right;
        else if(a[left] != a[right] && a[left] == target) return left;
        else if(a[left] == a[right] && a[left] == target) return left;
        else return -1;
    }

    public int firstOccur2(int[] array, int target) {
        // Write your solution here
        // edge cases
        if(array.length == 0) return -1;
        int targetIndex = findIndex(array, target);
        if (targetIndex == -1) return targetIndex;
        System.out.println("mid : " + targetIndex);
        // check duplicated number. 
        while(array[targetIndex - 1] == target){
          targetIndex --;
        }
        return targetIndex;
    }

    private int findIndex (int[] array, int target){
      int first = 0;
      int last = array.length -1;
      // [3,3,3,3,6,9,16]
      // mid = 3; -> 3
      // first = 
      while(first <= last){
        int mid = first + (last - first) / 2;
        if(array[mid] == target) return mid;
        else if(array[mid] > target) last = mid - 1; // 错误点！
        else first = mid + 1; //易错点！！
      }
      return -1;
    }

    public int[] kClosest(int[] array, int target, int k) {
        // Write your solution here
        int[] res = new int[k];

        // edge
        if(array.length == 0 || array == null || k  == 0) return res;

        int left = 0;
        int right = array.length - 1;
        // find the two elements that are the cloest to the target
        while (left < right - 1){
            int mid = left + (right - left) /2;
            if(array[mid] >= target) right = mid;
            else left = mid;
        }

        // add k cloest to the res array
        // first check left and right -> the two we find
        // [1,2]
        int cloest = -1;
        if(Math.abs(array[left] - target) >= Math.abs(array[right] - target)){
            cloest = right;
        }
        else{
            cloest = left;
        }
        res[0] = array[cloest];

        // add rest
        left = cloest - 1;
        right = cloest + 1;
        for(int i = 1; i < k; i++) {
            if (left >= 0 && right <= array.length - 1) {
                if (Math.abs(array[left] - target) > Math.abs(array[right] - target)) res[i] = array[right++];
                else res[i] = array[left--];
            } else if (cloest == 0) {
                res[i] = array[right++];
            } else {
                res[i] = array[left--];
            }
        }
        return res;
    }



    public int[] kClosest2(int[] array, int target, int k) {
        // Write your solution here
        int[] res = new int[k];

        // edge
        if(array.length == 0 || array == null || k  == 0) return res;

        int left = 0;
        int right = array.length - 1;
        // find the two elements that are the cloest to the target
        while (left < right - 1){
            int mid = left + (right - left) /2;
            if(array[mid] >= target) right = mid;
            else left = mid;
        }

        // add k cloest to the res array
        // first check left and right -> the two we find
        // [1,2]
        int cloest = -1;
        if(Math.abs(array[left] - target) >= Math.abs(array[right] - target)){
            cloest = right;
        }
        else{
            cloest = left;
        }
        res[0] = array[cloest];

        // add rest
        left = cloest - 1;
        right = cloest + 1;
        for(int i = 1; i < k; i++){
            if(left >= 0 && right <= array.length - 1){
                if(Math.abs(array[left] - target) > Math.abs(array[right] - target)) res[i] = array[right++];
                else res[i] = array[left--];
            }
            else if(left < 0){
                res[i] = array[right ++];
            }
            else{
                res[i] = array[left --];
            }
        }
        return res;
    }

    public static int FindTargetInAscendDesendOrder(int[] array, int target) {
        // Write your solution here
        int left = 0;
        int right = array.length;
    
        while(left < right -1){
    
          int mid = left + (right - left) /2;
          System.out.println(mid);
          if(array[mid -1] < array[mid] ) left = mid;
          else right = mid;
        }
        System.out.println(left);
        System.out.println(right);
        int peak = 0;
        
        if(array[left] > array[right]) peak = left;
        else peak = right;
        System.out.println(peak);
        if(target < peak){
          left = 0;
          right = peak;
          while(left < right){
            int mid = left + (right - left) /2;
            if(array[mid] < target) left = mid + 1;
            else if (array[mid] > target) right = mid - 1;
            else return mid;
          }
          return -1;
        }
        else{
          left = peak;
          right = array.length;
          while(left < right){
            int mid = left + (right - left) /2;
            if(array[mid] < target) left = mid + 1;
            else if (array[mid] > target) right = mid - 1;
            else return mid;
          }
          return -1;
        }
      }
    
    // public int search(Dictionary dict, int target){
    //     int curIndex = 0;
    //     while(dict.get(curIndex) != null){
    //         int cur = dict.get(curIndex);

    //     }

    // }
    public static String toString1(int[] a){
        String res = "";
        for(int i = 0; i<a.length; i++){
            res += a[i] + " ";
        }
        return res;
    }


    public static final void main(String[] args){
        binarySearch sol = new binarySearch();
        int[] a = new int[]{-3,-2,4,4,4, 10,11,50};
        // Arrays.binarySearch(a, 4);
        // int[][] m = new int[][]{{2},{3},{1},{4}};
        // int[] res = Classic2DBS(m, 3);
        // System.out.println(toString1(res));
        // int result = ClassicBS(a, 1);
        // System.out.println(result);
        // System.out.println(findClosest(a, 11));
        // int [][] matrix = new int[][]{{1,2}, {3,4}};
        // System.out.println(Classic2DBS(matrix, 2));
        // int res = findLast(a, 4);
        int[] res = sol.kClosest(new int[]{1,3,3,6,9,9,12,15}, 10, 5);
        System.out.println(res.toString());

        // int left = 2;
        // System.out.println(a[left--]);
        // System.out.println(left);
        // int[] res = findK_elements(a, 10, 2);
        // System.out.println(toString1(res));
        // for(int i = 0; i< 3; i++){
        //     System.out.println(res[i]);
        // }
        
    }
}