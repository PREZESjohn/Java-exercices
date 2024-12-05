package org.example.CountBoundedSlices;

import java.util.Arrays;

public class Solution {
    public int solution(int K, int[] A) {
        int[] tmp;
        int counter=0;
        int min, max;
        for(int i=0; i<A.length; i++){
            for(int j=i; j<A.length; j++){
                tmp=Arrays.copyOfRange(A,i,j+1);
                if((Arrays.stream(tmp).max().getAsInt()-Arrays.stream(tmp).min().getAsInt())<=K){
                    counter++;
                }
            }
        }
        return counter;
    }
}
