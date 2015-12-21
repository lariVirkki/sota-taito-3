/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic;

/**
 *
 * @author lari
 */
public class DoublyLinkedList {
    private static TwoWayNode FIRST;
    
    public DoublyLinkedList(TwoWayNode node){
        FIRST=node;
    }
    
    public void add(TwoWayNode addend){ 
        TwoWayNode current=FIRST;
        while (current.getNext()!=null){
            current=current.getNext();
        }
        current.setNext(addend);
        addend.setPrevious(current); //it's important to make sure the list is doubly linked!!
    }
    
    public void remove(TwoWayNode start, TwoWayNode stop){ //this binds start to stop
        TwoWayNode running = FIRST;                     //this goes through the nodes to seek matching ones
        while (!running.equals(start)&&running.getNext()!=null){ //no null errors pls
            running=running.getNext();
        }
        TwoWayNode node = running; //here it has found a node matching the start of a removal
        do {
            running=running.getNext();
        }while (!running.equals(stop)&&running.getNext()!=null); //no null errors
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
            System.out.println(output);
            if(node.getNext()==null) break;
            node=node.getNext();
        }while(true);
        return output;
    }
}
