package graphSearch;

public class wordSearch {
    /*
     * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
     * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. 
     * The same letter cell may not be used more than once.
     * 
     * Note: word are horizontally or vertically neighboring. Can not be diagnoally.
     * 
     * Cannot use DP! 
     * 
     * eg:
     * board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * A B C E
     * S F C S
     * A D E E
     * 
     * 2D arr:
     * 1 1 1 1
     * 0 0 1 0
     * 1 1 1 1
     * DP can't work here since it can not be calculated bottom-up (从小到大)
     * 
     * This is the question to see if something exist. Use DFS/backtracking!!! 
     * recursion Tree: maximun 3 branches
     *                 height L
     * This problem, we should use backtracking-DFS strategy!
     * need to create a boolean to track if a letter is visited. (each letter can only be visited once)
     * branch: can be left, up, right or down, if visited, can't explore
     * count the number letter match the letter
     */
    public boolean exist(char[][] board, String word) {
        if(word == null || word.isEmpty()) return false;
        if(board == null || board.length == 0) return false;

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(backtrack(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
        
    }
    private boolean backtrack(char[][] board, String word, int row, int col, int index){
        //base case
        if(index == word.length()) return true;
        //explore
        // check conditions
        if(row >= board.length || col >= board[0].length || row < 0 || col < 0 ) return false;
        if(board[row][col] != word.charAt(index)) return false;
        // current position in the board match the word[index] find next
        // do backtrack!
        board[row][col] = '#'; // if visited, we can't visit again - change so that we won't match

        // for direction: left, right, up, down
        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};
        for (int d = 0; d < 4; ++d) {
        if (backtrack(board, word, row + rowOffsets[d], col + colOffsets[d], index + 1))
            // return without cleanup
            return true;
        }  
        // 当前board[row][col] 上下左右都没有match的可能性
        board[row][col] = word.charAt(index); // backrack恢复走别的路 -- 吃吐守恒
        return false;
    }
    // L: word length
    // n: row, m: col
    //
    // TC: O(n^m * 3^L)
    //     the execution trace after the first step could be visualized as a 3-ary tree,
    //     recursion Tree: maximun 3 branches
    //                     height L
    // SC: Recursion call/Tree of backtrack O(height of recursion Tree) = O(L)
}
