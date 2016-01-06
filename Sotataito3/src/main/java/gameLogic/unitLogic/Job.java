/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.unitLogic;

/**
 *
 * @author lari
 */
public class Job { //this class is intended to store what is to be done and where
    private int[] target;
    private int jobNumber; //enum, maybe
    
    public Job(int code, int[] target){
        this.target=target;
        this.jobNumber=code;
    }
    
    public int[] getTarget(){
        return target;
    }
    
    public int number(){
        return jobNumber;
    }
}
