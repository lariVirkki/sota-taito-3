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
    public static Map create(String file){
        if(!SanityCheck.isItSane(file)) return null;
        RectangleCollection[] reclist=RectangleCollectionCreator.sortRectangles(RectangleCreator.getRectangles(file, new Rectangle[255],0));
        Ring[] ringlist=RingCreator.createRingList(reclist);
        int[] dim=SanityCheck.dimensions(file);
        return new Map(ringlist,reclist,new int[]{dim[0]*50,dim[1]*50,0,0});
    }
}
