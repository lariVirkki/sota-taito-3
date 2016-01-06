/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.pathingLogic;

import java.util.Arrays;

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
        System.out.println("ENTERED UNPATHABLEINTHEWAY");
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
        System.out.println("Returning "+Arrays.toString(output));
        return output;
    }
    
    
    public DoublyLinkedList yksi(DoublyLinkedList pathSoFar, int[] endPoint){ //work name!!! this implements function (1) in notes!!!
        int[] collisionPoint=unPathableInTheWay(pathSoFar.getLast().getCoords(),endPoint);
        System.out.println("Entered the branching point! point is: "+Arrays.toString(collisionPoint));
        System.out.println("index is "+whichUnPathable(collisionPoint));
        if (Utility.isZeroPoint(collisionPoint)){
            pathSoFar.add(new TwoWayNode(endPoint));  //should end here with no obstacles
            return pathSoFar;
        }
        int index=whichUnPathable(collisionPoint);
        pathSoFar.add(closestPointInRing(collisionPoint, index));
        return shortestAlternative(pathSoFar,endPoint, index);
    }
    
    public DoublyLinkedList shortestAlternative(DoublyLinkedList pathSoFar, int[] endPoint, int index){
        System.out.println("ENTERED SHORTESTALTERNATIVE!");
        System.out.println("Path so far: "+pathSoFar.toString());
        DoublyLinkedList leftPath=findEdgeLeft(pathSoFar,endPoint, index);   //doesn't progress, gets stuck at the same point
        DoublyLinkedList rightPath=findEdgeRight(pathSoFar,endPoint, index); //it may become necessary to pass the index of the object to be cicrled... REFACTOR ASS TIME
        if (rightPath.length()<leftPath.length()){
            return rightPath;
        }else{
            return leftPath;
        }
    }
    
    public int whichUnPathable(int[] point){ //returns the index of the obstacle we are facing
        int i=0;
        for (i=0;i<unPathableList.length;i++){
            if (unPathableList[i]==null) break;
            if (unPathableList[i].isItIn(point)) return i;
        }
        return -1;
    }
    
    public DoublyLinkedList findEdgeLeft(DoublyLinkedList pathSoFar, int[] endPoint, int index){
        System.out.println("ENTERED FIND EDGE LEFT");
        TwoWayNode current=pathSoFar.getLast();     //the current LAST in PATH
        TwoWayNode nodeInRing=closestPointInRing(current.getCoords(),index);    //the corresponding node in RING
        while(whichUnPathable(unPathableInTheWay(current.getCoords(),endPoint))==index){ //still stuck circling the obstacle
            nodeInRing=nodeInRing.getPrevious(); //still the point in the ring
            current=nodeInRing.clone(); //going left = getting previous!!!! this only passes the coordinates! PRODUCES NULL POINTER EXCEPTION. are the rings closed?
            pathSoFar.add(current); //this will result in a double entry of the same point
            System.out.println("currently blocked by number "+whichUnPathable(unPathableInTheWay(current.getCoords(),endPoint))+" while index="+index);
        }
        pathSoFar=clean(pathSoFar);
        return yksi(pathSoFar,endPoint);
    }
    
    public DoublyLinkedList clean(DoublyLinkedList pathSoFar){
        System.out.println("ENTERED CLEAN");
        TwoWayNode forwardNode=pathSoFar.getLast();
        TwoWayNode potentialPrevious=pathSoFar.getLast().getPrevious().getPrevious(); 
        while (potentialPrevious!=null){
            while (potentialPrevious!=null){
                if (Utility.isZeroPoint(unPathableInTheWay(forwardNode.getCoords(),potentialPrevious.getCoords()))){
                    if(!forwardNode.getPrevious().equals(potentialPrevious))pathSoFar.remove(forwardNode, potentialPrevious);
                }
                potentialPrevious=potentialPrevious.getPrevious();
            }
            forwardNode=forwardNode.getPrevious();
            potentialPrevious=forwardNode.getPrevious().getPrevious();
        }
        System.out.println("returnin path as "+pathSoFar.toString());
        return pathSoFar;
    }
    
    public DoublyLinkedList findEdgeRight(DoublyLinkedList pathSoFar, int[] endPoint, int index){
        System.out.println("ENTERED FIND EDGE Right");
        TwoWayNode current=pathSoFar.getLast();     //the current LAST in PATH
        TwoWayNode nodeInRing=closestPointInRing(current.getCoords(),index);    //the corresponding node in RING
        while(whichUnPathable(unPathableInTheWay(current.getCoords(),endPoint))==index){ //still stuck circling the obstacle
            nodeInRing=nodeInRing.getNext(); //still the point in the ring
            current=nodeInRing.clone(); //going left = getting previous!!!! this only passes the coordinates! PRODUCES NULL POINTER EXCEPTION. are the rings closed?
            pathSoFar.add(current); //this will result in a double entry of the same point 
        }
        pathSoFar=clean(pathSoFar);
        return yksi(pathSoFar,endPoint);
    }

    
    public TwoWayNode closestPointInRing(int[] point, int index){
        if (index<0) return null;
        return ringList[index].getClosest(point);
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
    
    public RectangleCollection[] getUnPathable(){
        return this.unPathableList;
    }
}
