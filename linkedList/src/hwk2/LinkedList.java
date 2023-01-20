package hwk2;

/**
 * Linked List is a collection of data nodes.  All methods here relate to
 * how one can manipulate those nodes.
 * 
 * @author Irene Yin
 * @version Oct.7.2019
 */
public class LinkedList
{
    private int length;          // number of nodes the linkList have in total
    private ListNode firstNode;  // pointer to first node

    public LinkedList()
    {
        length=0;
        firstNode=null;
    }

    public ListNode merge(ListNode one, ListNode two){
        ListNode temp1 = one;
        ListNode temp2 = two;
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while(temp1 != null && temp2 != null){
        // compare current value
        if(temp1.value <= temp2.value){
            cur.next = temp1;
            temp1 = temp1.next;
        }
        else{
            cur.next = temp2;
            temp2 = temp2.next;
        }
        cur = cur.next;
        }
        if(temp1 == null) res.next = temp2;
        else res.next = temp1;
        return two;
    }
    

    /** insert new String at linked list's head
     * 
     * @param newData the String to be inserted
     */
    public void insertAtHead(int newData)
    {
    	ListNode newNode = new ListNode(newData);
        if (isEmpty())
        {
            firstNode=newNode;
        }
        else
        {
            newNode.next=firstNode;
            firstNode=newNode;
        }
        length++;
    }
    
    /** remove and return data at the head of the list 
     * 
     *  @return the String the deleted node contains.  Returns null if list empty.
     */
    public String removeHead()
    {
        if (!isEmpty()){
            String toReturn = firstNode.toString();
            firstNode = firstNode.next;
            length--;
            return toReturn;
        }
        else{ //if the linkList is empty
            return null;
        }

    }
    
    /** insert data at end of list
     * 
     * @param newData new int to be inserted
     */
    public void insertAtTail(int newData)
    {
        ListNode newNode = new ListNode(newData);
        if (!isEmpty()){
            ListNode nextNode = firstNode;

            for(int i = 1; i < getLength(); i++){
                nextNode = nextNode.next;
            }
            nextNode.next = newNode;
        }
        else{// if linkList is empty
            firstNode = newNode;
        }
        length++;
    }

    /**
     * 
     * @return length of LL
     */
    public int getLength() {return length;}
    
    /**
     * 
     * @return true if LL empty or false if not
     */
    public boolean isEmpty() {return getLength()==0;}


    public static void main(String[] args){
        LinkedList solution = new LinkedList();
        LinkedList a = new LinkedList();
        System.out.println(a);
    }
}

