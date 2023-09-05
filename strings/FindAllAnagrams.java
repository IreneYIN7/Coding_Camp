package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagrams {
      public List<Integer> allAnagrams(String sh, String lo) {
    // use a hashMap needed to check if current sliding window contains that hashMap
    // corner case:
    if(sh == null || sh.isEmpty() || lo == null || lo.isEmpty() || sh.length() > lo.length()) return new ArrayList<Integer>();
    List<Integer> res = new ArrayList<>();
    // step1: build the map 
    Map<Character, Integer> map = new HashMap<>();
    char[] s = sh.toCharArray();
    for(char c: s){
      if(map.containsKey(c)){
        map.put(c, map.get(c) + 1);
      }
      else map.put(c, 1);
    }
    // step 1, build silding window and check 
    int start = 0;
    int end = sh.length() - 1;
    char[] l = lo.toCharArray();
    // I need to update hashmap constantly
    int match = 0;
    for(int i = 0; i < l.length; i++){
      if(match == map.size()){
        // if all match get the start position
        res.add(start);
      }
      start++;
      end++;
    }
    return res;
  }
  public static void main(String[] args){
    FindAllAnagrams sol = new FindAllAnagrams();
    String target = "aab";
    String streams = "aaaacbbaac";
    System.out.println(sol.allAnagrams(target, streams));

  }
}
