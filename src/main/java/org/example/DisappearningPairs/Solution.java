package org.example.DisappearningPairs;

public class Solution {
    public String solution(String S) {
        return findPair(S);
    }
    
    private String findPair(String s){
        String result;
        result=s.replaceFirst("AA|BB|CC","");
        if(result.equals(s)){
            return s;
        }else{
            return findPair(result);
        }
    }
}
