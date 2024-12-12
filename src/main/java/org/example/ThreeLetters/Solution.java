package org.example.ThreeLetters;

import java.util.Objects;

public class Solution {
    public String solution(int A, int B) {
        StringBuilder result = new StringBuilder();
        char lastChar1 = ' ', lastChar2 = ' ';

        while (A > 0 || B > 0) {
            if (A > 0 && (lastChar1 != 'a' || lastChar2 != 'a') && (A >= B || lastChar1 == 'b' && lastChar2 == 'b')) {
                result.append('a');
                A--;
                lastChar2 = lastChar1;
                lastChar1 = 'a';
            } else if (B > 0 && (lastChar1 != 'b' || lastChar2 != 'b')) {
                result.append('b');
                B--;
                lastChar2 = lastChar1;
                lastChar1 = 'b';
            }
        }
        return result.toString();
    }
}
