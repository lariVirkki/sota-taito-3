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
    
    public DoublyLinkedList pathing(int[] startPoint, int[] endPoint){
        int[] addend;
        TwoWayNode start=new TwoWayNode(startPoint);        //set the starting point, end point, and start constructing the path
        TwoWayNode goal=new TwoWayNode(startPoint);
        DoublyLinkedList path=new DoublyLinkedList(start);  // the last command not to be iterated!
        addend=unPathableInTheWay(startPoint, startPoint);
        path.add(new TwoWayNode(addend));
        
        return path;
    }
    
    public int[] unPathableInTheWay(int[] startPoint, int[] endPoint){  //sees if there is unpathable terrain between two points in plane, returns 0,0 if none
        int[] output = new int[2];
        output[0]=0; output[1]=0;
        for (int i =0; i<unPathableList.length; i++){
            int[] point = unPathableList[i].lineCrosses(startPoint, endPoint);
            if (!Utility.isZeroPoint(point)){
                if(Utility.isZeroPoint(output)){
                    output=point;
                }else if (Utility.distance(startPoint, output)>Utility.distance(startPoint, point)){
                    output=point;
                }
            }
        }
        return output;
    }
    
    public TwoWayNode closestPointInRing(int[] point){
        
    }
    
    public boolean unpathablePoint(int[] point){
        for (int i=0; i<unPathableList.length;i++){
            if(unPathableList[i].isItIn(point)) return true;
        }
        return false;
    }
    
    //public double distance(int[] startPoint, int[] endPoint){
      //  return (Math.sqrt(Math.pow((double)(endPoint[0]-startPoint[0]), 2.0)+Math.pow((double)(endPoint[1]-startPoint[1]), 2.0)));
    //}
}
