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
public final class RectangleCreator {
    //private String mapFile;
    //private Map mapInstance;
    
    /* public MapReader(String file){
        mapFile=file;
    }
    */
    
    public static Rectangle[] getRectangles(String file, Rectangle[] rectanglesSoFar, int row){
        int rowLength=0;
        while (true){
            if(file.charAt(rowLength)=='\n') break;
            rowLength++;
        }
        rowLength++;
        return findRectangleBeginning(file,row,rowLength,rectanglesSoFar);
    }
    
    private static Rectangle[] add(Rectangle[] list, int start, int end, String file,int rowLength){
        Rectangle addend=finishRectangle(file,start,end,rowLength);
        for (int i=0; i<list.length;i++){
            if (list[i]==null){
                list[i]=addend;
                break;
            }
            if (list[i].contains(addend)) break;
        }
        return list;
    }
    
    private static Rectangle finishRectangle(String file,int start, int end, int rowLength){
        int b=start; //b and e as in Beginning and End
        int e=end;
        int bottom=start/rowLength; //y-axis grows from bottom to top!!... which means the maps will be inverted horizontally :DD
        int left=start%rowLength;
        wideSearch:
        while (b+(end-start)<file.length()){
            for (int i=b;i<=e;i++){
                if (file.charAt(i)!='#') break wideSearch;
            }
            b+=rowLength;
            e+=rowLength;
        }
        //System.out.print("b = "+b);
        int top=e/rowLength-1;
        int right=e%rowLength;
        return new Rectangle(top,bottom,left,right);
    }
    
    private static Rectangle[] findRectangleBeginning(String file, int row, int rowLength,Rectangle[] rectanglesSoFar){
        int unpathableStart=1, unpathableEnd;
        boolean started=false;
        while ((row+1)*rowLength<=file.length()){ //no array out of bounds, pls
            for (int i=row*rowLength;i<(row+1)*rowLength;i++){ //i starts out as the first in row, and ends up being the newline character
                System.out.print(file.charAt(i));  //debug code
                if (file.charAt(i)=='#'&&!started){
                    unpathableStart=i;
                    started=true;
                }
                if ((file.charAt(i)=='.'||file.charAt(i)=='\n')&&started){ //so that blocks ending in pathable terrain or newline can be caught
                    unpathableEnd=i-1;
                    rectanglesSoFar=add(rectanglesSoFar,unpathableStart,unpathableEnd,file,rowLength);
                    started=false;
                }
            }
            row++;
        }
        return rectanglesSoFar;
    }
}
