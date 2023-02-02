import java.util.*;

public class Hash {

    public String[] topKFrequent(String[] combo, int k) {
    
        Map<String, Integer> map = new HashMap<>();
        for (String cur : combo){
            //用2次调用map function的方法。
            Integer count = map.get(cur); // 1次
            if(count == null) count = 1;
            else count ++;
            map.put(cur, count);  // 1次
        }
        //need to implement a minHeap (priority Queue) to find  
        //k maximun value of the string
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, 
        new Comparator<Map.Entry<String, Integer>>(){
          @Override
          public int compare(Map.Entry<String, Integer> one, Map.Entry<String, Integer> two){
            return one.getValue().compareTo(two.getValue());
          }
        });
        // minHeap, if curValue < root, 丢掉，if curValue > root, 把root替换掉
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            toString(entry);
            if(minHeap.size() < k){
                minHeap.offer(entry);
            }
            else if(entry.getValue() > minHeap.peek().getValue()){
                minHeap.poll();
                minHeap.offer(entry);
            }
        }

        return freqArray(minHeap);
    
    }

    private String[] freqArray(PriorityQueue<Map.Entry<String, Integer>> minHeap){
        String[] result = new String[minHeap.size()];
        for(int i = minHeap.size() -1; i >= 0; i--){
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }

    public void toString(Map.Entry<String, Integer> entry){

        System.out.println("(" + entry.getKey() + " " + entry.getValue() + ")");
    }

    public static void main(String[] args){
        Hash test = new Hash();
        
        String[] a = new String[]{"d","a","c","b","d","a","b","b","a","d","d","a","d"};
        // answer: ["d", "a", "b", "c"]
        System.out.println(Arrays.toString(test.topKFrequent(a, 5)));

    }
    
}
