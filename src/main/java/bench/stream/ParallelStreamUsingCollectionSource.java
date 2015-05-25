package bench.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

@State(Scope.Thread)
public class ParallelStreamUsingCollectionSource {

    private static List<String> strs = new ArrayList<>();
    
    static{
        
        File file = new File("./src/main/resources/NameScores1.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            
            System.out.println("Start Loadin!");
            
            String line;
            
            while((line = reader.readLine()) != null){
                strs.add(line);
            }

            System.out.println("Loading is done!");

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        
    }
    
    public static void main(String[] args) throws RunnerException, ClassNotFoundException {
        
        Options opt = new OptionsBuilder().include(".*" + bench.stream.ParallelStreamUsingCollectionSource.class.getSimpleName() + ".*").forks(1).build();

        new Runner(opt).run();
        
        // test();

    }

    @Benchmark
    public static void testParrel() {
        long start = System.nanoTime();

        String result = strs.stream().parallel().filter(item -> Integer.valueOf(item.split(":")[1]) == 679780887).findAny().get();
        
        System.out.println(result);
        
        long end = System.nanoTime();

        System.out.println("Took " + TimeUnit.NANOSECONDS.toMillis(end - start));
    }
    
    @Benchmark
    public static void testOldWay(){
        
        long start = System.nanoTime();
        
        for(String line : strs){
            if(Integer.valueOf(line.split(":")[1]) == 679780887){
                System.out.println(line);
                break;
            }
        }
        
        long end = System.nanoTime();
        
        System.out.println("Took " + TimeUnit.NANOSECONDS.toMillis(end - start));
    }

}
