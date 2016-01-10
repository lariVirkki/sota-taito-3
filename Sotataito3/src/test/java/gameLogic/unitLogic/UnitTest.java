/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.unitLogic;

import gameLogic.mapCreation.MapCreator;
import org.junit.Test;

/**
 *
 * @author lari
 */
public class UnitTest {
    @Test
    public void commandTaken(){
        Unit testUnit = new Unit(1,0,0,0,10,new int[]{900,300},0,null,15,new Game(MapCreator.create("##############################\n" +
"#####......############....###\n" +
"###.........#########.......##\n" +
"#####..x......#####.......####\n" +
"###....................y.....#\n" +
"####......##.................#\n" +
"#......#######...............#\n" +
"##############################\n")));
        testUnit.command(new Job(3,new int[]{1000,300}));
        testUnit.doIt();
        org.junit.Assert.assertArrayEquals(new int[]{910,300}, testUnit.getPosition());
        org.junit.Assert.assertEquals(true, testUnit.changed());
    }
    
    @Test
    public void damageTest(){
        Unit testUnit = new Unit(100,0,12,0,10,new int[]{900,300},0,null,15,new Game(MapCreator.create("##############################\n" +
"#####......############....###\n" +
"###.........#########.......##\n" +
"#####..x......#####.......####\n" +
"###....................y.....#\n" +
"####......##.................#\n" +
"#......#######...............#\n" +
"##############################\n")));
        Unit testUnit2 = new Unit(100,2,3,0,10,new int[]{900,300},0,null,15,new Game(MapCreator.create("##############################\n" +
"#####......############....###\n" +
"###.........#########.......##\n" +
"#####..x......#####.......####\n" +
"###....................y.....#\n" +
"####......##.................#\n" +
"#......#######...............#\n" +
"##############################\n")));
        org.junit.Assert.assertEquals(97, testUnit.takeAttack(testUnit2));
        org.junit.Assert.assertEquals(96, testUnit2.takeAttack(testUnit));
    }
        
}
