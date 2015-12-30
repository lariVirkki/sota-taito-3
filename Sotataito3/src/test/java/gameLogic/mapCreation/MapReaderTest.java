/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.mapCreation;

import gameLogic.pathingLogic.Rectangle;
import org.junit.Test;

/**
 *
 * @author lari
 */
public class MapReaderTest {
    
    @Test
    public void testSimple(){
        String map=".....\n..##.\n..##.\n.....\n.....\n";
        Rectangle [] ayy=mapCreationTest(map);
        String shah=print(ayy);
        org.junit.Assert.assertEquals("[2, 3, 1, 2]",shah);
    }
    
    @Test
    public void testCorner(){
        String map="..##\n..##\n....\n....\n";
        Rectangle[] ayy=mapCreationTest(map);
        String shah=print(ayy);
        org.junit.Assert.assertEquals("[1, 3, 0, 2]",shah);
    }
    
    @Test
    public void testBlob(){
        String map="......\n..###.\n.###..\n......\n";
        Rectangle[] ayy=mapCreationTest(map);
        String shah=print(ayy);
        org.junit.Assert.assertEquals("[1, 4, 1, 2]" + "[2, 3, 2, 1]",shah);
    }
    
    @Test
    public void testMultiple(){
        String map="..##\n..##\n##..\n##..\n";
        Rectangle[] ayy=mapCreationTest(map);
        String shah=print(ayy);
        org.junit.Assert.assertEquals("[1, 3, 0, 2]" + "[3, 1, 2, 0]",shah);
    }
    
    static Rectangle[] mapCreationTest(String map){
        Rectangle[] shah= new Rectangle[100];
        return RectangleCreator.getRectangles(map,shah,0);
    }
    
    static String print(Rectangle[] ayy){
        String output="";
        for (int i=0; i<3;i++){
            if (ayy[i]!=null){
                output=output+ayy[i].toString();
            }else{
                break;
            }
        }
        return output;
    }
}
