/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.pathingLogic;

/**
 *
 * @author lari
 * offers some simple utility
 */
public final class Utility {
    /**
     * decides if a point is "zero" or not
     * @param point the point that needs evaluation
     * note the array can carry more information. only the first two indexes are treated as coordinates of a point 
     */
    public static boolean isZeroPoint(int[] point){
        return point[0]==0&&point[1]==0;
    }
    
    /**
     * @param startPoint one integer array whose first two indexes are treated as a point in plane
     * @param endPoint other array
     * @return the distance between points
     */
    public static double distance(int[] startPoint, int[] endPoint){
        return (Math.sqrt(Math.pow((double)(endPoint[0]-startPoint[0]), 2.0)+Math.pow((double)(endPoint[1]-startPoint[1]), 2.0)));
    }
    
    /**
     * once again, a point is just the beginning of an array
     * @param addend1 just what it sounds like
     * @param addend2 --"--
     * @return the vector sum of these points
     */
    public static int[] pointAddition(int[] addend1, int[] addend2){ //...for points
        return new int[]{addend1[0]+addend2[0],addend1[1]+addend2[1]};
    }
    
}
