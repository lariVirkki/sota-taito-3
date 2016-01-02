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
public class SanityCheckTest {
    
    @Test
    public void onlyAllowedCharactersNegative(){
        String shah="#########/n.......x";
        org.junit.Assert.assertEquals(false, SanityCheck.noIllegalCharacters(shah));
    }
    
    @Test
    public void onlyAllowedCharactersPositive(){
        String shah="#########\n.......x..yyy..######\n";
        org.junit.Assert.assertEquals(true, SanityCheck.noIllegalCharacters(shah));
    }
    
    @Test
    public void dimensionChecksWorkNegative(){
        String shah="#########\n........\n.......##\n";
        org.junit.Assert.assertEquals(false, SanityCheck.linesAreOfUniformLength(shah, SanityCheck.dimensions(shah)));
    }
    
    @Test
    public void dimensionChecksWorkPositive(){
        String shah=".....\n.....\n.....\n.....\n.....\n.....\n";
        org.junit.Assert.assertEquals(true, SanityCheck.linesAreOfUniformLength(shah, SanityCheck.dimensions(shah)));
    }
    
    @Test
    public void dimensionsCalculatedCorrectly(){
        String shah=".....\n.....\n.....\n.....\n.....\n.....\n";
        org.junit.Assert.assertArrayEquals(new int[]{6,6}, SanityCheck.dimensions(shah));
    }
    
    @Test
    public void dimensionsCalculated2(){
        String ass="###########\n" +
"#.........#\n" +
"#.........#\n" +
"#....x....#\n" +
"#.........#\n" +
"#.........#\n" +
"#.........#\n" +
"#.........#\n" +
"#.........#\n" +
"#.........#\n" +
"#.........#\n" +
"#....y....#\n" +
"#.........#\n" +
"#.........#\n" +
"###########\n";
        org.junit.Assert.assertArrayEquals(new int[]{12,15}, SanityCheck.dimensions(ass));
    }
    
    
    @Test
    public void spawnPointRequiredSpaceNegative(){
        String file="############\n" +
"#..........#\n" +
"#....x.....#\n" +
"###........#\n" +
"##.....#####\n" +
"####.....###\n" +
"#....y.....#\n" +
"............\n";
        org.junit.Assert.assertEquals(false, SanityCheck.enoughSpaceToSpawn(file, 2*SanityCheck.dimensions(file)[0]+6, SanityCheck.dimensions(file)[0]));
    }
    
    @Test
    public void spawnPointSpacePositive(){
        String file="###########\n" +
"#.........#\n" +
"#.........#\n" +
"#....x....#\n" +
"#.........#\n" +
"#.........#\n" +
"#.........#\n" +
"###########\n" +
"#.........#\n" +
"#.........#\n" +
"#.........#\n" +
"#....y....#\n" +
"#.........#\n" +
"#.........#\n" +
"###########\n";
        int x=0;
        for (int i=0;i<file.length();i++){
            if (file.charAt(i)=='x') x=i;
        }
        org.junit.Assert.assertEquals(true, SanityCheck.enoughSpaceToSpawn(file, x, SanityCheck.dimensions(file)[0]));
    }
    
    @Test
    public void connectionPositive1(){
        String file="###########\n" +
"#.........#\n" +
"#.........#\n" +
"#....x....#\n" +
"#.........#\n" +
"#.........#\n" +
"#.........#\n" +
"#.........#\n" +
"#.........#\n" +
"#.........#\n" +
"#.........#\n" +
"#....y....#\n" +
"#.........#\n" +
"#.........#\n" +
"###########\n";
        org.junit.Assert.assertEquals(true, SanityCheck.spawnPointsAreSane(file, SanityCheck.dimensions(file)));
    }
    
    @Test
    public void spawnPointConnectNegative1(){
        String file="###########\n" +
"#.........#\n" +
"#.........#\n" +
"#....x....#\n" +
"#.........#\n" +
"#.........#\n" +
"#.........#\n" +
"###########\n" +
"#.........#\n" +
"#.........#\n" +
"#.........#\n" +
"#....y....#\n" +
"#.........#\n" +
"#.........#\n" +
"###########\n";
        org.junit.Assert.assertEquals(false, SanityCheck.spawnPointsAreSane(file, SanityCheck.dimensions(file)));
    }
    
}
