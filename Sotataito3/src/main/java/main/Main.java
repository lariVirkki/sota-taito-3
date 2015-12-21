/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package main;
import gameLogic.*;
/**
 *
 * @author lari
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        System.out.println("MOI!!!");
        TwoWayNode pasi=new TwoWayNode(1,2);
        TwoWayNode joni=new TwoWayNode(609,13);
        DoublyLinkedList testilista=new DoublyLinkedList(pasi);
        System.out.println(testilista.toString());
        testilista.add(joni);
        System.out.println(testilista.toString());
    }
}
