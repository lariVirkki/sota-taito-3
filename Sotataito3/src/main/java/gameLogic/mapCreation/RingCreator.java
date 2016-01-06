/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.mapCreation;
import gameLogic.pathingLogic.*;
import java.util.Arrays;
/**
 *
 * @author lari
 * not currently in use
 */
public final class RingCreator {
    //scale: one character is 50 pixels
    //createRingList returns a ring with only the point (-50,-50) in it?!?!?!
    public static Ring[] createRingList(RectangleCollection[] recList){
        Ring[] ringList=new Ring[recList.length];
        for (int i=0; i<recList.length;i++){
            if (recList[i]==null) break;
            int[][] corners=getOuterPoints(recList[i]);
            ringList[i]=createRing(corners);
        }
        return ringList;
    }
    
    public static int[][] getOuterPoints(RectangleCollection recColle){  //always outputs [0]={-50,-50}
        int[][][] inputPoints=recColle.getPoints(); //{rectangle1{corner1{n1,n2}},rectangle2..} too complex for me??
        int[][] output=new int[inputPoints.length][2]; //each and every one of them corners might be on the outside
        int outputIndex=0; //all the points listed will be back to back
        int[] change=new int[2];
        for (int i=0; i<inputPoints.length;i++){  //iterates over the set of rectangles
            for(int j=0; j<=3;j++){  //this for iterates over one set of corner points
                if(!Utility.isZeroPoint(inputPoints[i][j])){
                    //System.out.println("OUTER POINT! "+Arrays.toString(inputPoints[i][j])); //now outer points are found correctly!
                    switch(j){
                        case 0: change=new int[]{-25,25};
                                break;
                        case 1: change=new int[]{25,25};
                                break;
                        case 2: change=new int[]{25,-25};
                                break;
                        case 3: change=new int[]{-25,-25};
                                break;
                    }
                    if(!recColle.isItIn(pointAddition(inputPoints[i][j],change))){
                        output[outputIndex]=pointAddition(inputPoints[i][j],change);
                        outputIndex++;
                    }
                    
                }
            }
        }
        System.out.println("getOuterPoints OUTPUT[0]: "+Arrays.toString(output[0])); //output flawed even though 
        return output;
    }
    
    private static int[] pointAddition(int[] addend1, int[] addend2){ //...for points
        return new int[]{addend1[0]+addend2[0],addend1[1]+addend2[1]};
    }
    
    private static Ring createRing(int[][] points){ //the points aren't in order
        System.out.println("createRing reporting!! points[0] is "+Arrays.toString(points[0]));
        Ring output=new Ring(new TwoWayNode(points[0]));
        for (int i=1;i<points.length;i++){
            System.out.println("createRing reporting!! points["+i+"] is "+Arrays.toString(points[i]));
            if(Utility.isZeroPoint(points[i])) break;
            //and for some retarded reason, every point after 0 is just [0,0]
            if(Utility.isZeroPoint(points[i+1])){
                output.addAndClose(new TwoWayNode(points[i]));
            }else{
                output.add(new TwoWayNode(points[i])); //jesse we should close the ring here!!
            }
        }
        return output;
    }
}
