package prm2t.lab4.zad2;
import java.io.File;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Set;

public class Main {

    public static TreeMap<String, Long> dictionary = new TreeMap<String, Long>();
    public static TreeMap<String, Integer> countdictionary = new TreeMap<String, Integer>();

    public static String getFileType(File file){
        String fileString = file.getName();
        int index = fileString.lastIndexOf(".");
        String fileType = fileString.substring(index);

        return fileType;
    }

    public static Set<String> getFileTypes(){
        return dictionary.keySet();
    }

    public static long getFileTypeSizes(String fileType){
        return dictionary.get(fileType);
    }



    public static void main(String[] args) {
        final File directory = new File("/home/mion/s/282/flapicz/Desktop/prog2/resource"); //zmien na input
        for(File file:directory.listFiles()){
            String fileType = getFileType(file);
            if (dictionary.containsKey(fileType)) {
                dictionary.put(fileType, file.length() + dictionary.get(fileType));
                countdictionary.put(fileType, 1 + countdictionary.get(fileType));
            } else {
                dictionary.put(fileType, file.length());
                countdictionary.put(fileType, 1);
            }
        }
        System.out.println("Wyniki alfabetycznie " + getFileTypes());
        System.out.println("Wyniki wg liczby plików" + countdictionary);
        System.out.println("Wyniki wg rozmiaru plików" + dictionary);
        //zapytaj o kontynuacje
    }
}
