/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic;
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
        junit.extensions.TestSetup.assertEquals( rec.isItIn(x, y), true);
    }
    
    @Test
    public void isInWorksNegative(){
        int bottom=0;
        int top=100;
        int left=0;
        int right=100;
        Rectangle rec = new Rectangle(top, bottom, left, right);
        int x=(int) (Math.random()*100);
        int y=(int) (Math.random()*100);
        if (x<=50) x=-50;
        if (x>50) x=+50;
        if (y>=50) y=+50;
        if (y<50) y=-50;
        junit.extensions.TestSetup.assertEquals( rec.isItIn(x, y), false);
    }
}
