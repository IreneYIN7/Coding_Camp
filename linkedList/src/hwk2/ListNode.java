package hwk2;

/**
 * ListNode is a building block for a linked list of data items
 * 
 * @author Zhebin Yin
 * @version Jan/10/2023
 */
public class ListNode
{
    public int value;      
    public ListNode next;  
    
    /** Non-default constructor
     * 
     * @param value a reservation you want stored in this node
     */
    public ListNode(int val)
    {
        value = val;
        next = null;
    }
    
    /**
     * returns data as a printable string
     */
    public String toString()
    {
        String res = "";
        
        return res+value;
    }
    public static void main(String[] args){
        System.out.println("hello");
    }
}
    