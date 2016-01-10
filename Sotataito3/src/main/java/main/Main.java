/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package main;
import gameInterface.Draw;
import gameInterface.Refresher;
import gameLogic.mapCreation.*;
import gameLogic.pathingLogic.Map;
import gameLogic.pathingLogic.Rectangle;
import gameLogic.unitLogic.Game;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Timer;
/**
 *
 * @author lari
 */
public class Main {
    static Game peli;
    static Draw canvas;
    /**
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException{
        preparation();
        runTheGame(peli,canvas);
    }
    
    static String print(Rectangle[] ayy){
        String output="";
        for (int i=0; i<ayy.length;i++){
            if (ayy[i]!=null){
                output=output+ayy[i].toString();
            }else{
                break;
            }
        }
        return output;
    }
    
    static void preparation(){
        String file="";
        try{
          FileReader inputFile = new FileReader("map.txt");

          //Instantiate the BufferedReader Class
          BufferedReader bufferReader = new BufferedReader(inputFile);

          //Variable to hold the one line data
          String line;

          // Read file line by line and print on the console
          while ((line = bufferReader.readLine()) != null)   {
            file+=line+"\n";
          }
          //Close the buffer reader
            bufferReader.close();
        }catch(Exception e){
        }
        Map map=MapCreator.create(file);
        peli=new Game(map);
        canvas=new Draw(peli);
        Frame window=new Frame();
        //window.addMouseListener(new CustomMouseListener()); ADDED TO DRAW INSTEAD
        
        window.setSize(canvas.getWidth(),canvas.getHeight());
        
        
        
        window.add(canvas);
        
        window.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }
         });    
        window.setVisible(true);
    }
    
    static void runTheGame(Game peli, Draw piirto) throws InterruptedException{
        Timer ajastin=new Timer(true);
        ajastin.scheduleAtFixedRate(peli, 0, 100);
        ajastin.scheduleAtFixedRate(new Refresher(piirto), 0, 100);
    }
   
}

