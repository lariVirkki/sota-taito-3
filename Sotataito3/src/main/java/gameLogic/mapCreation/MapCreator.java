/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.mapCreation;

import gameLogic.pathingLogic.Map;
import gameLogic.pathingLogic.Rectangle;
import gameLogic.pathingLogic.RectangleCollection;
import gameLogic.pathingLogic.Ring;

/**
 *
 * @author lari
 */
public final class MapCreator {
    /**
    * calls the other classes in the package
    * input is a String and output is a Map
    * output null if file is invalid
    * @param file the map file
    * @return returns either a Map or null
    */
    public static Map create(String file){
        if(!SanityCheck.isItSane(file)) return null;
        Rectangle[] reclist =RectangleCreator.getRectangles(file, new Rectangle[20000]);
        int[] dim=SanityCheck.dimensions(file);
        return new Map(reclist,new int[]{dim[0]*50,dim[1]*50,0,0},spawnPoint(file,'x'),spawnPoint(file,'y'));
    }
    
    /**
     * Spawn points are important
     * @param file map file
     * @param mark the marker of the spawn point we are looking for
     * @return the point where mark is first noticed
     */
    public static int[] spawnPoint(String file, char mark){
        int rowLength=SanityCheck.dimensions(file)[0];
        int index=0;
        for (int i=0; i<file.length();i++){
            if (file.charAt(i)==mark){
                index=i;
                break;
            }
        }
        System.out.println((index%rowLength)*50+" and "+(index/rowLength)*50);
        return new int[] {(index%rowLength)*50,(index/rowLength)*50};
    }
}
