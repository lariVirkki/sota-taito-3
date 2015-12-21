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
    private static int TOP;
    private static int BOTTOM;
    private static int LEFT;
    private static int RIGHT;
    
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
        TOP=top;
        BOTTOM=bottom;
        LEFT=left;
        RIGHT=right;
    }
    
    public boolean isItIn(int x, int y){
        return (x<TOP&&x>BOTTOM&&y<RIGHT&&y>LEFT); //what this means is that 0,0 is in the bottom left corner of a map
    }
    
    public int[] lineCrosses(int startX, int startY, int endX, int endY){
        double k;
        int [] output=new int[2];
        output[0]=0; output[1]=0;
        k = ((double) (endY-startY ))/((double)(endX-startX));
        double b = ((double) startY)-startX*k;
        if((k*LEFT+b<TOP&&k*LEFT+b>BOTTOM)){
            output[0]=LEFT;
            output[1]=(int) (k*LEFT+b);
        }
        if (k*RIGHT+b<TOP&&k*RIGHT+b>BOTTOM){
            output[0]=RIGHT;
            output[1]=(int) (k*RIGHT+b);
        }
        b=-b/k; //y=kx+b -> x=y/k-b/k
        k=1/k;
        if((k*BOTTOM+b<RIGHT&&k*BOTTOM+b>LEFT)){
            output[1]=BOTTOM;
            output[0]=(int) (k*BOTTOM+b);
        }
        if (k*TOP+b<RIGHT&&k*TOP+b>LEFT){
            output[1]=TOP;
            output[0]=(int) (k*TOP+b);
        }
        return output;
    }
}
