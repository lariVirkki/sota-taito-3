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
    
    /**
     * checks whether a line between two points crosses this rectangle by checking each of its constituent lines
     * @param startPoint
     * @param endPoint
     * @return 
     */
    public int[] lineCrosses(int[] startPoint, int[] endPoint){ //bug most likely here
        int[] output = new int[]{0,0};
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
    
    /**
     * 
     * @param point
     * @return whether or not point is inside this rectangle
     */
    public boolean isItIn(int[] point){
        return (point[0]>=theLines[3].getMainStat()&&point[0]<=theLines[1].getMainStat()&&point[1]>=theLines[2].getMainStat()&&point[1]<=theLines[0].getMainStat());
    }
    
    /**
     * checks whether or not point is inside this rectangle, excluding points exactly on the borders
     * @param point
     * @return 
     */
    public boolean isItInEx(int[] point){
        return (point[0]>theLines[3].getMainStat()&&point[0]<theLines[1].getMainStat()&&point[1]>theLines[2].getMainStat()&&point[1]<theLines[0].getMainStat());
    }
    
    /**
     * 
     * @param rec
     * @return true iff rec fits inside this Rectangle
     */
    public boolean contains(Rectangle rec){
        int[] biggie=this.getCoords();
        int[] smalls=rec.getCoords();
        return (biggie[0]>=smalls[0]&&biggie[1]>=smalls[1]&&biggie[2]<=smalls[2]&&biggie[3]<=smalls[3]);
    }
    
    /**
     * 
     * @param rec
     * @return true if this and rec overlap
     */
    public boolean overlaps(Rectangle rec){
        int[] a=this.getCoords();
        int[] b=rec.getCoords();
        return (this.isItIn(new int[] {b[1],b[0]})||this.isItIn(new int[] {b[3],b[0]})||this.isItIn(new int[] {b[1],b[2]})||this.isItIn(new int[] {b[3],b[2]}))&&(rec.isItIn(new int[] {a[1],a[0]})||rec.isItIn(new int[] {a[3],a[0]})||rec.isItIn(new int[] {a[1],a[2]})||rec.isItIn(new int[] {a[3],a[2]}));
    }
    
    public int[] getCoords(){
        int[] output=new int[4]; //output will be {top,right,bottom,left}
        output[0]=theLines[0].getMainStat();
        output[1]=theLines[1].getMainStat();
        output[2]=theLines[2].getMainStat();
        output[3]=theLines[3].getMainStat();
        return output;
    }
    
    @Override
    public String toString(){
        return Arrays.toString(this.getCoords());
    }
    
    /**
     * 
     * @return output will be {top left, top right, bottom right, bottom left}
     */
    public int[][] getPoints(){ //output will be {top left, top right, bottom right, bottom left
        int[] a=this.getCoords();
        return new int[][] {{a[3],a[0]},{a[1],a[0]},{a[1],a[2]},{a[3],a[2]}};
    }
}
