/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.pathingLogic;

import java.util.Arrays;

/**
 *
 * @author lari
 */
public class RectangleCollection {
    private Rectangle[] collection;
    /**
     * each instance of this class contains one patch of unpathable terrain
     */
    public RectangleCollection(int maxSize){
        collection = new Rectangle[maxSize];
    }
    
    /**
     * adds addend to the collection
     * @param addend 
     */
    public void add(Rectangle addend){ //everything falls apart if we add the same
        for (int i=0; i<collection.length;i++){ //rectangle multiple times!!
            if (collection[i]==null){
                collection[i]=addend;
                break;
            }
        }
    }
    
    /**
     * checks if this collection covers a point
     * @param point
     * @return 
     */
    public boolean isItIn(int[] point){
        for (int i=0;i<collection.length;i++){
            if(collection[i]==null) break;
            if(collection[i].isItIn(point)) return true;
        }
        return false;
    }
    
    /**
     * checks if this collection covers a point. border points will return false
     * @param point
     * @return 
     */
    public boolean isItInEx(int[] point){
        for (int i=0;i<collection.length;i++){
            if(collection[i]==null) break;
            if(collection[i].isItInEx(point)) return true;
        }
        return false;
    }
    
    /**
     * @param rec
     * @return true iff one of the rectangles in collection overlaps with rec
     */
    public boolean overlaps(Rectangle rec){
        for (int i=0;i<collection.length;i++){
            if (collection[i]==null)break;
            if (collection[i].overlaps(rec)) return true;
        }
        return false;
    }
    
    /**
     * 
     * @param startPoint
     * @param endPoint
     * @return the closest point to startPoint that is mutual to line between start- and endPoint and one of the lines contained in this collection
     */
    public int[] lineCrosses(int[] startPoint, int[] endPoint){
        int[] output = new int[]{0,0};
        for (int i =0; i<collection.length; i++){
            //System.out.println("this is iteration number "+i);
            if (collection[i]==null){
                //System.out.println("recColle cross broke at i="+i);
                break;
            } //null breakers are necessary :DD
            int[] point = collection[i].lineCrosses(startPoint, endPoint);
            //System.out.println("Point found is: "+Arrays.toString(point)); //this point isn't reached at all??
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
    
    /**
     * output[rectangle number][corner number] = {x,y}
     * output[rectangle number] = {top{x,y},right{x,y},bottom{x,y},left{x,y}}
     * @return the output described above
     */
    public int[][][] getPoints(){
        int[][][] output=new int[collection.length][4][2];
        for (int i=0;i<collection.length;i++){
            if (collection[i]==null) break;
            output[i]=collection[i].getPoints();
        }
        return output;
    }
    
    @Override
    public String toString(){
        int i=0;
        String output="";
        while(this.collection[i]!=null){
            output+=collection[i].toString();
            i++;
        }
        return output;
    }
}
