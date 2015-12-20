/*
 * Made by Lari Virkki
 * pls no copypasterino
 */
package gameLogic;

/**
 *
 * @author lari
 */
public class RingNode {
    private RingNode left, right;
    private int[] coordinates;
    
    //--------CONSTRUCTORS
    
    public RingNode(int x, int y, RingNode existingNeighbor){
        left=existingNeighbor;
        coordinates[0]=x;
        coordinates[1]=y;
    }
    
    public RingNode(int x, int y){  //nodes don't need to be moved
        coordinates[0]=x;
        coordinates[1]=y;
    }
    
    //-----------GETTERS
    
    public RingNode left(){
        return this.left;
    }
    
    public RingNode right(){
        return this.right;
    }
    
    public int[] coord(){
        return this.coordinates;
    }
    
    //-----------SETTERS
    
    public void setRight(RingNode node){
        this.right=node;
    }
    
    public void setLeft(RingNode node){
        this.left=node;
    }
    
}
