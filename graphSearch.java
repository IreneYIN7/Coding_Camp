import java.util.*;
/***
 * Graph Search method: DFS
 * Question 1: combinations
 * Question 2: 
 * Question 3: coin problem
 * Question 4: permutations
 */
public class graphSearch {

  /***
   * Core question 4: give all permutations of a string
   * @param input
   * @return
   */
  public List<String> permutations(String input) {
    //assume input string is not null
    List<String> result = new ArrayList<String>();
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
      helper(array, index +1, result); // 错误点：we cannot use index++ in this case.
      swap(array, index, i);
    }
  }

  private void swap (char[] aList, int one, int two){
    char cur = aList[one];
    aList[one] = aList[two];
    aList[two] = cur;
  }


  public static void main(String[] args){
    graphSearch test = new graphSearch();
    String a = "abc";
    System.out.println(test.permutations(a).toString());

  }
}