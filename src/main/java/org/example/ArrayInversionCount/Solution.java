package org.example.ArrayInversionCount;

import java.util.stream.IntStream;

public class Solution {
    public int solution(int[] A){
        int result= (int) IntStream.range(0, A.length)
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, A.length)
                        .filter(j -> A[i] > A[j])
                        .mapToObj(j -> new int[]{i, j}))
                .count();
        return result;
    }
}
