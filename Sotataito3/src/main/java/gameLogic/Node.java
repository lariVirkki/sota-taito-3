/*
 * Made by Lari Virkki
 * pls no copypasterino
 */
package gameLogic;

/**
 *
 * @author lari
 */
public class Node {
    private Node left, right;
    private int[] coordinates;
    
    //--------CONSTRUCTORS
    
    public Node(int x, int y, Node existingNeighbor){
        left=existingNeighbor;
        coordinates[0]=x;
        coordinates[1]=y;
    }
    
    public Node(int x, int y){  //nodes don't need to be moved
        coordinates[0]=x;
        coordinates[1]=y;
    }
    
    //-----------GETTERS
    
    public Node left(){
        return this.left;
    }
    
    public Node right(){
        return this.right;
    }
    
    public int[] coord(){
        return this.coordinates;
    }
    
    //-----------SETTERS
    
    public void setRight(Node node){
        this.right=node;
    }
    
    public void setLeft(Node node){
        this.left=node;
    }
    
}
