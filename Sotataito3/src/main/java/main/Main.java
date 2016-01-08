/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package main;
import gameInterface.Draw;
import gameInterface.Refresher;
import gameLogic.pathingLogic.Rectangle;
import gameLogic.pathingLogic.RectangleCollection;
import gameLogic.mapCreation.*;
import gameLogic.pathingLogic.DoublyLinkedList;
import gameLogic.pathingLogic.Map;
import gameLogic.pathingLogic.TwoWayNode;
import gameLogic.unitLogic.Game;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.Timer;
/**
 *
 * @author lari
 */
public class Main {
    static Game peli;
    static Draw test;
    /**
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException{
        preparation();
        loopperiino(peli,test);
        shah();
    }
    
    static void preparation(){
        String file="####################\n" +
"#......##..........#\n" +
"#......##..........#\n" +
"#..x....#.....y....#\n" +
"#......#...........#\n" +
"#..................#\n" +
"#..................#\n" +
"#..................#\n" +
"####################\n";
        Map map=MapCreator.create(file);
        peli=new Game(map);
        test=new Draw(peli);
        Frame window=new Frame();
        //window.addMouseListener(new CustomMouseListener()); ADDED TO DRAW INSTEAD
        
        window.setSize(test.getWidth(),test.getHeight());
        
        
        
        window.add(test);
        
        window.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }
         });    
        window.add(test);
        window.setVisible(true);
    }
    
    static void loopperiino(Game peli, Draw piirto) throws InterruptedException{
        Timer ajastin=new Timer(true);
        ajastin.scheduleAtFixedRate(peli, 0, 100);
        ajastin.scheduleAtFixedRate(new Refresher(piirto), 0, 100);
    }
    
    public static void wait (int n){
        long t0,t1;
        t0=System.currentTimeMillis();
        do{
        t1=System.currentTimeMillis();
        }
        while (t1-t0<n);
    }
    
    static void shah(){
        while (true){
            wait(20);
            test.repaint();
        }        
    }
   
}

