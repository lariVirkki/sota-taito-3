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
public class RectangleCreatorTest {
    
    @Test
    public void testSimple(){
        String map=".....\n..##.\n..##.\n.....\n.....\n";
        Rectangle [] ayy=mapCreationTest(map);
        String shah=print(ayy);
        org.junit.Assert.assertEquals("[150, 200, 50, 100]",shah);
    }
    
    @Test
    public void testCorner(){
        String map="..##\n..##\n....\n....\n";
        Rectangle[] ayy=mapCreationTest(map);
        String shah=print(ayy);
        org.junit.Assert.assertEquals("[100, 200, 0, 100]",shah);
    }
    
    @Test
    public void testBlob(){
        String map="......\n..###.\n.###..\n......\n";
        Rectangle[] ayy=mapCreationTest(map);
        String shah=print(ayy);
        org.junit.Assert.assertEquals("[100, 250, 50, 100]" + "[150, 200, 100, 50]",shah);
    }
    
    @Test
    public void testMultiple(){
        String map="..##\n..##\n##..\n##..\n";
        Rectangle[] ayy=mapCreationTest(map);
        String shah=print(ayy);
        org.junit.Assert.assertEquals("[100, 200, 0, 100]" + "[200, 100, 100, 0]",shah);
    }
    
    static Rectangle[] mapCreationTest(String map){
        Rectangle[] shah= new Rectangle[100];
        return RectangleCreator.getRectangles(map,shah);
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
