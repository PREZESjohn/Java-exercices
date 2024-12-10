package org.example.ParityDegree;

public class Solution {
    public int solution(int N){
        int result=0;
        for (int i = 1; i < N; i++) {
            double calc=Math.pow(2,i);
            if(N%calc==0) result++;
            if (calc>N) break;
        }
        return result;
    }
}
