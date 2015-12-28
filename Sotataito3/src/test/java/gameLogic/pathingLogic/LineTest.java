/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.pathingLogic;
import gameLogic.pathingLogic.Line;
import org.junit.Test;
/**
 *
 * @author lari
 */
public class LineTest {
    
    @Test
    public void crossTest(){ 
        for (int i=0;i<100;i++){
            int level =(int)Math.floor(Math.random()*100);
            int start=(int)Math.floor(Math.random()*100);
            int end=(int)Math.floor(100+Math.random()*100);
            boolean h=(Math.random()<0.5);
            Line line=new Line(level,h,start,end);
            int[] pointA=new int[] {(int)Math.floor(Math.random()*200),0};
            int[] pointB=new int[] {(int)Math.floor(Math.random()*200),100};
            double k = ((double) (pointB[1]-pointA[1] ))/((double)(pointB[0]-pointA[0]));
            double b = ((double) pointA[1])-pointA[0]*k;
            if (h){
                b=-b/k; //y=kx+b -> x=y/k-b/k
                k=1/k;
                int [] tulos=new int[]{(int)Math.floor(k*level+b),level};
                if (k*level+b<end&&k*level+b>start){
                    org.junit.Assert.assertArrayEquals(tulos,line.lineCrosses(pointA, pointB));
                }else{
                    org.junit.Assert.assertArrayEquals(new int[]{0,0},line.lineCrosses(pointA, pointB));
                }
            }else{
                int [] tulos=new int[]{level,(int)Math.floor(k*level+b)};
                if (k*level+b<end&&k*level+b>start){
                    org.junit.Assert.assertArrayEquals(tulos,line.lineCrosses(pointA, pointB));
                }else{
                    org.junit.Assert.assertArrayEquals(new int[]{0,0},line.lineCrosses(pointA, pointB));
                }
            }
        }
    }
}
