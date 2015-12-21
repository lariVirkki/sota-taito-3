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
    
    public DoublyLinkedList pathing(int xStart, int yStart, int xGoal, int yGoal){
        TwoWayNode start=new TwoWayNode(xStart, yStart);        //set the starting point, end point, and start constructing the path
        TwoWayNode goal=new TwoWayNode(xGoal,yGoal);
        DoublyLinkedList path=new DoublyLinkedList(start);
        
        return path;
    }
    
    public int[] unPathableInTheWay(int startX, int startY, int endX, int endY){  //sees if there is unpathable terrain between two points in plane, returns 0,0 if none
        int[] output = new int[2];
        output[0]=0; output[1]=0;
        for (int i =0; i<unPathableList.length; i++){
            int x=unPathableList[i].lineCrosses(startX, startY, endX, endY)[0];
            int y=unPathableList[i].lineCrosses(startX, startY, endX, endY)[1];
            if (!(x==0&&y==0)){
                if(output[0]==0&&output[1]==0){
                    output[0]=x; output[1]=y;
                }else if (this.distance(startX, startY, output[0], output[1])>this.distance(startX, startY, x, y)){
                    output[0]=x; output[1]=y;
                }
            }
        }
        return output;
    }
    
    public boolean unpathablePoint(int x, int y){
        for (int i=0; i<unPathableList.length;i++){
            if(unPathableList[i].isItIn(x, y)) return true;
        }
        return false;
    }
    
    public int distance(int startX, int startY, int endX, int endY){
        return (int) (Math.sqrt(Math.pow((double)(endX-startX), 2.0)+Math.pow((double)(endY-startY), 2.0)));
    }
}
