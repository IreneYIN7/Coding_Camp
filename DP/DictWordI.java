import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DictWordI {
    public static boolean canBreak(String input, String[] dict) {
    // dp[i] - we can find the input from [0, i) in dict
    Set<String> dictSet = toSet(dict);
    System.out.println(dictSet.toString());
    boolean[] dp = new boolean[input.length() + 1];
    dp[0] = true;
    for(int i = 1; i <= input.length(); i++){
      for(int j = 0; j < i; j++){
        if(dp[j] && dictSet.contains(input.substring(j, i))){
          dp[i]  = true;
          break;
        }
      }
    }
    return dp[input.length()];
  }

  private static Set<String> toSet(String[] dict){
    Set<String> set = new HashSet<>();
    for(String s: dict){
      set.add(s);

    }
    return set;
  }

  public static void main(String[] args){
    String[] dict = {"rob","cat","d"};
    String input = "robcatd";
    System.out.println(canBreak(input, dict));
  }
}
