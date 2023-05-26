package Sorting;
import java.security.Principal;
import java.util.*;

/**
 * Get the Kth number in the Fibonacci Sequence. 
 * (K is 0-indexed, the 0th Fibonacci number is 0 and the 1st Fibonacci number is 1).
 */
public class Fibonacci {
    public int fibonacci(int K) {
        // Write your solution here
        // 0  1  2  3  4  5  6
        // 0  1  1  2  3  5  8
        // corner case:
        if(K < 0) return 0;
        int a = 0;
        int b = 1;
        if(K <= 0) return a;
        while(K > 1){
          int temp = a + b;
          a = b;
          b = temp;
          K--;
        }
        return b;
      }
}