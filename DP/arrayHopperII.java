import java.util.Arrays;

public class arrayHopperII {
    public static int minJump(int[] array) {
    // 0 1  2  3 4
    // 3 3  1  0 4
    // 2 1 -1 -1 0
    // M[i] represents the maximum jump distance from index i towards
    // the end of the array
    // 1D DP, linear scan 回头看。need to start from the end. 
    // assume: given array is not empty and length >= 1
    // base case
    if(array.length == 1) return 0;
    int length = array.length;
    int[] dp = new int[length];
    dp[length - 1] = 0;
    // 0 1  2  3 4
    // 3 3  1  0 4
    // 2 1 -1 -1 0
    for(int i = length - 2; i >= 0; i--){
      int jumps = array[i];
      // if it can directly reach
      if(i + jumps >= array.length - 1) dp[i] = 1;
      else if(jumps == 0) dp[i] = -1;
      else{
        int minJump = Integer.MAX_VALUE;
        // find the min mid point
        for(int j = jumps; j >= 1; j--){
          if(dp[j+i] < minJump  && dp[j+i] > 0) minJump = dp[j+i]; // Key steps! stucked here for long
        }
        if(minJump == Integer.MAX_VALUE) dp[i] = -1;
        else dp[i] = minJump + 1;
      }
      System.out.println(Arrays.toString(dp));
      
    }
    return dp[0];
  }

  public static void main(String[] args){
    int[] a = {2,1,1,1,1,0};
    System.out.println(minJump(a));
  }
}
