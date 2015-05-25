package bench.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Thread)
public class ParallelStreamUsingIOSource {

    public static void main(String[] args) throws RunnerException, ClassNotFoundException {
        
        Options opt = new OptionsBuilder().include(".*" + bench.stream.ParallelStreamUsingIOSource.class.getSimpleName() + ".*").forks(1).build();

        new Runner(opt).run();

        // test();

    }

    @Benchmark
    public static void testParrel() {
        long start = System.nanoTime();

        File file = new File("./src/main/resources/NameScores1.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String record =
                            reader.lines().parallel().filter(item -> Integer.valueOf(item.split(":")[1]) == 679780887)
                                            .findAny().get();

            System.out.println(record);

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

        long end = System.nanoTime();

        System.out.println("Took " + TimeUnit.NANOSECONDS.toMillis(end - start));
    }
    
    @Benchmark
    public static void testOldWay(){
        
        long start = System.nanoTime();
        
        File file = new File("./src/main/resources/NameScores1.txt");
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){

            String line = "";
            
            while((line = reader.readLine()) != null){
                if(Integer.valueOf(line.split(":")[1]) == 679780887){
                    System.out.println(line);
                    break;
                }
            }
            
            
            
        } catch (FileNotFoundException e) {
          
            e.printStackTrace();
        
        } catch (IOException e) {
          
            e.printStackTrace();
        
        }
        
        long end = System.nanoTime();
        
        System.out.println("Took " + TimeUnit.NANOSECONDS.toMillis(end - start));
    }

}
