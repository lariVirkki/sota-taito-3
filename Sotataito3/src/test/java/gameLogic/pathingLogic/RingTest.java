/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.pathingLogic;
import gameLogic.pathingLogic.*;
import org.junit.Before;
import org.junit.Test;
/**
 *
 * @author lari
 */
public class RingTest {

    
    
    @Test
    public void closingCloses(){
        TwoWayNode start=new TwoWayNode(new int[]{0,0});
        Ring rinkula=new Ring(start);
        TwoWayNode node =new TwoWayNode(new int[]{1,0});
        rinkula.add(node);
        rinkula.addAndClose(new TwoWayNode(new int[]{2,0}));
        org.junit.Assert.assertEquals(node, start.getPrevious().getPrevious());
    }
    
    public void closingCloses2(){
        TwoWayNode start=new TwoWayNode(new int[]{0,0});
        Ring rinkula=new Ring(start);
        TwoWayNode node =new TwoWayNode(new int[]{1,0});
        rinkula.add(node);
        rinkula.add(new TwoWayNode(new int[]{3,0}));
        rinkula.addAndClose(new TwoWayNode(new int[]{2,0}));
        org.junit.Assert.assertEquals(start.getNext().getNext(), start.getPrevious().getPrevious());
    }
}
