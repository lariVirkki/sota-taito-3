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
        path=kartta.idiotPathing(path.getLast().getCoords(), new int[]{270,500});
        System.out.println("path= "+path.toString());
        DoublyLinkedList expected= new DoublyLinkedList(new TwoWayNode(new int[]{270,250}));
        expected.add(new TwoWayNode(new int[]{270,500}));
                System.out.println("expected= "+expected.toString());
        org.junit.Assert.assertEquals(true, path.equals(expected));
    }
    
    @Test
    public void noUnPathable(){
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
        TwoWayNode alku=new TwoWayNode(new int[] {100,100});
        DoublyLinkedList path=new DoublyLinkedList(alku);
        org.junit.Assert.assertArrayEquals(new int[] {0,0}, kartta.unPathableInTheWay(path.getLast().getCoords(), new int[] {200,800}));
    }
    
    @Test
    public void idiotStopsAtObstacle(){
        String file="............\n" +
                "............\n" +
                ".....x......\n" +
                "............\n" +
                "............\n" +
                ".##########.\n" +
                "............\n" +
                "............\n" +
                "............\n" +
                ".....y......\n" +
                "............\n" +
                "............\n";
        Map kartta=MapCreator.create(file);
        TwoWayNode alku=new TwoWayNode(new int[] {100,100});
        DoublyLinkedList path=new DoublyLinkedList(alku);
        path=kartta.idiotPathing(path.getFirst().getCoords(), new int[]{100,1000});
        org.junit.Assert.assertArrayEquals(new int[]{100,100},path.getLast().getCoords());
    }
    
    /*
    public void simpleUnPathable(){
        String file="............\n" +
                "............\n" +
                ".....x......\n" +
                "............\n" +
                "............\n" +
                ".###########\n" +
                "............\n" +
                "............\n" +
                "............\n" +
                ".....y......\n" +
                "............\n" +
                "............\n";
        Map kartta=MapCreator.create(file);
        DoublyLinkedList path=new DoublyLinkedList(new TwoWayNode(new int[] {300,150}));
        path=kartta.yksi(path, new int[]{300,500});
        System.out.println("SIMPLE PATH = "+path.toString());
    }
*/
    
}
