/**
 * JUnit test class.
 */
import org.junit.*;
import org.junit.rules.Timeout;

import linkedList.LinkedList;

import static org.junit.Assert.*;

public class linkedListTest
{
    @Rule // a test will fail if it takes longer than 1/10 of a second to run
    public Timeout timeout = Timeout.millis(100);

    @Test // the first listNode in the linkList should be removed with element inside
    public void testRemoveHead(){
        LinkedList c = new LinkedList();
        c.insertAtHead("a");
        c.insertAtHead("b");
        assertEquals("(b,a)",c.toString());
        assertEquals("b",c.removeHead());
        assertEquals("(a)",c.toString());
        assertEquals(1,c.getLength());
    }

    @Test // removeHead method should do nothing if there's no listNode inside.
    public void testRemoveHead2(){
        LinkedList c = new LinkedList();
        assertEquals(null,c.removeHead());


    }

    @Test // there should be the listNode we assign at the end of the LinkList.
    public void testInsertAtTail(){
        LinkedList c = new LinkedList();
        c.insertAtHead("c");
        c.insertAtHead("b");
        c.insertAtHead("a");
        c.insertAtTail("d");

        assertEquals("(a,b,c,d)", c.toString());

    }

    @Test // there should be the listNode we assign at the end of the LinkList.
    public void testInsertAtTail2(){
        LinkedList c = new LinkedList();
        c.insertAtTail("a");

        assertEquals("(a)", c.toString());
        assertEquals(1,c.getLength());

    }

    @Test // there should be the listNode we assign at the end of the LinkList.
    public void testInsertAtTail3(){
        LinkedList c = new LinkedList();
        c.insertAtHead("a");
        c.insertAtTail("b");

        assertEquals("(a,b)", c.toString());
        assertEquals(2,c.getLength());

    }

    @Test // should return the address of the listNode data we want.
    public void testIndexOf_Found(){
        LinkedList c = new LinkedList();
        c.insertAtHead("c");
        c.insertAtHead("b");
        c.insertAtHead("a");
        assertEquals(0,c.indexOf("a"));


    }

    @Test // should return the index of the listNode data we want. two same data
    public void testIndexOf_Found2(){
        LinkedList c = new LinkedList();
        c.insertAtHead("c");
        c.insertAtHead("b");
        c.insertAtHead("a");
        c.insertAtHead("a");
        assertEquals(2,c.indexOf("b"));


    }
    @Test // should return the index of the listNode data we want. two same data
    public void testIndexOf_Found3(){
        LinkedList c = new LinkedList();
        c.insertAtHead("c");
        c.insertAtHead("b");
        c.insertAtHead("a");
        c.insertAtHead("a");
        assertEquals(3,c.indexOf("c"));


    }

    @Test // should return -1 since there is no such data.
    public void testIndexOf_notFound(){
        LinkedList c = new LinkedList();
        c.insertAtHead("a");
//        c.insertAtHead("b");
//        c.insertAtHead("c");
        assertEquals(-1,c.indexOf("d"));

    }

    @Test // should return -1 since there is no such data.
    public void testIndexOf_emtpty(){
        LinkedList c = new LinkedList();
        assertEquals(-1,c.indexOf("d"));

    }
}
