/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.mapCreation;
import gameLogic.pathingLogic.*;
import java.util.Arrays;
/**
 *
 * @author lari
 * Given a list of rectangles, this clumps some of them together
 */
public final class RectangleCollectionCreator {
    /**
     * 
     * @param rectangleList list of rectangles found
     * @return list of RectangleCollections containing those rectangles
     */
    public static RectangleCollection[] sortRectangles(Rectangle[] rectangleList){
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
        // blobs don't come out as blobs... instead, every rectangle is in its own collection...
        return list;
    }
}
