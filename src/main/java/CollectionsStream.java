import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

import java.io.*;

public class CollectionsStream {
    public static void main(String[] args) {
      List<String> names = Arrays.asList("Chen", "Albert", "Zhen" , "Stone" ,"Charlie", "Nelson", "Allen", "Jack");
      
      System.out.println("Print all the members in Java Platform!");
      names.stream().sorted().forEach(name -> System.out.println(name));
      System.out.println("==========================================");
      
      System.out.println("Print the members in Java Platform, whose name starts with c/C!");
      names.stream().filter(name -> name.matches("[Cc].*")).forEach(name -> System.out.println(name));
      System.out.println("==========================================");
      
      /*
      for(String name : names) {
          if(name.matches("[Cc].*")){
              System.out.println(name);
          }
      }
      */
      
  }
}