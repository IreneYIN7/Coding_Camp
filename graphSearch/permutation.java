package graphSearch;
import java.util.*;

/**
 * Permutations I, II, III
 */

public class permutation {

    /***
     * Core question 4: give all permutations of a string -- Method: Swap-Swap 
     * @param input a string
     * @return a list of string which contains all possible permutations
     */
    public List<String> permutations(String input) {
        //assume input string is not null, if not then
        List<String> result = new ArrayList<String>();
        if(input == null) return result;
        //if there is only one letter, just return 
        if(input.length() == 1){
        result.add(input);
        return result;
        } 
        char[] array = input.toCharArray();
        // use swap-swap method
        helper(array, 0, result);
        return result;
    }

    private void helper(char[] array, int index, List<String> result){

        if(index == array.length){
        result.add(new String(array));
        return;
        }
        for(int i = index; i < array.length; i++){
        swap(array, index, i);
        helper(array, index +1, result); // 错误点：we cannot use index++ in this case since it would change original index
        swap(array, index, i);
        }
    }

    private void swap (char[] aList, int one, int two){
        char cur = aList[one];
        aList[one] = aList[two];
        aList[two] = cur;
    }


    /***
     * Another method which would give us all possible permutations of a input string
     * @param input input String
     * @return a list of string which contains all possible permutations
     */
    public List<String> permutationII(String input){
        List<String> result = new ArrayList<String>();
        if(input == null) return result;
        if(input.length() == 1){
            result.add(input);
            return result;
        }
        char[] stringArr = input.toCharArray();
        StringBuilder array = new StringBuilder();
        boolean[] check = new boolean[input.length()];
        helperII(stringArr, check, array, result);
        return result;
    }
    
    private void helperII(char[] input, boolean[] check, StringBuilder cur, List<String> result){
        if(cur.length() == input.length) {
            result.add(cur.toString());
            return;
        }
        for(int i = 0; i < input.length; i++){
            // fix index
            // if a char is already used in a subtree, then we can't use it
            if(check[i]){
                //add
                check[i] = false;
                cur.append(input[i]);
                helperII(input, check, cur, result);
                //吐出来 split
                check[i] = true;
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }


    public List<String> permutationsIII(String input) {
        // Write your solution here
        List<String> result = new ArrayList<>();
        //corner case:
        if(input.length() == 0) {
          result.add("");
          return result;
        }
        char[] str = input.toCharArray();
        helperIII(str, 0, result);
        return result;
      }
    
      private void helperIII(char[] input, int index, List<String> result) {
        //assume helper(smaller size) set permutations correctly in result, our job is only to combine
        //base case:
        if (index == input.length - 1) {
          result.add(Character.toString(input[index]));
          return;
        }
        else {
          helper(input, index + 1, result);
          //Generate new result:
          int size = result.size();
          for (int j = 0; j < size; j++) {
            String curr = result.get(j);
            //insert input[index] at all possible positions for each string in the list
            // for-> num of branches
            for (int i = 0; i <= curr.length(); i++) {
              StringBuilder tmp1 = new StringBuilder(curr);
              String tmp2 = (tmp1.insert(i, input[index])).toString();
              result.add(tmp2);
            }
          }
          for (int i = 0; i < size; i++) {
            result.remove(0);
          }
        }
    
    }

    public static void main(String arg[]){
        permutation sol = new permutation();
        String a = "abc";
        System.out.println(sol.permutationII(a).toString());
    }
    
}
