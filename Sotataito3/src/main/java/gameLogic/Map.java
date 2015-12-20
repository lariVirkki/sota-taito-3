/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic;

/**
 *
 * @author lari
 */
public class Map {
    private Ring[] ringList;
    private RecColle[] unPathableList; 
// these index have to match so that ringlist[n] is the ring that surrounds
// the patch of unpathable terrain reccolle[n]
    
    public Path pathing(int xStart, int yStart, int xGoal, int yGoal){
        return new Path();
    }
}
