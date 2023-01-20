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
        
        while( left < right - 1){
            int mid = left + (right - left) /2;
            if(a[mid] < target) left = mid;       // left = mid + 1 --> Both Ok
            else if(a[mid] > target) right = mid; // right = mid - 1 --> Both Ok
            else right = mid;                     // the right part of the current one is excluded
        }
        if(a[left] != a[right] && a[right] == target) return right;
        else if(a[left] != a[right] && a[left] == target) return left;
        else if(a[left] == a[right] && a[left] == target) return left;
        else return -1;
    }

    public static int findLast(int[] array, int target){
        // find the last occurrence of the element.

        int left = 0;
        int right = array.length-1;
        
        while( left < right - 1){     // if there array are only two elements in the list.
            int mid = left + (right - left) /2;
            if(array[mid] < target) left = mid;       // left = mid + 1 --> Both Ok
            else if(array[mid] > target) right = mid; // right = mid - 1 --> Both Ok
            else left = mid;                      // the left part of the current one is excluded
        }
        System.out.println(left);
        System.out.println(right);
        if(array[right] == target) return right;
        else if(array[left] == target) return left;
        else return -1;
        // if (a[left] != a[right]){
        //     return left;
        // }
        // else{
        //     return right;
        // }
    }

    public static int[] findK_elements(int[] array, int target, int k){
        //Find k elements that are cloest to the target
        int[] res = new int[k];
        int closest = findClosest(array, target);
        res[0] = array[closest];
        for(int i = 1; i<k; i++){
            if(closest + i < array.length -1 && closest - i > 0){
                if(Math.abs(array[closest] - array[closest-i]) < (array[closest+i] - array[closest])){
                res[i] = array[closest-i];
                }
                else {res[i] = array[closest + i];}
            }
            else if(closest == array.length - 1){
                res[i] = array[closest - i];
            }
            else res[i] = array[closest + i];
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
        Arrays.binarySearch(a, 4);
        // int[][] m = new int[][]{{2},{3},{1},{4}};
        // int[] res = Classic2DBS(m, 3);
        // System.out.println(toString1(res));
        // int result = ClassicBS(a, 1);
        // System.out.println(result);
        // System.out.println(findClosest(a, 11));
        // int [][] matrix = new int[][]{{1,2}, {3,4}};
        // System.out.println(Classic2DBS(matrix, 2));
        int res = findLast(a, 4);
        System.out.println(res);
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