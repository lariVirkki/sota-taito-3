/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.unitLogic;

/**
 * The purpose of this class is to store a job and the place it is supposed to take place at
 * @author lari
 */
public class Job {
    private int[] target;
    private int jobNumber; //enum, maybe

    public Job(int code, int[] target){
        this.target=target;
        this.jobNumber=code;
    }
        
//----------GETTERS------------------
    public int[] getTarget(){
        return target;
    }
    
    public int number(){
        return jobNumber;
    }
}
