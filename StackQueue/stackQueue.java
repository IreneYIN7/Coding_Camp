package StackQueue;
import java.util.*;

public class stackQueue {
    /*
     * Sort by using two stacks
     * No additional memory, time complexity = O(n ^ 2)
     */
    public void sort(LinkedList<Integer> s1) {
        if(s1 == null || s1.size() <= 1) return;
        
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        sort(s1,s2);
    }
    private void sort(LinkedList<Integer> input, LinkedList<Integer> buffer){
        int length = input.size();
        Integer globalMin = Integer.MAX_VALUE;
        int counter = 0;
        int curSize = 0;
        //找到min
    
        while (buffer.size() != length){
            // System.out.println("input: "+ input.toString());
            // System.out.println("buffer: " + buffer.toString());
            // push everything to stack2 to find the min
            while(!input.isEmpty()){
                Integer cur = input.pop();
                buffer.push(cur);
                if(cur < globalMin) globalMin = cur;
                if(cur == globalMin) counter ++;
            }
            // push everything back to stack1 except the min
            // don't pop the sorted elements in Stack2
            // System.out.println("curSize " + curSize);
            while(buffer.size() > curSize){
                Integer cur = buffer.pop();
                if(cur != globalMin) input.push(cur);
            }

            // now push all mins to stack2
            while(counter --> 0){
                buffer.push(globalMin);
            }
            curSize = buffer.size();
            globalMin = Integer.MAX_VALUE;
            counter = 0;
        }
        System.out.println(buffer.toString());
        input = buffer;
    }


    public static void main(String[] args){
        stackQueue solution = new stackQueue();
        LinkedList aStack = new LinkedList<>();

        Integer a = 1;
        Integer b = 4;
        Integer c = 2;
        Integer d = 1;

        aStack.push(a);
        aStack.push(b);
        aStack.push(c);
        aStack.push(d);
        LinkedList<Integer> test = new LinkedList<>();
        System.out.println("input is: " + aStack.toString());
        solution.sort(aStack);
        System.out.println(aStack.toString());
        
    }
}
