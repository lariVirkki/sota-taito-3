/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.pathingLogic;

import gameLogic.mapCreation.MapCreator;
import org.junit.Test;

/**
 *
 * @author lari
 */
public class MapTest {
    @Test
    public void unPath(){
        Map map=MapCreator.create("..........................\n" +
"............#.............\n" +
"....y.......#.......x.....\n" +
"............#.............\n" +
"..........................\n");
        int[] output=map.unPathableInTheWay(new int[]{1,150}, new int[]{3,160});
        org.junit.Assert.assertEquals(true, Utility.isZeroPoint(output));
    }
    
    @Test
    public void unPath2(){
        Map map=MapCreator.create("..........................\n" +
"............#.............\n" +
"....y.......#.......x.....\n" +
"............#.............\n" +
"..........................\n");
        int[] output=map.unPathableInTheWay(new int[]{1,150}, new int[]{800,160});
        org.junit.Assert.assertEquals(false, Utility.isZeroPoint(output));
    }
    @Test
    public void unPath3(){
        Map map=MapCreator.create("..........................\n" +
"............#.............\n" +
"....y.......#.......x.....\n" +
"............#.............\n" +
"..........................\n");
        int[] output=map.unPathableInTheWay(new int[]{1,150}, new int[]{800,160});
        org.junit.Assert.assertEquals(600, output[0]);
    }
    
    @Test
    public void outOfBounds(){
        Map map=MapCreator.create("..........................\n" +
"............#.............\n" +
"....y.......#.......x.....\n" +
"............#.............\n" +
"..........................\n");
        int[] output=map.unPathableInTheWay(new int[]{1,150}, new int[]{800,160});
        org.junit.Assert.assertEquals(true, map.outOfBoundsPoint(new int[]{-1,-150}));
    }
    
    @Test
    public void outOfBounds2(){
        Map map=MapCreator.create("..........................\n" +
"............#.............\n" +
"....y.......#.......x.....\n" +
"............#.............\n" +
"..........................\n");
        int[] output=map.unPathableInTheWay(new int[]{1,150}, new int[]{800,160});
        org.junit.Assert.assertEquals(true, map.outOfBoundsPoint(new int[]{100,-150}));
        org.junit.Assert.assertEquals(true, map.outOfBoundsPoint(new int[]{100,90001}));
        org.junit.Assert.assertEquals(true, map.outOfBoundsPoint(new int[]{90001,150}));
        org.junit.Assert.assertEquals(true, map.outOfBoundsPoint(new int[]{-100,150}));
        org.junit.Assert.assertEquals(false, map.outOfBoundsPoint(new int[]{100,150}));
    }
    
    
}
