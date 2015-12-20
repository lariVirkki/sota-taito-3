/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic;

/**
 *
 * @author lari
 */
public class Ring {
    static private RingNode STARTNODE;
    
    public Ring(RingNode start){
        STARTNODE=start;
    }
    
    public RingNode get(){
        return STARTNODE;
    }
    
    public void add(RingNode addend){
        RingNode node=STARTNODE;
        while (node.right()!=null){
            node=node.right();
        }
        node.setRight(addend); //the new node is added as the rightmost
        addend.setLeft(node);  //...so it's left neighbor is the second newest
    }
    
    public void addAndClose(RingNode addend){
        add(addend);
        addend.setRight(STARTNODE);  //the ring is now closed
        STARTNODE.setLeft(addend);
    }
}
