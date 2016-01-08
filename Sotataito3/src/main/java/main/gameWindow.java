/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package main;

import java.awt.*;

/**
 *
 * @author lari
 */
public class gameWindow extends Canvas {
    
    public gameWindow(){
        setSize(200, 200);
        setBackground(Color.lightGray);
    }
    
    @Override
    public void paint(Graphics g){
        g.setColor(Color.blue);
        g.drawLine(30, 30, 80, 80);
        g.drawRect(20, 150, 100, 100);
        g.fillRect(20, 150, 100, 100);
        g.fillOval(150, 20, 100, 100);  
    }
}
