/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic;

/**
 *
 * @author lari
 */
public class Line {
    
    /* the lines are either horizontal or vertical, and the main stat is their constant x or y value
    start and end are its start and ending points on the axis defined by main stat
    
    this class is used to construct rectangles
    */
    
    private final boolean orientation;
    private final int mainStat;
    private final int start, end;
    
    public Line(int level, boolean horizontal, int beginning, int endpoint){
        orientation=horizontal;  //horizontal = 1 | vertical = 0
        mainStat=level;
        start=beginning;
        end=endpoint;
    }
    
    public int[] lineCrosses(int[] startPoint, int[] endPoint){
        int[] output = new int[2];
        output[0]=0; output[1]=0;
        double k = ((double) (endPoint[1]-startPoint[1] ))/((double)(endPoint[0]-startPoint[0]));
        double b = ((double) startPoint[1])-startPoint[0]*k;
        int x=0;
        int y=1;
        if (orientation){
            b=-b/k; //y=kx+b -> x=y/k-b/k
            k=1/k;
            x=1;
            y=0;
        }
        if((k*mainStat+b<end&&k*mainStat+b>start)){
            output[x]=mainStat;
            output[y]=(int) (k*mainStat+b);
        }
        return output;
    }
    
    //GETTERS
    public boolean getOrientation(){
        return orientation;
    }
    
    public int[] getStartPoint(){
        int[] output= new int[2];
        if (orientation){
            output[1]=mainStat;
            output[0]=start;
        }else{
            output[0]=mainStat;
            output[1]=start;
        }
        return output;
    }
    
    public int[] getEndPoint(){
        int[] output= new int[2];
        if (orientation){
            output[1]=mainStat;
            output[0]=end;
        }else{
            output[0]=mainStat;
            output[1]=end;
        }
        return output;
    }
    
    public int getMainStat(){
        return this.mainStat;
    }
    
}
