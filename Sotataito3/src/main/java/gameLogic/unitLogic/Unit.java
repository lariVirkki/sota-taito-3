/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.unitLogic;

import gameLogic.pathingLogic.Utility;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Arrays;

/**
 *
 * @author lari
 */
public class Unit {
    private boolean changed;
    private int hp;
    private int[] position;
    private int[] previousPosition;
    private int armor;
    private int attack;
    private int attackspeed;
    private FifoList commandQueue;
    private int[] statuslist; //might never be implemented
    private double movespeed; //this better be 3 or over!! 1 has the unit path really funny...
    private Job job;
    private int visionRange;
    private int owner;
    private Image sprite;
    private int size;
    private Game parent;
    
    public Unit(int hp, int armor, int attack, int attackspeed, double movespeed, int[] position, int vision, Image image, int size, Game game){
        this.hp=hp;
        this.armor=armor;
        this.attack=attack;
        this.attackspeed=attackspeed;
        this.movespeed=movespeed;
        this.position=position;
        this.previousPosition=position;
        this.commandQueue=new FifoList();
        this.statuslist=new int[32];
        this.job=null;
        this.visionRange=vision;
        this.sprite=image;
        this.size=size;
        command(new Job(1, new int[]{0,0}));
        parent=game;
        changed=true; //has to start as true for it to be drawn
    }
    
    /**
     * every iteration, all units need to do what they were told to
     * this method implements that and branches to whatever the current job commands
     */
    public void doIt(){
        changed=false;
        System.out.println("doing it!");
        if (job.number()==1) hold();
        if (job.number()==2||job.number()==3) move(); //2=move, 3=move & attack
        if (job.number()==4) spawn();
    }
    
    /**
     * spawns a new unit, the blue guy
     */
    public void spawn(){
        System.out.println("TRYING TO SPAWN");
        if(this.size==150){
            parent.newUnit(new Unit(50, 10, 5, 0, 10.0, Utility.pointAddition(new int[]{0,this.size/2+this.size/4},this.position),350,Toolkit.getDefaultToolkit().getImage("blue_dude.png"),50,this.parent), this);
        }
        job=this.commandQueue.pop();
        if (job==null){
            this.command(new Job(1,new int[]{0,0}));
        }
    }
    
    /**
     * moves the unit to its previous position
     */
    public void back(){
        position=previousPosition;
        changed=false;
    }
    
    /**
     * this interrupts whatever the unit was doing
     * and replaces it's job with the command
     * @param job 
     */
    public void command(Job job){
        System.out.println("command accepted");
        commandQueue.flush();
        commandQueue.push(job);
        this.job=commandQueue.pop();
    }
    
    /**
     * this method sets a job to the back of the unit's job queue
     * @param job 
     */
    public void queuedCommand(Job job){
        commandQueue.push(job);
    }
    
    /**
     * implements holding position
     * for now, every unit sleeps at guard duty
     */
    private void hold(){
        //do nothing. we don't engage enemies when deadline draws close
    }
    
    /**
     * unit moves itself
     * collision problems will likely be solved in Game
     */
    private void move(){
        System.out.println("MOVING!");
        double x; double y;
        //DoublyLinkedList path = map. maybe a path should be given??
        x=(((double)(job.getTarget()[0]-this.position[0]))/Utility.distance(this.position, job.getTarget()));
        y=(((double)(job.getTarget()[1]-this.position[1]))/Utility.distance(this.position, job.getTarget()));
        int[] shah = new int[]{(int)Math.floor(x*movespeed),(int)Math.floor(y*movespeed)};
        previousPosition=position;
        this.position=Utility.pointAddition(position, shah);
        System.out.println(Arrays.toString(this.getPosition()));
        if (Utility.distance(job.getTarget(), position)<50){
            this.command(new Job(1,new int[]{0,0}));
            System.out.println("ARRIVED!");
        }
        changed=true;
    }
    
    /**
     * to be implemented. an unit should be able to attack. otherwise there would be no war
     */
    private void attack(){
        
    }
    
    /**
     * resolves getting attacked by Unit other
     * @param other the attacking unit
     * @return how much hp is left after taking the attack
     */
    public int takeAttack(Unit other){
        this.hp-=other.getAttack()/(this.armor+1);
        changed=true;
        return hp;
    }
    
    //---------------GETTERS------------------//
    /**
     * the unit needs to report its location for many purposes
     * @return position
     */
    public int[] getPosition(){
        return position;
    }
    
    public Image getSprite(){
        return sprite;
    }
    
    public int getSize(){
        return size;
    }
    
    public int getAttack(){
        return this.attack;
    }
    
    public int getHP(){
        return this.hp;
    }
    
    public boolean changed(){
        return changed;
    }
}
