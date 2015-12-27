/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.pathingLogic;

/**
 *
 * @author lari
 */
public final class Utility {
    public static boolean isZeroPoint(int[] point){
        return point[0]==0&&point[1]==0;
    }
    
    public static double distance(int[] startPoint, int[] endPoint){
        return (Math.sqrt(Math.pow((double)(endPoint[0]-startPoint[0]), 2.0)+Math.pow((double)(endPoint[1]-startPoint[1]), 2.0)));
    }
    
}
