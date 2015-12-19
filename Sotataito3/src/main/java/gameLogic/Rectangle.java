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
        TOP=top;
        BOTTOM=bottom;
        LEFT=left;
        RIGHT=right;
    }
    
    public boolean isItIn(int x, int y){
        return (x<TOP&&x>BOTTOM&&y<RIGHT&&y>LEFT); //what this means is that 0,0 is in the bottom left corner of a map
    }
}
