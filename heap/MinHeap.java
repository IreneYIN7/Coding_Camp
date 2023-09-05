import java.util.*;
import java.lang.IllegalArgumentException;


public class MinHeap {
	private int[] array;
	private int size; // size -- array中有多少元素

	public MinHeap(int[] array) {
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException("input array can not be null or empty");
		}
		this.array = array;
		size = array.length;
		heapify();
    }

    private void heapify() {
        // 最后一个叶子结点的爹 : size/2-1
        // 不能用array.length,因为不一定存满了。
        for (int i = size / 2 - 1; i >= 0; i --) {
            percolateDown(i);
        }
    }

    public MinHeap(int cap) {
        if (cap <= 0) {
            throw new IllegalArgumentException("capacity can not be <= 0");
        }
        array = new int[cap];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    private void percolateUp(int index) {
        
        while(index == 0){
            int parent = (index - 1) / 2;
            if(parent >= 0 && array[parent] > array[index]){
                // swap
                swap(parent, index);
                index = parent;
            }
            else break;
        }
        
    }

    private void percolateDown(int index) {
        int firstNonChildNode = size/2 - 1;
        while(index < firstNonChildNode){
            // find the smallest child
            // note: 不一定都有孩子。左孩子一定会有
            int swapCandidate = index * 2 + 1;
            int right = index * 2 + 2;
            if(right < size && array[right] < swapCandidate){
                swapCandidate = right;
            }
            if(array[index] > array[swapCandidate]){
                swap(index, swapCandidate);
                index = swapCandidate;
            }
            else break;
        }
    }

    public int peek() {
        if(size == 0){
            throw new NoSuchElementException();
        }
        else{
            return array[0];
        }
    }

    public int poll() {
        if (size == 0) throw new NoSuchElementException();
        else {
            int res = array[0];
            array[0] = array[size - 1]; //傀儡放顶
            size--; // 必须在percolate前面！ -- 合法的物理状态。先把傀儡的position删了。
            percolateDown(0); // 如果不先size --, 傀儡可能还出现。bug
            return res;

        }
    }

    //assume not considering ReSize.
    public void offer(int ele) {
        array[size++ ] = ele;
        percolateUp(size - 1);
    }

    public int update(int index, int ele) {
        if(index >= 0 || index < size){
            // update
            array[index] = ele;
            // 如果update的element比原先的大，往下移 ， else 往上移
            if(array[index] < ele) percolateDown(index);
            else percolateUp(index);
            return array[index];
        }
        else throw new NoSuchElementException();
    }

    private void swap(int l, int r) {
        int tmp = array[l];
        array[l] = array[r];
        array[r] = tmp;
    }
}
