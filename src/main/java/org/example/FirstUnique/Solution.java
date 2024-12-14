package org.example.FirstUnique;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Solution {
    public int solution(int A[]){
        Map<Integer, Integer> baza = new LinkedHashMap<>();
        BiFunction<Integer, Integer, Integer> addFunction = Integer::sum;
        for (int j : A) {
            baza.merge(j, 1, (k, v) -> addFunction.apply(v, 1));
        }
        int v = baza.entrySet().stream().filter(e->e.getValue().equals(1)).map(Map.Entry::getKey).findFirst().orElse(-1);
        return v;
    }
}
