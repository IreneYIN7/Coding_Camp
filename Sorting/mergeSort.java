package Sorting;
import java.util.*;

public class mergeSort {
  public int[] mergeSort(int[] array) {
    // Write your solution here
    // divide two and sort the half and then combine together
    // need a helper array to assist the merge
    // corner case
    if(array == null || array.length == 0) return array;
    int[] helper = new int[array.length];
    mergeSortHelper(array, helper, 0, array.length - 1);
    return array;
  }

  private void mergeSortHelper(int[] array, int[] helper, int front, int end){
    // base case:
    if(front >= end) return;
    // recursive case:
    int mid = front + (end - front) / 2;
    mergeSortHelper(array, helper, front, mid);
    mergeSortHelper(array, helper, mid + 1, end); // Note: 注意是mid + 1
    merge(array, helper, front, mid, end);
  }

  private void merge(int[] array, int[] helper, int front, int mid, int end){
    // merge two array : from front to mid, and from mid to end.
    // 1. fill in helper array with the ele from front to end
    for(int i = front; i <= end; i++){
      helper[i] = array[i];
    }
    // sort merge --> change array based on checking helper
    int leftIndex = front;
    int rightIndex = mid + 1; // ? what if = mid. -> should be the same 
    while(leftIndex <= mid && rightIndex <= end){
      if(helper[leftIndex] <= helper[rightIndex]){
        array[front ++] = helper[leftIndex ++]; // 用left array 作为比较对象
      }
      else {
        array[front++] = helper[rightIndex++];
      }
    }
    // if leftIndex didn't reach mid
    while(leftIndex <= mid){
      array[front++] = helper[leftIndex++];
    }

  }
    
    public static void main(String args[]){
        mergeSort solu = new mergeSort();
        int[] a = new int[]{3,5,1,2,4,8};
        System.out.println(Arrays.toString(solu.mergeSort(a)));
    }
}
