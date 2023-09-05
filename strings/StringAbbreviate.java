package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.*;
public class StringAbbreviate {
    public boolean match(String input, String pattern) {
    // Write your solution here
    // use pointers
    // assume: both input are not null
    // corner case
    if(input.isEmpty() && pattern.isEmpty()) return true;
    if(input.length() == 0 || pattern.length() == 0) return false;
    if(input.length() < pattern.length()) return false;
    int index1 = 0;
    int index2 = 0;
    char[] inputArr = input.toCharArray();
    char[] patternArr = pattern.toCharArray();

    while(index2 < pattern.length() && index1 < pattern.length()){
      // check if index2 is an int
      if(Character.isDigit(patternArr[index2])){
        int num = patternArr[index2++] - '0';
        // get all the int after the current digit
        while(index2 < patternArr.length && Character.isDigit(patternArr[index2])){
          num = num * 10 + (patternArr[index2++] - '0');
        }
        // move pointer2
        index1 += num;
        System.out.println(num + " and " + index2);
        System.out.println(index1);

      }
      else{
        System.out.println(Arrays.toString(inputArr) + " and " + Arrays.toString(patternArr));
        System.out.println(inputArr[index1] + " and " + patternArr[index2]);
        // when index2 is not a digit
        if(inputArr[index1] != patternArr[index2]) return false;
        else{
          index1++;
          index2++;
        }
      }
      
    }
    System.out.println(index1 + " index " + index2);
    // check if input arr already iterate through
    if(index1 != input.length() && index2 != pattern.length()) return false;
    else return true;
  }
  // TC: O(n)
  // SC: O(1)

  public static void main(String[] args){
    StringAbbreviate sol = new StringAbbreviate();
    System.out.println(sol.match("apple", "a4e"));
    int[] b = {1,2,3,1,1};
    Map<Integer, Integer> map = new HashMap<>();
    for(int a:b){
        if(map.containsKey(a)){
            map.put(a, map.get(a) + 1);
        }
        else{
            map.put(a,1);
        }
    }
    System.out.println(map.toString());
    
  }
    
}
