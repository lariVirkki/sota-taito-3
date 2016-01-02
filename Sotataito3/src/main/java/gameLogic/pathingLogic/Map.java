/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.pathingLogic;

/**
 *
 * @author lari
 */
public class Map {
    private Ring[] ringList;
    private RectangleCollection[] unPathableList;
    private int[] borders;
// these index have to match so that ringlist[n] is the ring that surrounds
// the patch of unpathable terrain reccolle[n]
    
    
    public Map(Ring[] ring, RectangleCollection[] rec, int[] bd){
        ringList=ring;
        unPathableList=rec;
        borders=bd;
    }
    
    public int[] unPathableInTheWay(int[] startPoint, int[] endPoint){  //sees if there is unpathable terrain between two points in plane, returns 0,0 if none
        int[] output = new int[2];
        output[0]=0; output[1]=0;
        for (int i =0; i<unPathableList.length; i++){
            if (unPathableList[i]==null) break;
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
    //there's an infinite loop somewhere, and it is probably produced by a map surrounded by unpathable...
    public DoublyLinkedList yksi(DoublyLinkedList pathSoFar, int[] endPoint){ //work name!!! this implements function (1) in notes!!!
        int[] collisionPoint=unPathableInTheWay(pathSoFar.getLast().getCoords(),endPoint);
        if (collisionPoint==new int[]{0,0}){
            pathSoFar.add(new TwoWayNode(endPoint));
            return pathSoFar;
        }
        pathSoFar.add(closestPointInRing(collisionPoint));
        return shortestAlternative(pathSoFar,endPoint);
    }
    
    public DoublyLinkedList shortestAlternative(DoublyLinkedList pathSoFar, int[] endPoint){
        DoublyLinkedList leftPath=findEdgeLeft(pathSoFar,endPoint);
        DoublyLinkedList rightPath=findEdgeRight(pathSoFar,endPoint);
        if (rightPath.length()<leftPath.length()){
            return rightPath;
        }else{
            return leftPath;
        }
    }
    
    public DoublyLinkedList findEdgeLeft(DoublyLinkedList pathSoFar, int[] endPoint){
        TwoWayNode current=pathSoFar.getLast();
        while(Utility.distance(unPathableInTheWay(current.getCoords(),endPoint), current.getCoords())<20&&unPathableInTheWay(current.getCoords(),endPoint)!=new int[]{0,0}){
            pathSoFar.add(current);
            current=current.getPrevious(); //going left = getting previous!!!!
        }
        pathSoFar=clean(pathSoFar);
        return yksi(pathSoFar,endPoint);
    }
    
    public DoublyLinkedList clean(DoublyLinkedList pathSoFar){
        TwoWayNode forwardNode=pathSoFar.getLast();
        TwoWayNode potentialPrevious=pathSoFar.getLast().getPrevious().getPrevious(); 
        while (potentialPrevious!=null){
            while (potentialPrevious!=null){
                if (unPathableInTheWay(forwardNode.getCoords(),potentialPrevious.getCoords())==new int[]{0,0}){
                    pathSoFar.remove(forwardNode, potentialPrevious);
                }
                potentialPrevious=potentialPrevious.getPrevious();
            }
            forwardNode=forwardNode.getPrevious();
            potentialPrevious=forwardNode.getPrevious().getPrevious();
        }
        return pathSoFar;
    }
    
    public DoublyLinkedList findEdgeRight(DoublyLinkedList pathSoFar, int[] endPoint){
        TwoWayNode current=pathSoFar.getLast();
        while(Utility.distance(unPathableInTheWay(current.getCoords(),endPoint), current.getCoords())<20&&unPathableInTheWay(current.getCoords(),endPoint)!=new int[]{0,0}){
            pathSoFar.add(current);
            current=current.getNext(); //going left = getting previous!!!!
        }
        pathSoFar=clean(pathSoFar);
        return yksi(pathSoFar,endPoint);
    }

    
    public TwoWayNode closestPointInRing(int[] startPoint){
        int[] output=new int[2];
        int[] point;
        for (int i=0; i<ringList.length;i++){
            if (ringList[i]==null) break;
            point=ringList[i].getClosest(startPoint);
            if(Utility.isZeroPoint(output)){
                    output=point;
            }else if (Utility.distance(startPoint, output)>Utility.distance(startPoint, point)){
                    output=point;
            }
        }
        return new TwoWayNode(output);
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
