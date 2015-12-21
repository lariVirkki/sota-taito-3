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
    
    public DoublyLinkedList pathing(int xStart, int yStart, int xGoal, int yGoal){
        TwoWayNode start=new TwoWayNode(xStart, yStart);        //set the starting point, end point, and start constructing the path
        TwoWayNode goal=new TwoWayNode(xGoal,yGoal);
        DoublyLinkedList path=new DoublyLinkedList(start);
        
        return path;
    }
    
    public int[] unPathableInTheWay(int xStart, int yStart, int xGoal, int yGoal){  //sees if there is unpathable terrain between two points in plane, returns 0,0 if none
        
    }
    
    public boolean unpathable(int x, int y){
        for (int i=0; i<unPathableList.length;i++){
            if(unPathableList[i].isItIn(x, y)) return true;
        }
        return false;
    }
}
