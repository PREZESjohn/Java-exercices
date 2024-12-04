package org.example.ArrListLen;

public class Solution {
    public int solution(int[] A){
        int counter=1;
        int pos=0;
        while(1==1){
            if(A[pos]!=-1){
                pos=A[pos];
                counter++;
            }else{
                break;
            }
        }
        return counter;
    }
    public void test(){
        System.out.println("Test");
    }
}
