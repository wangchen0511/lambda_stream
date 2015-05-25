import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class FileGenerator {
    
    private static Random rand = new Random();

    public static void main(String[] args) throws IOException {
        
        File file  = new File("./src/main/resources/NameScores1.txt");
        
        if (!file.exists()) {
            file.createNewFile();
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
            
            writeAllComb(writer, new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'}, 0, new StringBuilder(64));
            
        } catch (FileNotFoundException e) {
          
            e.printStackTrace();
        
        } catch (IOException e) {
          
            e.printStackTrace();
        
        }
        
        System.out.println("done");
    }
    
    private static void writeAllComb(BufferedWriter writer, char[] sources, int startIndex, StringBuilder prefix) throws IOException{
        
        if(startIndex >= sources.length){
            //System.out.println("Write " + prefix.toString());
            writer.write(prefix.toString());
            writer.write(":");
            writer.write(String.valueOf(rand.nextInt(1000000000)));
            writer.newLine();
            writer.flush();
            return;
        }
        
        for(int i = startIndex; i < sources.length; i++){
            swap(sources, startIndex, i);
            prefix.append(sources[startIndex]);
            writeAllComb(writer, sources, startIndex + 1, prefix);
            prefix.deleteCharAt(startIndex);
            swap(sources, startIndex, i);
        }
    }

    private static void swap(char[] sources, int startIndex, int i) {
        
        char temp = sources[i];
        sources[i] = sources[startIndex];
        sources[startIndex] = temp;
        
    }
    
}
