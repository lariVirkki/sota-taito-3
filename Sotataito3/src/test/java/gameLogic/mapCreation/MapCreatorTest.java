/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.mapCreation;

import org.junit.Test;

/**
 *
 * @author lari
 */
public class MapCreatorTest {
    @Test
    public void obviousFalses1(){
        String file="#############";
        org.junit.Assert.assertEquals(null, MapCreator.create(file));
    }
    
    @Test
    public void noSpawns(){
        String file=".....##\n.....##\n.....##\n...##..\n...##..\n.......\n";
        org.junit.Assert.assertEquals(null, MapCreator.create(file));
    }
    
    @Test
    public void noSpaceForSpawnsVertical(){
        String file="############\n" +"#..........#\n" +"#....x.....#\n" +"###........#\n" +"##.....#####\n" +"####.....###\n" +"#....y.....#\n" +"............";
        org.junit.Assert.assertEquals(null, MapCreator.create(file));
    }
    
    @Test
    public void accpetsSome(){
        String file="############\n" +
"#..........#\n" +
"#..........#\n" +
"#....x.....#\n" +
"#..........#\n" +
"#..........#\n" +
"###........#\n" +
"##.....#####\n" +
"####.....###\n" +
"#..........#\n" +
"............\n" +
".....y....##\n" +
"#.........##\n" +
"#.........##\n" +
"############\n";
        org.junit.Assert.assertNotEquals(null, MapCreator.create(file));
    }
}
