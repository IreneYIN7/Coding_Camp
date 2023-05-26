package Sorting;
import java.util.*;

public class mergeSort {
    public int[] mergeSort(int[] array) {
        // Write your solution here
        // divide and conquer -- recursion.
        // base case: if left >= right -> only 1 ele, return itself.
        // recursive case: 
        //     mergeSortHelper(array, left, mid)
        //     mergeSortHelper(array, mid, right)
        
        // corner case: 
        if(array == null || array.length == 0) return array;
        
        int[] result = new int[array.length];
        helper(array, result, 0, array.length - 1);
        return array;
      }
    
      private void helper(int[] array, int[] result, int front, int end){
        // base case
        if(front >= end) return;;
        int mid = front +(end- front) / 2;
        // recursive case:
        helper(array, result, front, mid);
        helper(array, result, mid + 1, end);
        // recursive steps
        merge(array, result, front, mid, end);
      }
    
      private void merge(int[] array, int[] result, int front, int mid, int end){
        // 3 2 1
        // 3 2       1
        // 3    2     1
        // 3    2
        // copy content to the result array, merge from the result array.
        System.out.println("array: " + Arrays.toString(array) + " result :" + Arrays.toString(result));
        System.out.println("front: " + array[front] + " end: " + array[end]);
        for(int i = front; i <= end; i++){
          result[i] = array[i];
        }
        int leftIndex = front;
        int rightIndex = mid + 1;
        while(leftIndex <= mid && rightIndex <= end){ // sort in order
          if(result[leftIndex] > result[rightIndex]){
            array[front++] = result[rightIndex++];
          }
          else{
            array[front ++] = result[leftIndex++];
          }
        }
        // if there is still element left, add directly to the result array.
        while(leftIndex <= mid){
          array[front++] = result[leftIndex++];
        }


        // while(rightIndex <= end){
        //   result[front++] = array[rightIndex++];
        // }
      }
    
    public static void main(String args[]){
        mergeSort solu = new mergeSort();
        int[] a = new int[]{3,5,1,2,4,8};
        System.out.println(Arrays.toString(solu.mergeSort(a)));
    }
}
