/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.mapCreation;

/**
 *
 * @author lari
 */
public final class SanityCheck {
    //scale of char:px is 1:50!!!
    //x and y are used to mark spawning points. they need to be separated from the nearest unpathable by at least one . to be legitimate
    //that is why RectangleCreator is unconcerned with them
    
    /**
     * calls the other methods in this class to determine whether or not a map can be created of the file
     * @param file input map file
     * @return true if a map can be created, else, false
     */
    public static boolean isItSane(String file){
        int[] dim=dimensions(file);
        return (dim[0]*dim[1]==file.length()&&noIllegalCharacters(file)&&linesAreOfUniformLength(file, dim)&&spawnPointsAreSane(file,dim));
    }
    
    /**
     * returns the (alleged) dimensions of a map. only worth something if the map is sane
     * @param file map file
     * @return dimensions of a sane map file
     */
    public static int[] dimensions(String file){ //doesn't return a point, but map dimensions {x,y}
        int[] output=new int[2];
        output[0]=0;
        while(output[0]<file.length()&&file.charAt(output[0])!='\n'){
            output[0]++;
        }
        output[0]+=1;
        output[1]=file.length()/output[0];
        return output;
    }
    
    /**
     * @param file map file
     * @return true if there are no illegal characters
     */
    public static boolean noIllegalCharacters(String file){
        for (int i=0;i<file.length();i++){
            if (!(file.charAt(i)=='.'||file.charAt(i)=='#'||file.charAt(i)=='x'||file.charAt(i)=='y'||file.charAt(i)=='\n')) return false;
        }
        return true;
    }
    
    /**
     * checks whether or not the rows are of equal length
     * @param file map file
     * @param dimensions alleged dimensions
     * @return false if a newline is found missing
     */
    public static boolean linesAreOfUniformLength(String file, int[] dimensions){  //bugged!!!!
        for (int i=dimensions[0]-1;i<file.length();i+=dimensions[0]){  //width x height
            if (file.charAt(i)!='\n') return false;
        }
        return true;
    }
    
    /**
     * since linesAreOfUniformLength doesn't cover too MANY newlines
     * @param file map file
     * @param dimensions alleged dimensions
     * @return false if there are too many or too few newlines
     */
    public static boolean onlyEnoughNewlines(String file, int[] dimensions){
        int newlineCount=0;
        for (int i=0;i<file.length();i++){
            if (file.charAt(i)=='\n') newlineCount++;
        }
        return newlineCount==dimensions[1];
    }
    
    /**
     * checks whether or not bases are connected. otherwise attacking is impossible
     * @param file map file
     * @param dimensions dimensions of the map {x,y}
     * @param pointA
     * @param pointB
     * @param passedPoints list of points already passed
     * @return boolean that that tells if it's possible to move from point a to point b
     */
    public static boolean connected(String file, int[] dimensions, int pointA, int pointB, int[] passedPoints){
        if(pointA>=file.length()||pointA<0) return false;
        if(file.charAt(pointA)=='#') return false;
        for (int i=0;i<passedPoints.length;i++){
            if (pointA==passedPoints[i]) return false;
        }
        int[] neighbors=new int[]{pointA+dimensions[0],pointA+1,pointA-1,pointA-dimensions[0]}; //these are the indice of a points neighbors
        for (int i=0; i<=3;i++){
            if (neighbors[i]==pointB){
                return true;
            }
        }
        for (int i=0;i<passedPoints.length;i++){
            if(passedPoints[i]==0){
                passedPoints[i]=pointA;
                break;
            }
        }
        return (connected(file,dimensions,neighbors[0],pointB,passedPoints)||connected(file,dimensions,neighbors[1],pointB,passedPoints)||connected(file,dimensions,neighbors[2],pointB,passedPoints)||connected(file,dimensions,neighbors[3],pointB,passedPoints));
    }
    
    /**
     * finds spawning points, sees if there is enough space to spawn, and sees if the points are connected
     * @param file map file
     * @param dimensions dimensions
     * @return enoughSpaceToSpawn(x)&&enoughSpaceToSpawn(x)&&connected(x,y)
     */
    public static boolean spawnPointsAreSane(String file, int[] dimensions){
        //check for x
        int x=0;
        for (int i=0;i<file.length();i++){
            if (file.charAt(i)=='x'){
                x=i;
                break;
            }
        }
        if (x==0) return false;
        if (!enoughSpaceToSpawn(file,x,dimensions[0])) return false;
        int y=0;
        for (int i=0;i<file.length();i++){
            if (file.charAt(i)=='y'){
                y=i;
                break;
            }
        }
        if (y==0) return false;
        if (!enoughSpaceToSpawn(file,y,dimensions[0])) return false;
        return connected(file,dimensions,x,y,new int[file.length()]);
    }
    /**
     * first building is 3x3 tiles big, and there should be space to circle around it, too
     * @param file map file
     * @param index index of 'x' or 'y' in map file
     * @param width length of a row
     * @return true if enough space
     */
    public static boolean enoughSpaceToSpawn(String file, int index, int width){
        if (index-2*width-2<0&&index+2*width+2>=file.length()) return false;
        for (int i=-2;i<=2;i++){
            for(int j=index+i*width-2;j<=index+i*width+2;j++){
                if (file.charAt(j)!='.'&&j!=index) return false;
            }
        }
        return true;
    }
}
