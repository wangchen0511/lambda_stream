import java.util.*;
import java.util.stream.Stream;
import static java.util.stream.Collectors.joining;
import java.io.*;

public class ArrayStream {
    public static void main(String[] args) {
        String[] names = new String[] {"Chen", "Albert", "Zhen", "Stone", "Charlie", "Nelson", "Allen", "Jack"};

        /*
        for(String name : names) {
            System.out.println(name);
        }
        */
        
        System.out.println("Print all the members in Java Platform!");
        Arrays.stream(names).forEach(name -> System.out.println(name));
        System.out.println("==========================================");

        /*
        for(String name : names) {
            if (name.matches("[Cc].*")) {
                System.out.println(name);
            }
        }
        */
        
        System.out.println("Print the members in Java Platform, whose name starts with c/C!");
        Arrays.stream(names).filter(name -> name.matches("[Cc].*")).forEach(name -> System.out.println(name));
        System.out.println("==========================================");

        /*
        String firstName;
        for(String name : names) {
            if (name.matches("[Cc].*")) {
                firstName = name;
                break;
            }
        }
        */
        
        System.out.println("Print the first namein Java Platform, which starts with c/C!");
        String firstName;
        firstName = Arrays.stream(names).filter(name -> name.matches("[Cc].*")).findFirst().get();
        System.out.println(firstName);
        System.out.println("==========================================");
    }
}
