package prm2t.lab5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class WordsCounter {

    /** wczytuje z pliku, zapisuje do pliku, przechowuje w pamięci słownikiem
     * meotdy: equals, hashcode, tostring, getwordcount. main
     *  */

    HashMap<String, Integer> memory = new HashMap<>(); //(klucz - wyraz, wartość - liczba wystąpień)

    /** odczytuje plik, zapisuje do arraya oddzielając spacjami, wrzuca do hashMapy  */
    private void read(String filename){
        try {
            File file = new File(filename);
            Scanner reader = new Scanner(file);

            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String[] array = line.split(" ");
                for(int i=0; i<array.length; i++){
                    memory.put(array[i], memory.getOrDefault(array[i], 0)+1);
                }
            }
            reader.close();
        } catch(FileNotFoundException e){
            System.out.println("Invalid file");
        }
    }

    /** wrzuca hashMape do pliku txt, każda linijka to jeden wyraz np (rower 2) */
    private void write(String filename){
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(this.toString());
            writer.close();
        }
        catch(IOException e) {System.out.println("Error");}
    }

    /** zwraca liczbe wystąpień wyrazu */
    private int getWordCount(String word){
        return memory.get(word);
    }

    private void clear(){
        memory.clear();
    }

    private String asString(){
        String string = "";
        for(Map.Entry<String, Integer> entry : memory.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            string = string + key + " " + value + "\n";
        }
        return string;
    }

    @Override
    public String toString(){return asString();}

    //equals

    //hashCode


    public static void main(String... args){

        WordsCounter wordsCounter = new WordsCounter();
        wordsCounter.read("resource/test.txt");
        wordsCounter.write("resource/testresult.txt");

        WordsCounter wordsCounter1 = new WordsCounter();
        wordsCounter1.read("resource/test2.txt");
        wordsCounter1.write("resource/test2result.txt");
    }

}
