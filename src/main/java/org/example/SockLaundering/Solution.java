package org.example.SockLaundering;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int solution(int K, int[] C, int[] D) {
        List<Integer> CL=Arrays.stream(C)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> DL=Arrays.stream(D)
                .boxed()
                .collect(Collectors.toList());

        int pairs = 0;
        Collections.sort(CL);
        int i = 0;
        while(i < CL.size() - 1){
            if(CL.get(i).equals(CL.get(i+1))){
                CL.remove(i);
                CL.remove(i);

                i = Math.max(0, (i - 1));
                pairs++;
            }
            else{
                i++;
            }
        }

        return pairs;
    }

}
