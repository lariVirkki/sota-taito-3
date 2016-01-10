/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.mapCreation;
import gameLogic.pathingLogic.*;
/**
 *
 * @author lari
 * 
 * Given a file, this class is used to return a list of rectangles there are
 */
public final class RectangleCreator {
    //private String mapFile;
    //private Map mapInstance;
    
    /* public MapReader(String file){
        mapFile=file;
    }
    */
    
    /**
     * 
     * @param file is the file
     * @param rectanglesSoFar passes the list of rectangles to other, private methods
     * @return Return rectangles found
     */
    /*public static Rectangle[] getRectangles(String file, Rectangle[] rectanglesSoFar){
        int rowLength=0;
        while (true){
            if(file.charAt(rowLength)=='\n') break;
            rowLength++;
        }
        rowLength++;
        return findRectangleBeginning(file,rowLength,rectanglesSoFar);
    }
    */
    
    /**
     * Adds a rectangle to list
     * @param list the list the rectangles are supposed to be added to
     * @param start starting index of a row of '#'
     * @param end ending index of a row of '#'
     * @param file the input file is passed here, too
     * @param rowLength knowing the length of a row makes reading the character below or above possible
     * @return returns the list when appropriate additions have been made
     */
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
    
    /**
     * Returns the biggest rectangle whose top part is the row specified 
     * 
     * @param file input file passed here, too
     * @param start start of row of '#'
     * @param end end of row of '#'
     * @param rowLength length of a row in file
     * @return a rectangle
     */
    private static Rectangle finishRectangle(String file,int start, int end, int rowLength){
        int b=start;
        int e=end;
        int bottom=start/rowLength; //y-axis grows from bottom to top!!... which means the maps will be inverted horizontally :DD
        int left=start%rowLength;
        //int top=bottom;
        wideSearch:
        while (b+(end-start)<file.length()){
            for (int i=b;i<=e;i++){
                if (file.charAt(i)!='#') break wideSearch;
            }
            b+=rowLength;
            e+=rowLength;
        }
        int top=e/rowLength-1;
        
        int right=e%rowLength;
        return new Rectangle(top*50+50,bottom*50,left*50,right*50+50); //one row of ### will have height, and scale of char:px is 1:50!!!
    }
    
    /**
     * This method is supposed to find the continuous rows of '#' in the file
     * @param file input file
     * @param rowLength the length of a row
     * @param rectanglesSoFar the list of rectangles already found
     * @return the list of rectangles found
     */
    private static Rectangle[] findRectangleBeginning(String file, int rowLength,Rectangle[] rectanglesSoFar){
        int unpathableStart=1, unpathableEnd;
        int row=0;
        boolean started=false;
        while ((row+1)*rowLength<=file.length()){ //no array out of bounds, pls
            for (int i=row*rowLength;i<(row+1)*rowLength;i++){ //i starts out as the first in row, and ends up being the newline character
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
    
    public static Rectangle[] getRectangles(String file, Rectangle[] rectanglesSoFar){
        int top=50; int bottom=0;
        int addIndex=0;
        int rowLength=getRowLength(file);
        for (int i=0;i<file.length();i++){
            if (file.charAt(i)=='#'){
                rectanglesSoFar[addIndex]=new Rectangle(top, bottom,(i%rowLength)*50,((i%rowLength)+1)*50);
                addIndex++;
            }else if(file.charAt(i)=='\n'){
                bottom=top;
                top+=50;
            }
        }
        return rectanglesSoFar;
    }
    
    private static int getRowLength(String file){
        int rowLength=0;
        while (true){
            if(file.charAt(rowLength)=='\n') break;
            rowLength++;
        }
        rowLength++;
        return rowLength;
    }
}
