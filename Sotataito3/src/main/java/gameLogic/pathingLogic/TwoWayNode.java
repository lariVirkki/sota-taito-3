/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.pathingLogic;

/**
 *
 * @author lari
 */
public class TwoWayNode {
    private int[] coordinates;
    private TwoWayNode next, previous;
    
    public TwoWayNode(int[] point){
        coordinates=point;
    }
    
    //------GETTERS
    public TwoWayNode getNext(){
        return this.next;
    }
    
    public TwoWayNode getPrevious(){
        return this.previous;
    }
    
    public int[] getCoords(){
        return this.coordinates;
    }
    
    //------SETTERS
    
    public void setNext(TwoWayNode future){
        this.next=future;
    }
    
    public void setPrevious(TwoWayNode future){
        this.previous=future;
    }
    
    //-------EQUALS
    
    public boolean equals(TwoWayNode anotherNode){
        return (this.coordinates[0]==anotherNode.getCoords()[0]&&this.coordinates[1]==anotherNode.getCoords()[1]);
    }
    
    //----Testing-related
    
    
    @Override
    public String toString(){
        return "("+Integer.toString(this.coordinates[0])+", "+Integer.toString(this.coordinates[1])+")";
    }
    
    @Override
    public TwoWayNode clone(){
        return new TwoWayNode(this.getCoords());
    }
}
