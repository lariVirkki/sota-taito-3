/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameInterface;

import java.util.TimerTask;

/**
 *
 * @author lari
 */
public class Refresher extends TimerTask{

    private Draw shah;
    
    public Refresher(Draw draw){
        shah=draw;
    }
    
    @Override
    public void run() {
        shah.repaint();
    }
    
}
