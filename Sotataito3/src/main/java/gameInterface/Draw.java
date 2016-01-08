/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameInterface;

import gameLogic.pathingLogic.Rectangle;
import gameLogic.pathingLogic.Utility;
import gameLogic.unitLogic.Game;
import gameLogic.unitLogic.Job;
import gameLogic.unitLogic.Unit;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

/**
 *
 * @author lari
 */
public class Draw extends Canvas{ // a better name is needed :DDD
    private Game game; //this will be the game situation object that the drawing is based upon
    private Rectangle[] obstacles;
    private int[] centerpoint;
    private int[] selectedUnit;
    
    public Draw(Game game){
        this.game=game;
        centerpoint=game.getSpawnPoint(0);
        obstacles=game.getRectangles();
        this.setSize(game.getBorders()[0],game.getBorders()[1]);
        this.addMouseListener(new CustomMouseListener());
        this.addKeyListener(new CustomKeyListener());
    }
    
    public void paintObstacles(Graphics g){
        for (int i=0; i<obstacles.length;i++){ //rectangles are perfect. the bug is here somewhere :DDD
            g.fillRect(obstacles[i].getCoords()[3], obstacles[i].getCoords()[2], obstacles[i].getCoords()[1]-obstacles[i].getCoords()[3], obstacles[i].getCoords()[0]-obstacles[i].getCoords()[2]);
        }
    }
    
    public void paintUnits(Graphics g){
        Unit[][] list=game.getUnits();
        for (int i=0;i<2;i++){
            for (int j=0; j<list[i].length;j++){
                //System.out.println("i="+i+" j="+j);
                if(list[i][j]==null) break;
                System.out.println("DRAWING "+Arrays.toString(list[i][j].getPosition()));
                g.drawString("HP: "+list[i][j].getHP(), list[i][j].getPosition()[0]-50, list[i][j].getPosition()[1]-50);
                g.drawImage(list[i][j].getSprite(), list[i][j].getPosition()[0]-list[i][j].getSize()/2+25, list[i][j].getPosition()[1]-list[i][j].getSize()/2+25, this); 
            }
        }
    }
    
    @Override
    public void paint(Graphics g){
        paintObstacles(g);
        paintUnits(g);
    }
    
    public void selectUnit(int [] point){   //saves the index of a unit in getUnits
        selectedUnit=null;
        for (int i=0;i<game.getUnits().length;i++){
            for (int j=0;j<game.getUnits()[i].length;j++){
                if (game.getUnits()[i][j]==null) break;
                if (Utility.distance(point, game.getUnits()[i][j].getPosition())<game.getUnits()[i][j].getSize()){
                    selectedUnit=new int[]{i,j};
                    System.out.println("selected");
                    break;
                }
            }
        }
    }
    
    public void moveCommand(int[] target){
        if (selectedUnit!=null){
            game.getUnits()[selectedUnit[0]][selectedUnit[1]].command(new Job(2,target));
            System.out.println("commanded");
        }
    }
    
    public void trainCommand(){
        if (selectedUnit!=null){
            game.getUnits()[selectedUnit[0]][selectedUnit[1]].command(new Job(4,new int[]{0,0}));
            System.out.println("commanded");
        }
    }
    
    
//------------------------------LISTENER CLASS-------------------------------------
    private class CustomMouseListener implements MouseListener{
    public CustomMouseListener(){
    }
    @Override
    public void mouseClicked(MouseEvent me) {
       switch (me.getButton()){
           case MouseEvent.BUTTON1:
           {selectUnit(new int[]{me.getPoint().x,me.getPoint().y});
               break;}
           case MouseEvent.BUTTON3:
           {moveCommand(new int[]{me.getPoint().x,me.getPoint().y});
               break;}
       }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
    }
//---------------------END  OF LISTENER CLASS-------------------------------
//---------------------ANOTHER LISTENER CLASS-------------------------------
    private class CustomKeyListener implements KeyListener{
    public CustomKeyListener(){  //not the vn company
    }

        @Override
        public void keyTyped(KeyEvent ke) {
            switch (ke.getKeyChar()){
                case 'T':
                    trainCommand();
            }
        }

        @Override
        public void keyPressed(KeyEvent ke) {
        }

        @Override
        public void keyReleased(KeyEvent ke) {
        }
    
    }
}
