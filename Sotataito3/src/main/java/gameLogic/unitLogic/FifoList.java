/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.unitLogic;

/**
 *
 * @author lari
 */
public class FifoList {
    private Job[] stack;
    
    public FifoList(){
        stack=new Job[16]; //length chosen at "random"
    }
    
    public Job pop(){
        Job top=stack[0];
        refactor();
        return top;
    }
    
    public void push(Job a){
        for (int i=0;i<stack.length;i++){
            if (stack[i]==null){
                stack[i]=a;
                break;
            }
        }
    }
    
    private void refactor(){
        for (int i=0; i<stack.length-1;i++){
            stack[i]=stack[i+1];
        }
        stack[15]=null;
    }
    
    public void flush(){
        for (int i=0;i<stack.length;i++){
            stack[i]=null;
        }
    }
}
