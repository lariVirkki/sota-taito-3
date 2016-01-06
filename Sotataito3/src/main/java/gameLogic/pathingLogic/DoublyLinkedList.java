/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.pathingLogic;

/**
 *
 * @author lari
 */
public class DoublyLinkedList {
    private static TwoWayNode FIRST;
    
    public DoublyLinkedList(TwoWayNode node){
        FIRST=node;
    }
    
    /**
     * adds a node to the list
     * @param addend the node to be added
     */
    public void add(TwoWayNode addend){ 
        TwoWayNode current=FIRST;
        addend=addend.clone();
        while (current.getNext()!=null){
            current=current.getNext();
        }
        current.setNext(addend);
        addend.setPrevious(current); //it's important to make sure the list is doubly linked!!
    }
    
    /**
     * removes all nodes between start and stop. soundness of operation is not guaranteed here
     * @param start the starting point of a removal. will be left there
     * @param stop  the ending point of a removal. if not found will wipe everything after start!
     */
    public void remove(TwoWayNode start, TwoWayNode stop){ //this binds start to stop
        TwoWayNode running = FIRST;                     //this goes through the nodes to seek matching ones
        while (!running.equals(start)&&running.getNext()!=null){ //no null errors pls
            running=running.getNext();
        }
        TwoWayNode node = running; //here it has found a node matching the start of a removal
        while (!running.equals(stop)&&running.getNext()!=null) {
            running=running.getNext();
        } //no null errors
                                                                 // a relevant note: if the end isn't found, remove(start, last); occurs
        node.setNext(running);  // here it has found a node matching the end of removal
        running.setPrevious(node);
    }
    
    @Override
    public String toString(){
        TwoWayNode node=FIRST;
        String output="";
        do{
            output=output+node.toString();
            //System.out.println(output);
            if(node.getNext()==null) break;
            node=node.getNext();
        }while(true);
        return output;
    }
    
    /**
     * not the number of nodes contained!!
     * @return the summed distance between nodes
     */
    public int length(){
        int dist=0;
        TwoWayNode current=FIRST;
        while (current.getNext()!=null){
            dist+=(int) Utility.distance(current.getCoords(), current.getNext().getCoords());
            current=current.getNext();
        }
        return dist;
    }
    
    public TwoWayNode getFirst(){
        return FIRST;
    }
    
    /**
     * finds the first node that has no successor
     * @return the last node
     */
    public TwoWayNode getLast(){
        TwoWayNode current=FIRST;
        while (current.getNext()!=null){
            current=current.getNext();
        }
        return current;
    }
    
    public boolean equals(DoublyLinkedList anotherList){
        return (this.toString().equals(anotherList.toString()));
    }
}
