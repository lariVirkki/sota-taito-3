/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.pathingLogic;

/**
 *
 * @author lari
 */
public class Ring {
    static private TwoWayNode STARTNODE;
    
    public Ring(TwoWayNode start){
        STARTNODE=start;
    }
    
    public TwoWayNode get(){
        return STARTNODE;
    }

    public void add(TwoWayNode addend){
        TwoWayNode node=STARTNODE;
        while (node.getNext()!=null){
            node=node.getNext();
        }
        node.setNext(addend); //the new node is added as the rightmost
        addend.setPrevious(node);  //...so it's left neighbor is the second newest
    }
    
    public void addAndClose(TwoWayNode addend){
        add(addend);
        addend.setNext(STARTNODE);  //the ring is now closed
        STARTNODE.setPrevious(addend);
    }
    
    public TwoWayNode getClosest(int[] point){  //null pointer exception here????? Rings not closed upon creation????
        TwoWayNode node=STARTNODE;
        TwoWayNode output=node;
        while (node!=null){
            if(Utility.distance(output.getCoords(), point)>Utility.distance(node.getCoords(), point)){
                output=node;
            }
            if (node.equals(STARTNODE)){break;}
            node=node.getNext(); //incrementation
        }
        return output;
    }
    
    @Override
    public String toString(){
        TwoWayNode node=STARTNODE;
        String output=node.toString();
        while(node!=STARTNODE){
            output+=node.toString();
        }
        return output;
    }
}
