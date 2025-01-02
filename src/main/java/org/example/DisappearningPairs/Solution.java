package org.example.DisappearningPairs;

public class Solution {
    public String solution(String S) {
        return findPair(S);
    }
    
    private String findPair(String s){
        String result;
        for (int i = 0; i < s.length()-1; i++) {
            if(s.substring(i, i + 2).equals("AA")||s.substring(i, i + 2).equals("BB")||s.substring(i, i + 2).equals("CC")){
                result=s.substring(i,i+1);
                findPair(result);
            }
        }
        return s;
    }
}
