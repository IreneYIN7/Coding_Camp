package strings;
import java.util.*;

public class findSubString {
    public long hashValue(String str, int base, int mod, int m){
        int ans = 0;
        long factor = 1;
        // "a b c" = code(a) * 26^2 + code(b) * 26^1 + code(C) * 26^0
        for(int i = m - 1; i >= 0; i--){
            ans += ((int)(str.charAt(i) - 'a') * factor) % mod;
            factor = (factor * base) % mod; // we don't use Math.pow becasue we use mod to easy computation
        }
        return ans % mod;
    }

    public int strStr(String haystack, String needle) {
        // rabin-karp algo
        // assuming it's from a - z - 26 char
        // 1. match each char to an Int
        // 2. calcuate hash val of needle
        // 3. iterate through m-n times to find if hash val match with needle's

        // corner case:
        if(haystack.length() < needle.length()) return -1;
        if(needle.length() == 0) return 0;
        // HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
        // instead of using hashmap, use (int) (string.charAt(i) - 'a') Java conversion
        int m = needle.length();
        int n = haystack.length();
        
        int base = 26;
        int mod = 1000000033;
        long MAX_WEIGHT = 1; // what is this?

        for(int i = 0; i < m; i++)
            MAX_WEIGHT = (MAX_WEIGHT * base) % mod; // 26^(m-1) with mod val
        
        // compute targetHash
        long targetHash = hashValue(needle, base, mod, m), hashHay = 0;
        
        // check if there is a equal hash val
        for(int i = 0; i <= n-m; i++){
            if(i ==0) hashHay = hashValue(haystack, base, mod, m);
            else{
                // update hashHay using previous hash value in O(1)
                // hashHay = ((hashHay * base) % mod - ((int)(haystack.charAt(i-1) - 'a') * MAX_WEIGHT) % mod + (int)(haystack.charAt(i + m - 1) - 'a')) % mod;
                hashHay = ((hashHay * base) % mod - ((int) (haystack.charAt(i - 1) - 'a') * MAX_WEIGHT) % mod + (int) (haystack.charAt(i + m - 1) - 'a') + mod) % mod;
            }
            // if matches hash value, check char by char to avoid sprious hits.
            if(targetHash == hashHay){
                for(int j = 0; j < m; j++){
                    if(needle.charAt(j) != haystack.charAt(j + i)) break;
                    if(j == m-1) return i;
                }
            }
        }
        return -1;

    }
    
}
