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
    
    public static boolean isItSane(String file){
        int[] dim=dimensions(file);
        return (dim[0]*dim[1]==file.length()&&noIllegalCharacters(file)&&linesAreOfUniformLength(file, dim)&&spawnPointsAreSane(file,dim));
    }
    
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
    
    public static boolean noIllegalCharacters(String file){
        for (int i=0;i<file.length();i++){
            if (!(file.charAt(i)=='.'||file.charAt(i)=='#'||file.charAt(i)=='x'||file.charAt(i)=='y'||file.charAt(i)=='\n')) return false;
        }
        return true;
    }
    
    public static boolean linesAreOfUniformLength(String file, int[] dimensions){  //bugged!!!!
        for (int i=dimensions[0]-1;i<file.length();i+=dimensions[0]){  //width x height
            //System.out.println("i = "+i);
            //System.out.println("width = "+dimensions[0]);
            if (file.charAt(i)!='\n') return false;
        }
        return true;
    }
    
    public static boolean onlyEnoughNewlines(String file, int[] dimensions){
        int newlineCount=0;
        for (int i=0;i<file.length();i++){
            if (file.charAt(i)=='\n') newlineCount++;
        }
        return newlineCount==dimensions[1];
    }

    public static boolean connected(String file, int[] dimensions, int pointA, int pointB, int[] passedPoints){
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
