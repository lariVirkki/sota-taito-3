/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.pathingLogic;

/**
 *
 * @author lari
 */
public class Rectangle {
    private Line[] theLines;
    
    public Rectangle(int top, int bottom, int left, int right){
        if (top<=bottom){  //to make sure something CAN be inside it!
            int a =top;
            top=bottom;
            bottom=a;
        }
        if (right<=left){
            int a =right;
            right=left;
            left=a;
        }
        theLines=new Line[4]; //in the ordering: TOP, RIGHT, BOTTOM, LEFT
        theLines[0]=new Line(top,true,left,right); //Line(int level, boolean horizontal, int beginning, int endpoint)
        theLines[1]=new Line(right,false,bottom,top);
        theLines[2]=new Line(bottom,true,left,right);
        theLines[3]=new Line(left,false,bottom,top);
    }
    
    
    public int[] lineCrosses(int[] startPoint, int[] endPoint){
        int[] output = new int[2];
        output[0]=0; output[1]=0;
        for (int i =0; i<theLines.length; i++){
            int[] point = theLines[i].lineCrosses(startPoint, endPoint);
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
    
    public boolean isItIn(int[] point){
        for (int i=0; i<theLines.length;i++){  //test sout
            System.out.println(theLines[i].getMainStat());
        }
        return (point[0]>=theLines[3].getMainStat()&&point[0]<=theLines[1].getMainStat()&&point[1]>=theLines[2].getMainStat()&&point[1]<=theLines[0].getMainStat());
    }
}
