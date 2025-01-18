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
        Integer match=0;
        Stack<Integer> stosCzystych = new Stack<>();
        stosCzystych.addAll(CL);
        while(K>0 && !stosCzystych.isEmpty() && !DL.isEmpty()){
            boolean happen=false;
            for (int j = 0; j < DL.size(); j++) {
                if(DL.get(j).equals(stosCzystych.peek())){
                    DL.remove(j);
                    stosCzystych.pop();
                    K--;
                    pairs++;
                    happen=true;
                    break;
                }
            }
            if(!happen) stosCzystych.pop();
        }
        if(K!=0 && K%2==0 && DL.size()>1){
            pairs+=howManyPairs(DL);

        }
        return pairs;
    }
    public int howManyPairs(List<Integer> list){
        int pairs = 0;
        Collections.sort(list);
        int i = 0;
        while(i < list.size() - 1){
            if(list.get(i).equals(list.get(i+1))){
                list.remove(i);
                list.remove(i);

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
