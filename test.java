import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;


public class test {
  
    // function that reverses array and stores it 
    // in another array
    

    static void reverse(int a[], int n)
    {
        int[] b = new int[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }
  
        // printing the reversed array
        System.out.println("Reversed array is: \n");
        for (int k = 0; k < n; k++) {
            System.out.println(b[k]);
        }
    }
  
    public static void main(String[] args)
    {
        // ArrayList<Integer> arrT = new ArrayList<>();
        // arrT.add(1);

        // int [][] arr1 = new int[][]{{0,1},{3},{4}};
        // System.out.println(arr1.length);
        // int [] arr = {10, 20, 30, 40, 50};
        // reverse(arr, arr.length);

        Queue<Integer> test = new ArrayDeque<>();
        test.offer(1);
        test.offer(2);
        test.offer(3);
        System.out.println("before assign: " + test.toString());
        Queue<Integer> test2 = new ArrayDeque<>();
        test2.offer(3);
        test2.offer(2);
        test2.offer(1);
        System.out.println(test2.toString());

        test = test2;
        System.out.println("after assign: " + test);


    }
}