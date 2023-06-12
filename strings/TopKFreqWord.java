package strings;
import java.util.*;
public class TopKFreqWord {
    
    public String[] topKFrequent(String[] combo, int k) {
        // Write your solution here
        // use a HashMap to keep the record
        // build a PQ -- maxHeap to store 
        // corner case
        if(combo.length == 0 || k == 0)  return new String[0];
    
        // generate a HashMap
        Map<String, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < combo.length; i ++){
          if(hashMap.containsKey(combo[i])){
            int freq = hashMap.get(combo[i]);
            hashMap.replace(combo[i], freq, freq + 1);
          }
          else hashMap.put(combo[i], 1);
            // if(hashMap.putIfAbsent(combo[i], 1) == null){
            //     hashMap.computeIfPresent(combo[i], (key,v) -> v + 1); // how does lambda function work in code? 
            //   }
        }
        // use minHeap -- only need 2 ele compare to maxHeap! maxHeap needs to fit all.

        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>(){
          @Override
          public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b){
            return a.getValue() - b.getValue();
          }
        });

        // add to the minHeap 
        for(Map.Entry<String, Integer> entry: hashMap.entrySet()){
            if(minHeap.size() < k) minHeap.offer(entry);
            else{
                Map.Entry<String, Integer> curMin = minHeap.peek();
                if(curMin.getValue() < entry.getValue()){
                    minHeap.poll();
                    minHeap.offer(entry);
                }
            }
        }

        String[] result = new String[minHeap.size()];
        for(int i= minHeap.size() - 1; i >= 0; i--){
            result[i] = minHeap.poll().getKey();
        }
        return result;
    
    }

    public static void main(String[] args){
        TopKFreqWord sol = new TopKFreqWord();
        String[] a = new String[]{"a","a","b"};
        System.out.println(Arrays.toString(sol.topKFrequent(a, 1)));

    }  
    
        
    
}
