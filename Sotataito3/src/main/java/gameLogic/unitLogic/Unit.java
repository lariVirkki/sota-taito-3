/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.unitLogic;

import gameLogic.pathingLogic.Utility;

/**
 *
 * @author lari
 */
public class Unit {
    private int hp;
    private int[] position;
    private int armor;
    private int attack;
    private int attackspeed;
    private FifoList commandQueue;
    private int[] statuslist; //might never be implemented
    private double movespeed;
    private Job job;
    private int visionRange;
    private int owner;
    
    public Unit(int hp, int armor, int attack, int attackspeed, double movespeed, int[] position, int vision, int owner){
        this.hp=hp;
        this.armor=armor;
        this.attack=attack;
        this.attackspeed=attackspeed;
        this.movespeed=movespeed;
        this.position=position;
        this.commandQueue=new FifoList();
        this.statuslist=new int[32];
        this.job=null;
        this.visionRange=vision;
        this.owner=owner;
    }
    
    /**
     * every iteration, all units need to do what they were told to
     * this method implements that and branches to whatever the current job commands
     */
    public void doIt(){
        if (job.number()==1) hold();
        if (job.number()==2||job.number()==3) move();
    }
    
    /**
     * this interrupts whatever the unit was doing
     * and replaces it's job with the command
     * @param job 
     */
    public void command(Job job){
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
        double x; double y;
        x=(((double)(job.getTarget()[0]-this.position[0]))/Utility.distance(this.position, job.getTarget()));
        y=(((double)(job.getTarget()[1]-this.position[1]))/Utility.distance(this.position, job.getTarget()));
        int[] shah = new int[]{(int)Math.floor(x*movespeed),(int)Math.floor(y*movespeed)};
        this.position=Utility.pointAddition(position, shah);
        if (Utility.distance(job.getTarget(), position)<10&&job.number()==3) attack();
    }
    
    /**
     * to be implemented. an unit should be able to attack. otherwise there would be no war
     */
    private void attack(){
        
    }
    
    /**
     * the unit needs to report its location for many purposes
     * @return position
     */
    public int[] getPosition(){
        return position;
    }
}
