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
        //System.out.println(listOfLists.getFirst().getCoords()[0]);
        /*
        Rectangle rec = new Rectangle(100, 0, 0, 100);
        int x=(int) (Math.random()*100);
        int y=(int) (Math.random()*100);
        if (x<=50) x+=-51;
        if (x>50) x+=+50;
        if (y>=50) y+=+51;
        if (y<50) y+=-50;
        int[] point=new int[]{x,y};
        System.out.println(Arrays.toString(point));
        System.out.println(rec.isItIn(point));


        //junit.extensions.TestSetup.assertEquals( false, rec.isItIn(point));
        String shah=".....\n.....\n.....\n.....\n.....\n.....\n";
        System.out.println(shah);
        System.out.println("-----------------------------------");
        System.out.println(SanityCheck.linesAreOfUniformLength(shah, new int[]{6,6}));

        */
        String file="###########\n" +
"#.........#\n" +
"#.........#\n" +
"#....x....#\n" +
"#.........#\n" +
"#.........#\n" +
"#.........#\n" +
"#.........#\n" +
"#.........#\n" +
"#.........#\n" +
"#.........#\n" +
"#....y....#\n" +
"#.........#\n" +
"#.........#\n" +
"###########\n";
        System.out.println(SanityCheck.spawnPointsAreSane(file, SanityCheck.dimensions(file)));
    }
    
        
}

