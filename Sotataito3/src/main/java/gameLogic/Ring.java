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
    static private Node STARTNODE;
    
    public Ring(Node start){
        STARTNODE=start;
    }
    
    public Node get(){
        return STARTNODE;
    }
    
    public void add(Node addend){
        Node node=STARTNODE;
        while (node.right()!=null){
            node=node.right();
        }
        node.setRight(addend); //the new node is added as the rightmost
        addend.setLeft(node);  //...so it's left neighbor is the second newest
    }
    
    public void addAndClose(Node addend){
        add(addend);
        addend.setRight(STARTNODE);  //the ring is now closed
        STARTNODE.setLeft(addend);
    }
}
