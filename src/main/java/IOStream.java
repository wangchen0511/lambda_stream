import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

import java.io.*;

public class IOStream {
    public static void main(String[] args) {
      
      File file = new File(IOStream.class.getClassLoader().getResource("names.txt").getFile());
      
      try (BufferedReader reader = new BufferedReader(new FileReader(file))){
          reader.mark(1024);
          System.out.println("Print all the members in Java Platform!");
          reader.lines().forEach(name -> System.out.println(name));
          System.out.println("==========================================");

          reader.reset();
          System.out.println("Print the members in Java Platform, whose name starts with c/C!");
          reader.lines().filter(name -> name.matches("[Cc].*")).forEach(name -> System.out.println(name));
          System.out.println("==========================================");
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      }
      
      /*
      try (BufferedReader reader = new BufferedReader(new FileReader(file))){
          
          String line;
          while((line = reader.readLine()) != null){
              System.out.println(line);
          }
          
      } catch (FileNotFoundException e) {
      
          e.printStackTrace();
      
      } catch (IOException e) {
        
          e.printStackTrace();
      
      }
      */
  }
}