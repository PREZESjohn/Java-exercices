package org.example.DisappearningPairs;

import java.util.Stack;

public class Solution {
    public String solution(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if(!stack.isEmpty() && stack.peek()==c){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        StringBuilder result=new StringBuilder();
        for (char c :stack) {
            result.append(c);
        }
        return result.toString();
    }
    

}
