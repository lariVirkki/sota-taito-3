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
    /*
    public boolean isItIn(int x, int y){
        for (Rectangle collection1 : collection) { //pretty :3
            if (collection1.isItIn(x, y)) {
                return true;
            }
        }
        return false;
    }
    */
    
    public int[] lineCrosses(int startX, int startY, int endX, int endY){
        int[] output = new int[2];
        output[0]=0; output[1]=0;
        for (int i =0; i<collection.length; i++){
            int x=collection[i].lineCrosses(startX, startY, endX, endY)[0];
            int y=collection[i].lineCrosses(startX, startY, endX, endY)[1];
            if (!(x==0&&y==0)){
                if(output[0]==0&&output[1]==0){
                    output[0]=x; output[1]=y;
                }else if (this.distance(startX, startY, output[0], output[1])>this.distance(startX, startY, x, y)){
                    output[0]=x; output[1]=y;
                }
            } 
        }
        return output;
    }
    
    private int distance(int startX, int startY, int endX, int endY){
        return (int) (Math.sqrt(Math.pow((double)(endX-startX), 2.0)+Math.pow((double)(endY-startY), 2.0)));
    }
}
