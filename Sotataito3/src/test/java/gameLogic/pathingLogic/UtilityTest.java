/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.pathingLogic;

import org.junit.Test;

/**
 *
 * @author lari
 */
public class UtilityTest {
    @Test
    public void zeroPointPositive(){
        org.junit.Assert.assertEquals(true, Utility.isZeroPoint(new int[]{0,0}));
    }
    
    public void zeroPointNegative(){
        org.junit.Assert.assertEquals(false, Utility.isZeroPoint(new int[]{1,0}));
    }
}
