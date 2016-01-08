/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.pathingLogic;
import gameLogic.pathingLogic.Rectangle;
import java.util.Arrays;
import org.junit.*;
/**
 *
 * @author lari
 */
public class RectangeTest {
    
    @Test
    public void isInWorksPositive(){
        int bottom=0;
        int top=100;
        int left=0;
        int right=100;
        Rectangle rec = new Rectangle(top, bottom, left, right);
        int x=(int) (Math.random()*100);
        int y=(int) (Math.random()*100);
        int[] point=new int[2];
        point[0]=x;
        point[1]=y;
        junit.extensions.TestSetup.assertEquals( rec.isItIn(point), true);
    }
    
    @Test
    public void isInWorksNegative(){
        Rectangle rec = new Rectangle(100, 0, 0, 100);
        int x=(int) (Math.random()*100);
        int y=(int) (Math.random()*100);
        if (x<=50) x+=-51;
        if (x>50) x+=+50;
        if (y>=50) y+=+51;
        if (y<50) y+=-50;
        int[] point=new int[]{x,y};
       // System.out.println(Arrays.toString(point));
        junit.extensions.TestSetup.assertEquals( false, rec.isItIn(point));
    }
    
    @Test
    public void isInEXWorksNegative(){
        Rectangle rec = new Rectangle(100, 0, 0, 100);
        int x=(int) (Math.random()*100);
        int y=(int) (Math.random()*100);
        if (x<=50) x+=-51;
        if (x>50) x+=+50;
        if (y>=50) y+=+51;
        if (y<50) y+=-50;
        int[] point=new int[]{x,y};
       // System.out.println(Arrays.toString(point));
        junit.extensions.TestSetup.assertEquals( false, rec.isItIn(point));
    }
    
    @Test
    public void lineCrossesPositiveY(){  //just to see if [0,0] works as a proper 'false'. this one goes through the Y-axis RANDOMS POORLY CHOSEN!!! 
        Rectangle rec= new Rectangle(1000,0,0,1000); 
        org.junit.Assert.assertEquals(false, Utility.isZeroPoint(rec.lineCrosses(new int[]{10000,100},new int[] {-300,500})));  
    }
    
    @Test
    public void lineCrossesPositiveX(){  //had to fix a -/+ thingie in this test... S A D B O Y S
        Rectangle rec=new Rectangle(100,0,0,100);
        org.junit.Assert.assertEquals(false, Utility.isZeroPoint(rec.lineCrosses(new int[]{-20,90},new int[] {200,50})));  
    }
    
}
