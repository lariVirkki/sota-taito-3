/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic;

/**
 *
 * @author lari
 */
public class RecColle {
    private Rectangle[] collection;
    //each instance of this class contains one patch of unpathable terrain
    public RecColle(int maxSize){
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
        for (Rectangle collection1 : collection) { //pretty :3
            if (collection1.isItIn(point)) {
                return true;
            }
        }
        return false;
    }
    
    
    public int[] lineCrosses(int[] startPoint, int[] endPoint){
        int[] output = new int[2];
        output[0]=0; output[1]=0;
        for (int i =0; i<collection.length; i++){
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
}
