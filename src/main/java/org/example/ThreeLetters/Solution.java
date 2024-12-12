package org.example.ThreeLetters;

import java.util.Objects;

public class Solution {
    public String solution(int A, int B) {
        StringBuilder result= new StringBuilder("");
        boolean aGreater=(A>=B);
        int aControl=A;
        int bControl=B;
        if(A==1 && B==1) return "ab";
        if(aGreater) {
            result.append("aa");
            aControl-=2;
        }
        if(!aGreater) {
            result.append("bb");
            bControl-=2;
        }
        while (result.length()<=(A+B)-2){
            String control=result.substring(result.length()-2);
            if(Objects.equals(control, "aa") && bControl>0) {
                result.append("b");
                bControl-=1;
            }
            if(Objects.equals(control, "bb") && aControl>0) {
                result.append("a");
                aControl-=1;
            }
            if(Objects.equals(control, "ab") && aControl>0) {
                result.append("a");
                aControl-=1;
            }else {
                result.append("b");
                bControl-=1;
            }
            if(Objects.equals(control, "ba") && aControl>0) {
                result.append("a");
                aControl-=1;
            }else {
                result.append("b");
                bControl-=1;
            }
            System.out.println(result.toString());
        }
        return result.toString();
    }
}
