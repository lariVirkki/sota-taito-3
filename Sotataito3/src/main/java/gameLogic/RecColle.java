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
    
    public boolean isItIn(int x, int y){
        for (Rectangle collection1 : collection) { //pretty :3
            if (collection1.isItIn(x, y)) {
                return true;
            }
        }
        return false;
    }
}
