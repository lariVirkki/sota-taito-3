/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic;
import org.junit.*;
/**
 *
 * @author lari
 */
public class DoublyLinkedListTest {
    
    @Before
    public void setUp(){
        DLLNode firstnode=new DLLNode(0,0);
        DoublyLinkedList testList = new DoublyLinkedList(firstnode);
        DLLNode addend=new DLLNode(1,3);
    }
    
    @Test
    public void addTest(){
        DLLNode firstnode=new DLLNode(0,0);
        DoublyLinkedList list = new DoublyLinkedList(firstnode);
        DLLNode addend=new DLLNode(1,3);
        list.add(addend);
        junit.extensions.TestSetup.assertEquals(list.toString(),"(0, 0)(1, 3)");
    }
}
