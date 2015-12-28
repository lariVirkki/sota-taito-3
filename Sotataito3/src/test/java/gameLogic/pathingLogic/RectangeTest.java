/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.pathingLogic;
import gameLogic.pathingLogic.Rectangle;
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
        if (x==0) x=1;
        if (x==100) x=99;
        if (y==0) y=1;
        if (y==100) y=99;
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
        if (x<=50) x=-51;
        if (x>50) x=+50;
        if (y>=50) y=+51;
        if (y<50) y=-50;
        int[] point=new int[]{x,y};
        junit.extensions.TestSetup.assertEquals( false, rec.isItIn(point));
    }
    
    @Test
    public void lineCrossesPositiveY(){  //just to see if [0,0] works as a proper 'false'
        int top = (int)(Math.random()*1000);
        int bottom = (int)(Math.random()*1000);
        int left = (int)(Math.random()*1000);
        int right = (int)(Math.random()*1000);
        Rectangle rec= new Rectangle(top,bottom,left,right);
        int x1=left+(int)(Math.random()*(right-left));
        int x2=left+(int)(Math.random()*(right-left));
        int y1=bottom-(int)(Math.random()*100);
        int y2=top+(int)(Math.random()*100);
        int[] ayy = new int[2];
        ayy[0]=0; ayy[1]=0;
        junit.extensions.TestSetup.assertNotSame(ayy, rec.lineCrosses(new int[]{x1,y1},new int[] {x2, y2}));  
    }
    
    @Test
    public void lineCrossesPositiveX(){  //just to see if [0,0] works as a proper 'false'
        int top = (int)(Math.random()*1000);
        int bottom = (int)(Math.random()*1000);
        int left = (int)(Math.random()*1000);
        int right = (int)(Math.random()*1000);
        Rectangle rec= new Rectangle(top,bottom,left,right);
        int y1=bottom+(int)(Math.random()*(right-left));
        int y2=bottom+(int)(Math.random()*(right-left));
        int x1=left-(int)(Math.random()*100);
        int x2=right+(int)(Math.random()*100);
        int[] ayy = new int[2];
        ayy[0]=0; ayy[1]=0;
        junit.extensions.TestSetup.assertNotSame(ayy, rec.lineCrosses(new int[]{x1, y1},new int[] {x2, y2}));  
    }
}
