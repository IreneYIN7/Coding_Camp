package Sorting;
import java.util.*;

public class selectionSort {
    public int[] solve(int[] array) {
        // Write your solution here
        // 把第i轮第i小的元素放最前面。
        // corner case:
        if(array.length == 0 || array == null) return array;
        for(int i = 0; i < array.length - 1; i ++){ // num iterations.
          int globalMin = i;
          for(int j = i + 1; j < array.length; j ++){ // found the global min
            if(array[globalMin] > array[j]) globalMin = j;
            
          }
          // swap ith pos with the ith smallest.
          int temp = array[i];
          array[i] = array[globalMin];
          array[globalMin] = temp;
        }
        return array;
    
      }
}
