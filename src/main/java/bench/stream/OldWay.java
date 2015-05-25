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
public class OldWay {

    public static void main(String[] args) throws RunnerException {
        
        System.out.println(bench.stream.OldWay.class.getSimpleName());
        
        Options opt = new OptionsBuilder().include(".*" + bench.stream.ParallelStreamUsingIOSource.class.getSimpleName() + ".*").forks(1).build();

        new Runner(opt).run();
    }
    
    @Benchmark
    public static void test(){
        
        long start = System.nanoTime();
        
        File file = new File("./src/main/resources/NameScores.txt");
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){

            String line = "";
            
            while((line = reader.readLine()) != null){
                if(Integer.valueOf(line.split(":")[1]) == 900230722){
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
