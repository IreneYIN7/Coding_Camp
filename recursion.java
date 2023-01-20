
import java.time.format.ResolverStyle;
import java.util.Arrays;

public class recursion {
    
    public int fib(int n){
        //base case
        if(n == 0 || n==1){
            return n;
        }
        
        int result1 = fib(n-1);
        int result2 = fib(n-2);

        return result1+result2;

    }
    public int[] merge(int[] one, int[] two){
        int[] result = new int[one.length + two.length];
        int oneIndex = 0;
        int twoIndex = 0;
        int resultIndex = 0;
        while(resultIndex != result.length){
            if(oneIndex < one.length && twoIndex < two.length){
                if (one[oneIndex] <= two[twoIndex]){
                    result[resultIndex++] = one[oneIndex++];
                }
                else result[resultIndex++] = two[twoIndex++];
            }
            else if(oneIndex < one.length){
                result[resultIndex++] = one[oneIndex++];

            }   
            else{
                result[resultIndex++] = two[twoIndex++];
            } 
        }
        
        return result;
    }
    public static void main(String arg[]){
        recursion test = new recursion();
        // System.out.println(fib(3));
        int[] a = new int[]{1,4,7};
        int[] b = new int[]{2,4,9};

        System.out.println(Arrays.toString(test.merge(a,b)));

    }
}


