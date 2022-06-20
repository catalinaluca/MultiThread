import org.w3c.dom.ls.LSInput;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final long startTime=System.currentTimeMillis();
        int maximumNumberOfDivisors=0;
        ExecutorService executorService= Executors
                .newFixedThreadPool(10);
        Future<Integer>[] maximums=new Future[10];
        for (int i=0;i<10;i++) {
            NumberOfDivisors number = new NumberOfDivisors(i);
            maximums[i]=executorService.submit(number);
        }
        executorService.shutdown();
        for (Future<Integer> values:maximums){
            int value=values.get();
            if(value>maximumNumberOfDivisors)maximumNumberOfDivisors=value;
        }
        System.out.println(maximumNumberOfDivisors);
        final long timeFirstEnded=System.currentTimeMillis();
        System.out.println("Time for multi threaded solution in milliseconds: "+(timeFirstEnded-startTime));
        sigleThreadSolution();
        System.out.println("Time for single threaded solution in milliseconds: "+(System.currentTimeMillis()-timeFirstEnded));
    }
    public static void sigleThreadSolution(){
        int maximumNumberOfDivisors=0;
        NumberOfDivisors number=new NumberOfDivisors(1);
        for(int i=1;i<=100000;i++){
            int value=number.numberOfDivisors(i);
            if(maximumNumberOfDivisors<value)maximumNumberOfDivisors=value;
        }
        System.out.println(maximumNumberOfDivisors);
    }
}
