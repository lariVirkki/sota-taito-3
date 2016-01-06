/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.mapCreation;

import gameLogic.pathingLogic.RectangleCollection;
import gameLogic.pathingLogic.Ring;
import java.util.Arrays;
import org.junit.Test;

/**
 *
 * @author lari
 */
public class RingCreatorTest {
    
    @Test
    public void simpleRectangle(){
        String file=".........................\n" +
                    ".........####............\n" +
                    "...y.....####.......x....\n" +
                    ".........####............\n" +
                    ".........................\n" +
                    ".........................\n";
        RectangleCollection[] recColle=MapCreator.create(file).getUnPathable();
        Ring[] ringlist= RingCreator.createRingList(recColle);
        for (int i=0; i<ringlist.length;i++){
            if(ringlist[i]==null)break;
            System.out.println(ringlist[i].toString());
        }
    }
    
    @Test
    public void simpleRectangleGetPointsWorks(){
        String file=".........................\n" +
                    ".........####............\n" +
                    "...y.....####.......x....\n" +
                    ".........####............\n" +
                    ".........................\n" +
                    ".........................\n";
        RectangleCollection[] recColle=MapCreator.create(file).getUnPathable();
        String output=Arrays.toString(recColle[0].getPoints()[0][0]);
        output+="\n"+Arrays.toString(recColle[0].getPoints()[0][1]);
        output+="\n"+Arrays.toString(recColle[0].getPoints()[0][2]);
        output+="\n"+Arrays.toString(recColle[0].getPoints()[0][3]);
        org.junit.Assert.assertEquals("[450, 200]\n" +
                                      "[650, 200]\n" +
                                      "[650, 50]\n" +
                                      "[450, 50]", output);
    }
}
