package strings;
import java.util.*;

public class strings {

    public boolean ispalindrome(String input){
      StringBuilder sb = new StringBuilder(input);
      sb.reverse();
      String reverse = new String(sb);
      
      return reverse.equals(input);
    }

    
    public String reverse(String input) {
        // using swap method: TC O(n), SC: O(n)
        char[] inputArr = input.toCharArray();
        int left = 0;
        int right = inputArr.length - 1;
        while(left < right){
            char cur = inputArr[left];
            inputArr[left] = inputArr[right];
            inputArr[right] = cur;
            left ++;
            right --;
        }
        return new String(inputArr);
    
    
        //This method: TC: O(n), SC: O(n)
        //   int size = input.length();
        //   char[] inputString = input.toCharArray();
        //   String res = "";
        //   for(int i = 0; i < size; i++){
        //       res += inputString[size-i-1];
        //   }
        //   return res;
        // }
    }

    /***
     * Reverse the words in a sentence.
     * Assumptions
     * Words are separated by single space
     * There are no heading or tailing white spaces
     * Examples
     * “I love Google” → “Google love I”
     * @param input inputString
     * @return reversed words string
     */
    public String reverseWords(String input) {
        // I love Yahoo Trick
        char [] inputArr = input.toCharArray();
        // Step 1: 先reverse 整体
        char [] reversed = reverseHelper(inputArr, 0, inputArr.length - 1);
        // step 2: 再reverse 局部
        int index = 0;
        for(int i = 0; i < reversed.length; i++){
          // check " "
          if(reversed[i] == ' '){
            reverseHelper(reversed, index, i-1);
    
            index = i + 1;
          }
          
        }
        // reverse the last word
        reverseHelper(reversed, index, reversed.length-1);
        return new String(reversed);
    }

    public char[] reverseHelper(char[] input, int left, int right){
        while(left < right){
          char cur = input[left];
          input[left] = input[right];
          input[right] = cur;
          left ++;
          right --;
        }
        return input;
    }
    
    public String reverseWordsII(String input) {
        
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
        // 两个挡板，三个区域，同向而行
        if(input == null || input.isEmpty()) return null;
        // assume input source and target are not NULL.
        char[] inputArr = input.toCharArray();
        // case1: target.length() <= source.length()
        if(target.length() <= source.length()){
            return replaceShorter(inputArr, source, target);
        }
        // case 2: target.length() > source.length()
        return replaceLonger(inputArr, source, target);
        // return input.replaceAll(source, target); // in general
      }

      // replace longer string with shorter string
      private String replaceShorter(char[] inputArr, String source, String target){
        int slow = 0;
        int fast = 0;
        while(fast < inputArr.length){


        }
        return "";
      }

      private String replaceLonger(char[] inputArr, String source, String target){
        return "";
        }

    public static void main(String[] args){
        strings solution = new strings();
        System.out.println(solution.ispalindrome("appabappa"));
        // System.out.println(solution.reverse("eneri"));
        // System.out.println(solution.reverseWords("Google Love I"));
        // System.out.println(solution.rightShift("abc", 4));
        // System.out.println(solution.replace("rerererelllll", "re", "i"));

        
    }
}
