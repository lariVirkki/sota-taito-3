/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package main;
import gameLogic.pathingLogic.Rectangle;
/**
 *
 * @author lari
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        while(true){
            isInWorksPositive();
        }
    }
        
        static void isInWorksPositive(){
        int bottom=0;
        int top=100;
        int left=0;
        int right=100;
        Rectangle rec = new Rectangle(top, bottom, left, right);
        int x=(int) (Math.random()*100.0);
        int y=(int) (Math.random()*100.0);
        System.out.println(x+" "+y+" "+rec.isItIn(new int[]{x,y}));
    }
}

