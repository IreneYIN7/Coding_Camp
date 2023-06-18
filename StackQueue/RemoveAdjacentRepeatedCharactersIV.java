package StackQueue;
import java.util.*;

public class RemoveAdjacentRepeatedCharactersIV {
    public String deDup(String input) {
        // Write your solution here
        // think it as a stack
        // 1. put on stack if it's not repeated with the top of the stack.
        // 2. if cur char is the same as the char on the top of the stack, then iterate util the diff char
        // 3. poll the stack.
        // 4. repeate 1-3
    
        // Use two pointers!
    
        // corner case:
        if(input.isEmpty() || input == null || input.length() <= 1) return input;
        // 
        char[] arr = input.toCharArray();
        int end = 0; // represent the top of the stack
        for(int i = 1; i < arr.length; i ++){
          // if stack is empty -> i = -1 or no dup;
          if(end == -1 || arr[i] != arr[end]){
            arr[++end] = arr[i];
          }
          // if there is a dup and stack not empty - ignore all the same dup char
          else{
            end --;
            while(i + 1 < arr.length && arr[i] == arr[i+1]) i++;
          }
        }
        
        return new String(arr, 0, end+1);
      }

    public static void main(String[] args){
        RemoveAdjacentRepeatedCharactersIV sol = new RemoveAdjacentRepeatedCharactersIV();
        String input = "aaaababab";
        System.out.println(sol.deDup(input));
        
    }
    
}
