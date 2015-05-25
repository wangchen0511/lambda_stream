import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class SequentialStream {

    public static void main(String[] args) {
        
        long start = System.nanoTime();
        
        File file = new File("./src/main/resources/NameScores.txt");
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){

            String record = reader.lines().filter(item -> Integer.valueOf(item.split(":")[1]) == 900230722).findAny().get();
            
            System.out.println(record);
            
        } catch (FileNotFoundException e) {
          
            e.printStackTrace();
        
        } catch (IOException e) {
          
            e.printStackTrace();
        
        }
        
        long end = System.nanoTime();
        
        System.out.println("Took " + TimeUnit.NANOSECONDS.toMillis(end - start));
    }
    
}
