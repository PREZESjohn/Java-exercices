package org.example.ArrayInversionCount;

public class Solution {
    public int solution(int[] A){
        int result=0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i+1; j <A.length; j++) {
                if(A[j]<A[i]) result++;
                if(result>1000000000) return -1;
            }
        }
        return result;
    }
}
