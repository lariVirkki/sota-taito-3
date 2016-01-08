/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.unitLogic;

import gameLogic.pathingLogic.Map;
import gameLogic.pathingLogic.Rectangle;
import gameLogic.pathingLogic.Utility;
import java.awt.Toolkit;
import java.util.Arrays;
import java.util.TimerTask;

/**
 *
 * @author lari
 */
public class Game extends TimerTask{  //this is the class that waits so everything can happen with smooth framerate
    private Map map;
    private Unit[][] units;
    
    public Game(Map map){
        this.map=map;
        units=new Unit[2][500];
        units[0][0]=new Unit(500, 10, 200, 0, 5.0, map.getSpawnPoint(0),350,Toolkit.getDefaultToolkit().getImage("blue_base.png"),150,this);
        units[1][0]=new Unit(500, 0, 0, 0, 0.0, map.getSpawnPoint(1),350,Toolkit.getDefaultToolkit().getImage("red_base.png"),150,this);
    }
    
    @Override
    public void run(){
        System.out.println("running the errands");
        for (int i=0;i<2;i++){
            for (int j=0; j<units[i].length;j++){
                if (units[i][j]==null) break;
                System.out.println("making them do it");
                units[i][j].doIt();
            }
        }
        collisionCheck();
    }
    
    public void collisionCheck(){
        for (int i=0;i<units.length;i++) {
            for (int j=0;j<units[i].length;j++) {
                if (units[i][j]==null) break;
                collisionCheck(units[i][j], i, j);
                collisionCheck(units[i][j]);
            }
        }
    }
    
    public void collisionCheck(Unit unit1, int i, int j){
        for (int a=0;a<units.length;a++) {
            for (int b=0;b<units[a].length;b++) {
                if (units[a][b]==null) break;
                if (Utility.distance(unit1.getPosition(), units[a][b].getPosition())<Math.max(unit1.getSize(), units[a][b].getSize())&&!(a==i&&b==j)){
                    unit1.back();
                    units[a][b].back();
                    System.out.println("COLLIDED");
                    if(a!=i){
                        System.out.println("ATTACKING!! YAARRRR!!!!!");
                        if(unit1.takeAttack(units[a][b])<=0){
                            units[i][j]=null;
                        }
                        if(units[a][b].takeAttack(unit1)<=0){
                            units[a][b]=null;
                        }
                    }
                }
            }
        }
    }
    
    public void collisionCheck(Unit unit){
        Rectangle[] rec=map.getRectangles();
        int[] point=unit.getPosition();
        for (int i=0;i<rec.length;i++){
            if(rec[i].isItIn(point)){
                unit.back();
            }
        }
    }
    
    public void newUnit(Unit addend, Unit creator){
        System.out.println("got spawning command");
        int owner=0;
        for (int i=0;i<units.length;i++){
            for (int j=0;j<units[i].length;j++){
                if (units[i][j]==null) break;
                if(units[i][j].getPosition()==creator.getPosition()){
                    owner=i;
                    break;
                }
            }
        }
        for (int j=0;j<units[owner].length;j++){
            if(units[owner][j]==null){
                System.out.println("ADDING!!!");
                units[owner][j]=addend;
                break;
            }
        }
        System.out.println(this.toString());
    }
    
    public void sendMessage(int index){
        
    }
    
    //--------GETTERS-----------
    
    @Override
    public String toString(){
        String output="";
        for(int i=0;i<units[0].length;i++){
            if(units[0][i]==null)break;
            output+=Arrays.toString(units[0][i].getPosition());
        }
        return output;
    }
    
    public int[] getSpawnPoint(int i){
        return map.getSpawnPoint(i);
    }
    
    public Rectangle[] getRectangles(){
        return map.getRectangles();
    }
    
    public int[] getBorders(){
        return map.getBorders();
    }
    
    public Unit[][] getUnits(){
        return units;
    }

}
