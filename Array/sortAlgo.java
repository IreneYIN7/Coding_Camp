package Array;
import java.util.*;


public class sortAlgo {
    public int[] mergeSort(int[] array) {
      // Write your solution here
      if(array == null || array.length == 0) return array;
      return mergesort(array, 0, array.length-1);
  
    }
    private int[] mergesort(int[] array, int left, int right){
      //sort
      
      if(left == right) return new int[]{array[left]};
      int mid = left+ (right - left)/2;
      int[] leftArray = mergesort(array, left, mid);
      int[] rightArray = mergesort(array, mid+1, right);
      return merge(leftArray, rightArray);
    }
  
    private int[] merge(int[] array1, int[] array2){
    //   System.out.println(Arrays.toString(array1));
    //   System.out.println(Arrays.toString(array2));
      int[] res = new int[array1.length + array2.length];
      int leftIndex = 0;
      int rightIndex = 0;
      int resultIndex = 0;
      while(leftIndex < array1.length && rightIndex < array2.length){
        if(array1[leftIndex] <= array2[rightIndex]) res[resultIndex++] = array1[leftIndex++];
        else res[resultIndex++] = array2[rightIndex++];
        
      }
      while(leftIndex < array1.length){
        
        res[resultIndex++] = array1[leftIndex ++];
      }
      while(rightIndex < array2.length){
        res[resultIndex++] = array2[rightIndex ++];
      }
      return res;
    }

    public int[] mergeSort2(int[] array){
        int[] res = new int[array.length];
        if(array == null || array.length <= 1) return array;
        mergesort2(array, res, 0, array.length-1);
        return res;
    }

    private void mergesort2(int[] array, int[] res, int left, int right){
        if(left == right) return;
        int mid = left+ (right- left)/2;
        mergesort2(array, res, left, mid);
        mergesort2(array, res, mid + 1, right);
        merge2(array, res, left, mid, right);
    }

    public void merge2(int[] array, int[] res, int left, int mid, int right){
        
        System.out.println(Arrays.toString(res));
        System.out.println("left is "+ left);
        System.out.println("right is "+ right);
        int leftIndex = left;
        int rightIndex = mid+1;
        while(leftIndex <= mid && rightIndex <= right){

            if(array[leftIndex] <= array[rightIndex]) res[left++] = array[leftIndex++];
            else res[left++] = array[rightIndex++];
        }

        while(leftIndex <= mid) res[left++] = array[leftIndex++];
        while(rightIndex <= right) res[left ++] = array[rightIndex++];
    }

    // quickSort
    public int[] quickSort(int[] array) {
      
      if(array == null || array.length == 0) return array;
      quicksort(array, 0, array.length-1);
      return array;
    }
    public void quicksort(int[] array, int left, int right){
      if(left >= right) return;
      // partition: put pivot at the right position
      int pivotIndex = partition(array, left, right);
      quicksort(array, left, pivotIndex-1); 
      quicksort(array, pivotIndex+1, right);
    }
  
    private int partition(int[] array, int left, int right){
      System.out.println(Arrays.toString(array));
      // get a random pivot
      int pivot = left+ (int) (Math.random() * (right-left+1));
      int val = array[pivot];
      // put it to the right in order to manage the index
      swap(array, pivot, right);
      int leftbound = left;
      int rightbound = right- 1; // rightmost is the pivot;
      while(leftbound <= rightbound){
        if (array[leftbound] < val)  leftbound ++;
        // >= since it would add to the end of the array which won't case problem.
        else if(array[rightbound] >= val) rightbound --;
        else swap(array, leftbound++, rightbound--);
      }
      
      //deal with the rightmost pivot --> put it to the left position.
      swap(array, leftbound, right);
      return leftbound;
    }
  
    public void swap(int[] array, int pos1, int pos2){
      int temp = array[pos1];
      array[pos1] = array[pos2];
      array[pos2] = temp;
    }
  

    public static void main(String[] args){
        sortAlgo solution = new sortAlgo();
        int[] array = new int[] {1,10,2,9,6,4};
        int[] soluArr = solution.quickSort(array);
        
        System.out.println(Arrays.toString(soluArr));
        // array = mergesortTest.mergeSort(array);
        // System.out.println(Arrays.toString(array));
        
        // int[] array2 = new int[] {2,1,8,12,4,6}; 
        // array2 = mergesortTest.mergeSort2(array2);
        // System.out.println("array2 now is: ");
        // System.out.println(Arrays.toString(array2));
        // int[] a1 = new int[] {1,3,5, 0, 2,4,8};
        // int[] res = new int[a1.length];
        // mergesortTest.merge2(a1, res, 0, 2, a1.length-1);
        // System.out.println("answer: " +  Arrays.toString(res));
    } 
  }
  