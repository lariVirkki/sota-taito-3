/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.pathingLogic;

/**
 *
 * @author lari
 */
public class RectangleCollection {
    private Rectangle[] collection;
    //each instance of this class contains one patch of unpathable terrain
    public RectangleCollection(int maxSize){
        collection = new Rectangle[maxSize];
    }
    
    public void add(Rectangle addend){ //everything falls apart if we add the same
        for (int i=0; i<collection.length;i++){ //rectangle multiple times!!
            if (collection[i]==null){
                collection[i]=addend;
                break;
            }
        }
    }
    
    public boolean isItIn(int[] point){
        for (int i=0;i<collection.length;i++){
            if(collection[i]==null) break;
            if(collection[i].isItIn(point)) return true;
        }
        return false;
    }
    
    public boolean overlaps(Rectangle rec){
        for (int i=0;i<collection.length;i++){
            if (collection[i]==null)break;
            if (collection[i].overlaps(rec)) return true;
        }
        return false;
    }
    
    
    public int[] lineCrosses(int[] startPoint, int[] endPoint){
        int[] output = new int[2];
        output[0]=0; output[1]=0;
        for (int i =0; i<collection.length; i++){
            if (collection[i]==null) break; //null breakers are necessary :DD
            int[] point = collection[i].lineCrosses(startPoint, endPoint);
            if (!Utility.isZeroPoint(point)){
                if(Utility.isZeroPoint(output)){
                    output=point;
                }else if (Utility.distance(startPoint, output)>Utility.distance(startPoint, point)){
                    output=point;
                }
            }
        }
        return output;
    }
    
    public int[][][] getPoints(){
        int[][][] output=new int[collection.length][4][2];
        for (int i=0;i<collection.length;i++){
            if (collection[i]==null) break;
            output[i]=collection[i].getPoints();
        }
        return output;
    }
}
