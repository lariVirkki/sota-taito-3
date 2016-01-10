/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.unitLogic;

import gameLogic.mapCreation.MapCreator;
import gameLogic.pathingLogic.Map;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author lari
 */
public class GameTest {
    String file;
    Map map;
    Game game;
    
    @Before
    public void setUp(){
        file="##############################\n" +
"#####......############....###\n" +
"###.........#########.......##\n" +
"#####..x......#####.......####\n" +
"###....................y.....#\n" +
"####......##.................#\n" +
"#......#######...............#\n" +
"##############################\n";
        map=MapCreator.create(file);
        game=new Game(map);
    }
    
    @Test
    public void collisionTest(){
        Unit testUnit=new Unit(1,0,0,0,0,new int[]{400,200},0,null,15,game);
        game.newUnit(testUnit, testUnit);
        game.newUnit(testUnit, testUnit);
        testUnit.command(new Job(3,new int[]{0,0}));
        game.run();
        org.junit.Assert.assertEquals(false, testUnit.changed());
    }
    
    @Test
    public void additionTest(){
        game.newUnit(new Unit(1,0,0,0,0,new int[]{400,200},0,null,15,game), game.getUnits()[0][0]);
        org.junit.Assert.assertNotEquals(null, game.getUnits()[0][1]);
    }
    
    @Test
    public void moveTest(){
        Unit testUnit=new Unit(1,0,0,0,0,new int[]{900,300},0,null,15,game);
        game.newUnit(testUnit, game.getUnits()[0][0]);
        testUnit.command(new Job(3,new int[]{0,0}));
        game.run();
        org.junit.Assert.assertEquals(true, testUnit.changed());
    }
    
    @Test
    public void killTest(){
        Unit testUnit=new Unit(10000,0,100000,0,10.0,new int[]{350,100},0,null,15,game);
        game.newUnit(testUnit, game.getUnits()[1][0]);
        testUnit.command(new Job(3,new int[]{0,0}));
        game.run();
        org.junit.Assert.assertEquals(null, game.getUnits()[0][0]);
    }
    
}
