package graphSearch;
import java.util.*;



public class findKthSmallest {


    // find kth smallest int of the sum of Integers from both two lists.
    public int findKthSmallest(int[] one, int[] two, int k){
        // check
        if(one == null || two == null) return -1;
        List<Integer> allcombination = new ArrayList<Integer>();

        findAll(one, two, one.length, two.length, 0, 0, allcombination);
        
        return allcombination.get(k-1);
        
      }
      
      // dfs find all combination
      public void findAll(int[] one, int[] two, int lengthOne, int lengthTwo, int curIndex, int curSum, List<Integer> allcombination){
        if(curIndex == lengthOne){
          
          return ;
        }
        // The tree has lengthTwo num of branches
        for(int i = 0; i < lengthTwo; i ++){
          // get next in depth
          curSum = one[curIndex] + two[i];
          allcombination.add(curSum);
          findAll(one, two, lengthOne, lengthTwo, curIndex + 1, curSum, allcombination);
          //don't need to split out since we will overwrite curSum for the nextRound.
          
        }
        
        // TC: O(m^n);
        // SC: O(m)
         
        
      }
    public static void main(String[] args){
        findKthSmallest test = new findKthSmallest();
        int[] one = new int[]{1,3,5};
        int[] two = new int[]{4,8};
        System.out.println(test.findKthSmallest(one, two, 1));

    }
    
}
