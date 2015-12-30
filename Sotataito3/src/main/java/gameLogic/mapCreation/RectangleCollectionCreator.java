/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.mapCreation;
import gameLogic.pathingLogic.*;
/**
 *
 * @author lari
 */
public final class RectangleCollectionCreator {
    
    static RectangleCollection[] sortRectangles(Rectangle[] rectangleList){
        RectangleCollection[] list = new RectangleCollection[255];
        int blobNumber=0;
        list[blobNumber]=new RectangleCollection(255);
        list[blobNumber].add(rectangleList[0]);
        boolean added=false;
        for (int i=1;i<rectangleList.length;i++){ //for each rectangle there is
            if (rectangleList[i]==null)break;
            for (int j=0; j<=blobNumber;j++){  //for each blob of overlapping rectangles
                if (list[j]==null) break;
                if (list[j].overlaps(rectangleList[i])){ //overlapping rectangles for one blob
                    list[j].add(rectangleList[i]);
                    added=true;
                }
            }
            if (!added){
                blobNumber++;
                list[blobNumber]=new RectangleCollection(255);
                list[blobNumber].add(rectangleList[i]);
            }
        }
        return list;
    }
}
