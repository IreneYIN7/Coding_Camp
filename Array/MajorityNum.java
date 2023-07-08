package Array;

import java.util.HashMap;
import java.util.Map;

public class MajorityNum {
    public int majority(int[] array) {
    // Write your solution here
    // it's garanteed there exists such a majority num
    // corner case
    if(array.length == 0) return 0;
    double maxCounter = array.length * 0.5;
    // check which ele
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < array.length; i++){
      if(map.containsKey(array[i])){
        int val = map.get(array[i]);
        System.out.println(map.putIfAbsent(array[i], val + 1) == 2); // putIfAbscent can only update map if key doesn't exist
        map.putIfAbsent(array[i], val + 1);
        map.put(array[i], val + 1); 
      }
      else {
        map.putIfAbsent(array[i], 1);
      }
    } 
    System.out.println(map.toString());
    for(Map.Entry<Integer, Integer> entry : map.entrySet()){
      if((double)entry.getValue() >= maxCounter) return entry.getKey();
    }
    return -1;

  }

  public static void main(String[] args){
    MajorityNum sol = new MajorityNum();
    int[] a = {1,2,1,2,2};
    System.out.println(sol.majority(a));
  }
    
}
