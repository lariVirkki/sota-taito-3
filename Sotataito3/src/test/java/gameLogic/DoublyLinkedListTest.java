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
    }
    
    @Test
    public void addTest(){
        DLLNode firstnode=new DLLNode(0,0);
        DoublyLinkedList list = new DoublyLinkedList(firstnode);
        DLLNode addend=new DLLNode(1,3);
        list.add(addend);
        junit.extensions.TestSetup.assertEquals(list.toString(),"(0, 0)(1, 3)");
    }
    
    @Test
    public void removeOneTest(){
        DLLNode eka=new DLLNode(1,1);
        DLLNode toka=new DLLNode(1,2);
        DLLNode kolmas=new DLLNode(3,3);
        DoublyLinkedList lista=new DoublyLinkedList(eka);
        lista.add(toka);
        lista.add(kolmas);
        lista.remove(eka, kolmas);
        junit.extensions.TestSetup.assertEquals(lista.toString(), "(1, 1)(3, 3)");
    }
    
    @Test
    public void removeManyTest(){
        DLLNode eka=new DLLNode(1,1);
        DLLNode toka=new DLLNode(1,2);
        DLLNode kolmas=new DLLNode(3,3);
        DLLNode neljas=new DLLNode(6,7);
        DLLNode viides=new DLLNode(3,4);
        DLLNode kuudes=new DLLNode(4,1);
        DLLNode seitsemas=new DLLNode(7,2);
        DoublyLinkedList lista=new DoublyLinkedList(eka);
        lista.add(toka);
        lista.add(kolmas);
        lista.add(neljas);
        lista.add(viides);
        lista.add(kuudes);
        lista.add(seitsemas);
        lista.remove(toka, viides);
        junit.extensions.TestSetup.assertEquals(lista.toString(), "(1, 1)(1, 2)(3, 4)(4, 1)(7, 2)");
    }
}
