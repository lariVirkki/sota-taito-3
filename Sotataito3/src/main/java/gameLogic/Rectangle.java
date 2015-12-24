/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic;

/**
 *
 * @author lari
 */
public class Rectangle {
    private Line[] theLines;
    
    public Rectangle(int top, int bottom, int left, int right){
        if (top<bottom){  //to make sure something CAN be inside it!
            int a =top;
            top=bottom;
            bottom=a;
        }
        if (right<left){
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
    
    /*
    public boolean isItIn(int x, int y){
        return (x<TOP&&x>BOTTOM&&y<RIGHT&&y>LEFT); //what this means is that 0,0 is in the bottom left corner of a map
    }
    */
    
    public int[] lineCrosses(int startX, int startY, int endX, int endY){
        int[] output = new int[2];
        output[0]=0; output[1]=0;
        for (int i =0; i<theLines.length; i++){
            int x=theLines[i].lineCrosses(startX, startY, endX, endY)[0];
            int y=theLines[i].lineCrosses(startX, startY, endX, endY)[1];
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
    
    private int distance(int startX, int startY, int endX, int endY){
        return (int) (Math.sqrt(Math.pow((double)(endX-startX), 2.0)+Math.pow((double)(endY-startY), 2.0)));
    }
}
