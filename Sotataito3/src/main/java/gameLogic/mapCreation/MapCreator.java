/*
 *  made by Lari Virkki
 *  pls no copypasterino
 */
package gameLogic.mapCreation;

/**
 *
 * @author lari
 */
public final class MapCreator {
    //scale of char:px is 1:50!!!
    //x and y are used to mark spawning points. they need to be separated from the nearest unpathable by at least one . to be legitimate
    //that is why RectangleCreator is unconcerned with them
    
    private boolean sanityCheck(String file){
        int[] dim=dimensions(file);
        return (dim[0]*dim[1]==file.length());
    }
    
    private int[] dimensions(String file){ //doesn't return a point, but map dimensions {x,y}
        int[] output=new int[2];
        output[0]=0;
        while(output[0]<file.length()&&file.charAt(output[0])!='\n'){
            output[0]++;
        }
        output[0]+=2;
        output[1]=file.length()/output[0];
        return output;
    }
    
    private boolean noIllegalCharacters(String file){
        for (int i=0;i<file.length();i++){
            if (!(file.charAt(i)=='.'||file.charAt(i)=='#'||file.charAt(i)=='x'||file.charAt(i)=='y'||file.charAt(i)=='\n')) return false;
        }
        return true;
    }
    
    private boolean linesAreOfUniformLength(String file, int[] dimensions){
        for (int i=dimensions[1]-1;i<file.length()+1;i++){
            if (file.charAt(i)!='\n') return false;
        }
        return true;
    }
    
    private boolean onlyEnoughNewlines(String file, int[] dimensions){
        int newlineCount=0;
        for (int i=0;i<file.length();i++){
            if (file.charAt(i)=='\n') newlineCount++;
        }
        return newlineCount==dimensions[1];
    }
    
    private boolean spawnPointsAreSane(String file, int[] dimensions){
        
    }
    
    private boolean connected(String file, int[] dimensions, int[][] points){
        if ()
    }
}
