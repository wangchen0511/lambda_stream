import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class LazinessStream {

    static class Employee {
        
        private final String name;
        
        public Employee(final String name){
            System.out.println("Create Employee object for : " + name);
            this.name = name;
        }
        
        @Override
        public String toString(){
            return this.name;
        }
        
    }
    
    public static void main(String[] args) throws InterruptedException {
        List<String> names = Arrays.asList("Chen", "Albert", "Zhen" , "Stone" ,"Charlie", "Nelson", "Allen", "Jack");
        
        System.out.println("Print the members in Java Platform, whose name starts with c/C!");
        
        Stream<Employee> stream = names.stream().filter(name -> name.matches("[Cc].*")).map(name -> {System.out.println(name); return new Employee(name);});
        
        TimeUnit.SECONDS.sleep(2);
        
        stream.collect(Collectors.toList());
    }
}
