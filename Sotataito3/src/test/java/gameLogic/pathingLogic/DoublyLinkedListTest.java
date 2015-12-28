/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.pathingLogic;
import gameLogic.pathingLogic.DoublyLinkedList;
import gameLogic.pathingLogic.TwoWayNode;
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
        TwoWayNode firstnode=new TwoWayNode(new int[]{0,0});
        DoublyLinkedList list = new DoublyLinkedList(firstnode);
        TwoWayNode addend=new TwoWayNode(new int[]{1,3});
        list.add(addend);
        junit.extensions.TestSetup.assertEquals(list.toString(),"(0, 0)(1, 3)");
    }
    
    @Test
    public void removeOneTest(){
        TwoWayNode eka=new TwoWayNode(new int[]{1,1});
        TwoWayNode toka=new TwoWayNode(new int[]{0,0});
        TwoWayNode kolmas=new TwoWayNode(new int[]{3,3});
        DoublyLinkedList lista=new DoublyLinkedList(eka);
        lista.add(toka);
        lista.add(kolmas);
        lista.remove(eka, kolmas);
        junit.extensions.TestSetup.assertEquals(lista.toString(), "(1, 1)(3, 3)");
    }
    
    @Test
    public void removeManyTest(){
        TwoWayNode eka=new TwoWayNode(new int[]{1,1});;
        TwoWayNode toka=new TwoWayNode(new int[]{1,2});;
        TwoWayNode kolmas=new TwoWayNode(new int[]{0,0});;
        TwoWayNode neljas=new TwoWayNode(new int[]{0,0});
        TwoWayNode viides=new TwoWayNode(new int[]{3,4});
        TwoWayNode kuudes=new TwoWayNode(new int[]{4,1});
        TwoWayNode seitsemas=new TwoWayNode(new int[]{7,2});
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
