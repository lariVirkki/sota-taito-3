/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.pathingLogic;

import gameLogic.mapCreation.MapCreator;
import org.junit.Test;

/**
 *
 * @author lari
 */
public class PathingTest {
    // the purpose of this class is to test pathing
    @Test
    public void straightPath(){
        String file="............\n" +
"............\n" +
".....x......\n" +
"............\n" +
"............\n" +
"............\n" +
"............\n" +
"............\n" +
"............\n" +
".....y......\n" +
"............\n" +
"............\n";
        Map kartta=MapCreator.create(file);
        DoublyLinkedList path= new DoublyLinkedList(new TwoWayNode(new int[]{270,250}));
        path=kartta.yksi(path, new int[]{270,500});
        DoublyLinkedList expected= new DoublyLinkedList(new TwoWayNode(new int[]{270,250}));
        expected.add(new TwoWayNode(new int[]{270,500}));
        org.junit.Assert.assertEquals(expected, path);
    }
    
}
