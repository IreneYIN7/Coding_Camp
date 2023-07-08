package strings;
import java.util.*;


public class compressionII {
    public String compress(String input) {
    // Write your solution here
    // corner case
    if(input.isEmpty() || input.length() == 0) return new String();
    // generate a res arr with double size of the input length, iterate input

    char[] res = new char[input.length() * 2];
    if(input.length() == 1){
        res[0] = input.charAt(0);
        res[1] = (char)('0' + 1);
        return new String(res);
    }
    int pos = 1;
    char cur = input.charAt(0);
    int counter = 1;
    int index = 0;
    while(pos < input.length()){
      // if next == cur char, then counter + 1, else add to the res
      
      char next = input.charAt(pos);
      if(next == cur) {
        counter ++;
      }
      else{
        // store cur to the res with the counter;
        res[index] = cur;
        // case: if counter has multiple digits
        index = copyDigit(counter, res, index);
        counter = 1; // reset
      }
      cur = next;
      
      // deal with the last char
      if(pos == input.length() - 1){
        if(counter == 1){
            res[index++] = input.charAt(pos);
            res[index] = (char)('0' + counter);
        } 
        else{
            res[index] = cur;
            // case: if counter has multiple digits
            index = copyDigit(counter, res, index);
        }
        
      }
      pos++;
    }
    System.out.println(index);
    int end = index + 1;
    return new String(res,0,end);
  }

  public int copyDigit(int counter, char[] res, int index){
    System.out.println("digit is: " + counter);
    int len = 0;
    for(int i = counter; i > 0; i/=10){
            index ++;
            len ++;
    }
    for(int i = counter; i > 0; i/=10){
        System.out.println(i);
        int digit = i % 10;
        
        System.out.println(digit);
        res[index--] = (char) ('0' + digit); // reverse print number. due to the way of getting digits.
    }
    index += len + 1;
    System.out.println("index here: " + index);
    return index;
  }

  public static void main(String args[]){
    compressionII sol = new compressionII();
    int a = 0;
    String input = "qgvsuvqjewdfaivwbkvsfhzry";
    String output = sol.compress(input);
    System.out.println(output.length());
    System.out.println(output);
  }
    
}
