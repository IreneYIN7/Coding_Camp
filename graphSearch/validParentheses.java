package graphSearch;
import java.util.*;

/*
 * Combination
 * DFS 剪枝！
 */
public class validParentheses {
    
    /***
     * Given N pairs of parentheses “()”, return a list with all the valid permutations.
     *                          []
     *                  /                       \
     *                [(]                       []
     *              /    \
     *          [((]     [()]
     *          /           \
     *        [(()]       [()(]
     *        /             \
     *      [(())]          [()()]
     * @param n the number of pairs
     * @return valid combination of n pairs parentheses
     * 
     * we can always add leftparen, but for rightparen, we can only add right if we have a free left.
     */

    // branch = 2     Note: we don't really need for loop to for branches in the dfs helper method.
    // level = 2n
    
    public List<String> validParentheses(int n) {
        List<String> result = new ArrayList<String>();
        // conner case
        if(n == 0) return null;
        if(n == 1) return new ArrayList<String>(Arrays.asList("()"));
        StringBuilder cur = new StringBuilder();
        helper(n, 0, 0, cur, result);
        return result;
    }

    private void helper(int n, int leftParen, int rightParen, StringBuilder cur,  List<String> result){
        // base case
        if(cur.length() == n*2) result.add(new String(cur));
        // branches
        if(leftParen < n){
            cur.append("(");
            helper(n, leftParen + 1, rightParen, cur, result);
            //吐
            cur.deleteCharAt(cur.length()-1);
        }
        if(rightParen < leftParen){
            cur.append(")");
            helper(n, leftParen, rightParen+1, cur, result);
            cur.deleteCharAt(cur.length()-1);
        }

    }

    // branch = 2
    // level = 2n
    // TC: O(2^2n);
    // SC: O(height of recursion tree = 2n)
    
}
