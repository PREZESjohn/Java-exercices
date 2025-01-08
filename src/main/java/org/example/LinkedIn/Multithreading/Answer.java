package org.example.LinkedIn.Multithreading;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.*;

// Write your answer here, and then test your code.
// Your job is to implement the findAnswer() method and the FactorialTask class.

class Answer {

    // Change these boolean values to control whether you see
    // the expected result and/or hints.
    static boolean showExpectedResult = false;
    static boolean showHints = false;

    static Map<Integer, BigInteger> findAnswer(List<Integer> numbers) {
        Map<Integer, BigInteger> result = new HashMap<>();
        ExecutorService executor = Executors.newFixedThreadPool(5);

        List<Future<Map.Entry<Integer,BigInteger>>> futureMap=new ArrayList<>();
        for (Integer number:numbers) {
            futureMap.add(executor.submit(new FactorialTask(number)));
        }
        for (Future<Map.Entry<Integer,BigInteger>> future:futureMap) {
            try {
                Map.Entry<Integer,BigInteger> rs=future.get();
                result.put(rs.getKey(),rs.getValue());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        executor.shutdown();
        return result;
    }
}

class FactorialTask implements Callable<Map.Entry<Integer, BigInteger>> {

    Integer value;

    public FactorialTask(Integer number) {
        this.value=number;
    }

    @Override
    public Map.Entry<Integer, BigInteger> call() throws Exception {
        BigInteger result= BigInteger.valueOf(1);
        for (int i = 1; i <= value; i++) {
            result=result.multiply(BigInteger.valueOf(i));
        }
        return Map.entry(value,result);
    }
}
