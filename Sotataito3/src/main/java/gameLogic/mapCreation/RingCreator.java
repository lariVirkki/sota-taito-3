/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.mapCreation;
import gameLogic.pathingLogic.*;
/**
 *
 * @author lari
 */
public final class RingCreator {
    //scale: one character is 50 pixels
    public Ring[] createRingList(RectangleCollection[] recList){
        Ring[] ringList=new Ring[recList.length];
        for (int i=0; i<recList.length;i++){
            int[][] corners=getOuterPoints(recList[i]);
            ringList[i]=createRing(corners);
        }
        return ringList;
    }
    
    private int[][] getOuterPoints(RectangleCollection recColle){
        int[][][] inputPoints=recColle.getPoints();
        int[][] output=new int[inputPoints.length][2];
        int outputIndex=0;
        for (int i=0; i<inputPoints.length;i++){
            for(int j=0; j<=3;j++){  //this for iterates over one set of corner points
                if(!recColle.isItIn(inputPoints[i][j])){
                    switch(j){
                        case 0: output[outputIndex]=pointAddition(inputPoints[i][j],new int[]{50,-50});
                                break;
                        case 1: output[outputIndex]=pointAddition(inputPoints[i][j],new int[]{50,50});
                                break;
                        case 2: output[outputIndex]=pointAddition(inputPoints[i][j],new int[]{-50,50});
                                break;
                        case 3: output[outputIndex]=pointAddition(inputPoints[i][j],new int[]{-50,-50});
                                break;
                    }
                }
            }
        }
        return output;
    }
    
    private int[] pointAddition(int[] addend1, int[] addend2){ //...for points
        return new int[]{addend1[0]+addend2[0],addend1[1]+addend2[1]};
    }
    
    private Ring createRing(int[][] points){
        Ring output=new Ring(new TwoWayNode(points[0]));
        for (int i=1;i<points.length;i++){
            output.add(new TwoWayNode(points[i]));
        }
        return output;
    }
}
