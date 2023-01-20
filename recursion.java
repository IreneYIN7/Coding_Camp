
import java.time.format.ResolverStyle;
import java.util.Arrays;

public class recursion {
    
    public static int fib(int n){
        //base case
        if(n == 0 || n==1){
            return n;
        }
        
        int result1 = fib(n-1);
        int result2 = fib(n-2);

        return result1+result2;

    }
    public static int[] merge(int[] one, int[] two){
        int[] result = new int[one.length-1 + two.length -1];
        int oneIndex = 0;
        int twoIndex = 0;
        int resultIndex = 0;

        while(oneIndex < one.length && twoIndex < two.length){
            if (one[oneIndex] <= two[twoIndex]){
                

            }
        }

    }
    public static void main(String arg[]){
        System.out.println(fib(3));

    }
}


