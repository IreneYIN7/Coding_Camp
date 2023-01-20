import java.util.*;

public class strings {

    public String reverse(String input) {
        //"abcd" -- "dcba"
        int size = input.length();
        char[] inputString = input.toCharArray();
        String res = "";
        for(int i = 0; i < size; i++){
            res += inputString[size-i-1];
            System.out.println(res);
        }
        return res;
      }

    public String reverseWords(String input) {
        String[] inputString = input.split(" ");
        
        String result = "";
        int size = inputString.length -1;
        for(int i=0; i < size; i++){
            result += inputString[size - i] + " ";
        }
        result += inputString[0];
        return result;
    }
    /*
     * Right shift a given string by n characters.
     * Assumptions
     * The given string is not null.
     * n >= 0.
     * Examples
     * "abc", 4 -> "cab"
     */
    public String rightShift(String input, int n) {
        
        // Write your solution here
        int inputLen = input.length();
        if(n == 0 || inputLen % n == 0) return input;
        char[] stringArr = input.toCharArray();
        char[] res = new char[inputLen];
        int indexToMove = n % inputLen;
        for(int i = 0; i< inputLen; i++){
        
            res[(i+indexToMove) % (inputLen)] = stringArr[i];
            // System.out.println(i+indexToMove);
            
        }
        System.out.println(Arrays.toString(res));
        return String.valueOf(res);
      }

      /*
       * Given an original string input, and two strings S and T, from left to right replace all occurrences of S in input with T.
       * Assumptions
       * input, S and T are not null, S is not empty string
       * Examples
       * input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
       * input = "laicode", S = "code", T = "offer", input becomes "laioffer"
       */
      public String replace(String input, String source, String target){
        // if(input.isEmpty()) return input;
        // int size = input.length();
        
        // for(int i = 0; i < size; i++){
        //     if(String.valueOf(input.charAt(i)) == target) input.replace
        // }
        return input.replaceAll(source, target);
      }
    public static void main(String[] args){
        strings solution = new strings();
        // System.out.println(solution.reverse("eneri"));
        // System.out.println(solution.reverseWords("Google Love I"));
        // System.out.println(solution.rightShift("abc", 4));
        System.out.println(solution.replace("rerererelllll", "re", "i"));
        
    }
}
