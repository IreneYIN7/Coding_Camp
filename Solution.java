import java.time.format.ResolverStyle;
import java.util.*;

public class Solution {
  public static void reverse(int[] array) {
    System.out.println("hello");
    System.out.println(array.length%2);
    
    if (array.length %2 == 0){
      System.out.println("hello2");
      for(int i = 0; i<array.length/2; i++){
        int back = array.length - 1 -i;
        int front = array[i];
        array[i]= array[back];
        array[back] = front;
      }
    }
    else{
      for(int i =0; i < (array.length/2); i++){

        System.out.println("hello3");
        int back = array.length - 1 -i;
        // System.out.println(back);
        int front = array[i];
        array[i]= array[back];
        System.out.println("back is: ");
        System.out.println(back);
        array[back] = front;
    }

    }
  }


  public static int find_Shifted_index(int left, int right, int[] a){
    if(a[left] < a[right]) return 0;
    else{
      while(left <= right){
        int mid = left + (right - left)/2;
        if(a[mid] > a[mid+1]) return mid + 1;
        else{
          if(a[mid] < a[left]) right = mid -1;
          else left = mid + 1;
        }
      }
      return 0;
    }
  }
  public static int BS(int left, int right, int[] a, int target){
    while(left <= right){
      int mid = left + (right -left)/2;
      if(a[mid] < target) left = mid + 1;
      else if(a[mid] > target) right = mid - 1;
      else return mid;
    }
    return -1;

  }
  public static int Q21(int[] array, int target) {
    if (array == null || array.length == 0){
      return -1;
    }
    if (array.length == 1) return (array[0] == target) ? 0: -1;
    int shiftTime = find_Shifted_index(0, array.length -1, array);
    if(shiftTime == 0) return BS(0, array.length-1, array, target);
    if (target == array[shiftTime-1]) return shiftTime -1;
    else if( target < array[0]) return BS(shiftTime, array.length-1, array, target);
    else return BS(0, shiftTime-1, array, target);
    
  }

  public static int[] removeElement(int[] input, int value) {
    //Question 240;

    int counter = 0;
    int right = 0;
    int left = input.length -1;
    int index = 0;
    while(right < left){
      
      if(input[right] != value) counter ++;
      if(input[left] != value) counter ++;
      right ++;
      left --;
    }
    System.out.println(counter);
    System.out.println(input.length);
    int[] itemLeft = new int[counter];

    for(int i = 0; i < input.length; i++){
      
      if(input[i] != value){
        itemLeft[index] = input[i];
        index ++;
      }
    }

    return itemLeft;
  }

  public static String toString1(int[] a){
    String res = "";
    for(int i = 0; i < a.length; i++){
      // System.out.println(a[i]);
      res += a[i] + "  ";

    }
    return res;
  }

  public static void swap(List<Integer> inputArr, int one, int two){
    int cur = inputArr.get(one);
    inputArr.set(one, inputArr.get(two));
    inputArr.set(two, cur);
  }
  public static void main(String[] args)
    {
      int [] a = new int[] {3,3,2,2,3,3};
      int [] res = removeElement(a, 3);
      System.out.println(toString1(res));
      // int res = Q21(a, 1);
      // System.out.println(res);
      
      // int[] array = new int[]{5,8,13};
      // reverse(array);

      // System.out.println(array.toString());
      List<Integer> a1 = new ArrayList<>();
      a1.add(1);
      a1.add(2);
      a1.add(3);
      swap(a1, 1,2);
      System.out.println(a1.toString());

    }
}
