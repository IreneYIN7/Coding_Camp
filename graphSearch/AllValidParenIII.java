import java.util.*;

public class AllValidParenIII{
    public static final char[] PS = {'(',')','<','>','{','}'};
    public List<String> validParenthesesIII(int l, int m, int n) {
      // Write your solution here
      // priority involved, terminate conditions
      List<String> result = new ArrayList<>();
      // corner case
      if(l == 0 && m == 0 && n == 0) return result;
      int numParen = 2*(l + m + n);
      int[] remains = {l, l, m, m, n, n};
      Deque<Character> stack = new ArrayDeque<>(); 
      dfs(stack, numParen, result, remains, new StringBuilder());
      return result;
    }
  
    public void dfs(Deque<Character> stack, int numParen, List<String> result, int[] remains, StringBuilder cur){
      // terminate condition
      if(cur.length() == numParen){
        result.add(cur.toString());
      }
      for(int i = 0; i < remains.length; i++){
        if(i%2 == 0){
          if(remains[i] > 0 && (stack.isEmpty() || stack.peekFirst() > PS[i])){ // using ASCII number which rep the char
            cur.append(PS[i]);
            stack.offerFirst(PS[i]);
            remains[i]--;
            dfs(stack, numParen, result, remains, cur);
            cur.deleteCharAt(cur.length() - 1);
            stack.pollFirst();
            remains[i]++;
          }
        }
        else{
          if(remains[i] > 0 && !stack.isEmpty() && stack.peekFirst() == PS[i - 1]){ // 括号需对应才能poll
            cur.append(PS[i]);
            stack.pollFirst();
            remains[i]--;
            dfs(stack, numParen, result, remains, cur);
            cur.deleteCharAt(cur.length() - 1);
            stack.offerFirst(PS[i - 1]);
            remains[i]++;
          }
        }
  
      }
    }

    public static void main(String[] args){
        char test = '{';
        System.out.println(test < 1);
    }
}