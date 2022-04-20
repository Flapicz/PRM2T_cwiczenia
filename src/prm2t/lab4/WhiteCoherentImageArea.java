package prm2t.lab4;

import prm2t.PRM2TUtil;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

import static prm2t.PRM2TUtil.prn;

/**
 * To find all white coherent areas in the binary image.
 */
public class WhiteCoherentImageArea {
    private final String pathName;
    public int areaSize;

    // there will be whiteCoherentImageAreas.size() white coherent areas in the image
    // and n-th area has whiteCoherentImageAreas.get(n).getInt() pixels
    private final List<Integer> whiteCoherentImageAreas = new ArrayList<>();

    WhiteCoherentImageArea(String pathName) throws IOException {
        this.pathName = pathName;
        int[][] img = PRM2TUtil.readImage(pathName);

        int height = img.length;
        int lenght = img[0].length;

        int areas = 0;
        int[] areasSize = new int[20]; //zmien na ArrayList

        for (int i=0; i<height; i++){
            for (int j=0; j<lenght; j++){
                if (img[i][j] == 1){
                    img = checkArea(i,j,img);
                    areasSize[areas] = areaSize;
                    areas++;
                }
            }
        }
        prn(areas);
        prn(Arrays.toString(areasSize));
    }

    public int[][] checkArea(int x, int y, int[][] img){
        areaSize = 0;
        Set<int[]> set = new LinkedHashSet<>();
        LinkedList<int[]> currentArea = new LinkedList<>();
        set.add(new int[]{x, y});
        currentArea.add(new int[]{x,y});
        ArrayList nP;

        while (currentArea.size()>0) {
            int[] xy = currentArea.removeFirst();
            x = xy[0];
            y = xy[1];
            areaSize++;
            nP = newPixels(x,y,img);
            for(int i =0; i<nP.size(); i++){
                int[] element = (int[]) nP.get(i);
                if(!set.contains(element)) { // NIE DZIAŁA
                    //prn("True");
                    currentArea.add(element);
                    set.add(element);
                }
            }
            set.addAll(nP);
            img[x][y] = 0;
        }
        return img;
    }


    public ArrayList newPixels(int row, int column, int[][] img){
        ArrayList<int[]> whitePixels = new ArrayList<>();
        int[][] toCheck = {
                {row-1,column-1},{row-1,column},{row-1,column+1},{row,column-1},{row,column+1},{row+1,column-1},{row+1,column},{row+1,column+1}
        };

        for(int i=0;i<8;i++ ){
            int x = toCheck[i][0];
            int y = toCheck[i][1];
            if (img[x][y] == 1) {
                int[] xy = {x,y};
                whitePixels.add(xy);
            }
        }
        return whitePixels;
    }


    /**
     * @return String describing white coherent areas found in the image; string is ready to present to the end user.
     */
    public String asString() {
        StringBuilder sb = new StringBuilder("There ");
        sb.append(switch (whiteCoherentImageAreas.size()) {
            case 0 -> "is no";
            case 1 -> "is one";
            default -> String.format("are %d", whiteCoherentImageAreas.size());
        });
        sb.append(" coherent area").append(whiteCoherentImageAreas.size() > 1 ? "s" : "");
        sb.append(" in the image file ").append(pathName);
        if (whiteCoherentImageAreas.size() == 1) {
            sb.append(" of size ").append(whiteCoherentImageAreas.get(0));
            return sb.toString();
        }
        if (whiteCoherentImageAreas.size() < 2) {
            return sb.toString();
        }
        sb.append(String.format("%nCoherent areas sizes: "));
        for (Integer areaSize : whiteCoherentImageAreas) {
            sb.append(areaSize).append(", ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    @Override
    public String toString() {
        return asString();
    }



    public static void main(String[] args) throws IOException {
        //final String pathName = args[0];
        final String pathName = "resource/obrazek1.png";
        try {
            prn(new WhiteCoherentImageArea(pathName).asString());
        } catch (IOException ioe) {
            prn("Error reading image file %s (%s)", pathName, ioe);
        }
    }
}
