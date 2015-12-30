/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package main;
import gameLogic.pathingLogic.Rectangle;
import gameLogic.mapCreation.*;
import gameLogic.pathingLogic.DoublyLinkedList;
import gameLogic.pathingLogic.TwoWayNode;
import java.util.Arrays;
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
        /* while(true){
            isInWorksPositive();
        }
        */
        TwoWayNode node=new TwoWayNode(new int[255]);
        DoublyLinkedList listOfLists=new DoublyLinkedList(node); //the list contained in this list will be
        listOfLists.getFirst().getCoords()[0]=12;
        System.out.println(listOfLists.getFirst().getCoords()[0]);
    }
        
}

