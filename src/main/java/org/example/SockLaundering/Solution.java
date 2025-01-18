package org.example.SockLaundering;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(int K, int[] C, int[] D) {
        Map<Integer, Integer> cleanCount = new HashMap<>();
        Map<Integer, Integer> dirtyCount = new HashMap<>();
        for (int c : C) {
            cleanCount.put(c, cleanCount.getOrDefault(c, 0) + 1);
        }
        for (int d : D) {
            dirtyCount.put(d, dirtyCount.getOrDefault(d, 0) + 1);
        }
        int totalPairs = 0;
        for (Map.Entry<Integer, Integer> entry : cleanCount.entrySet()) {
            int color = entry.getKey();
            int count = entry.getValue();
            totalPairs += count / 2;
            cleanCount.put(color, count % 2);
        }
        for (Map.Entry<Integer, Integer> entry : cleanCount.entrySet()) {
            if (K == 0) break;
            int color = entry.getKey();
            if (entry.getValue() == 1 && dirtyCount.getOrDefault(color, 0) > 0) {
                totalPairs++;
                dirtyCount.put(color, dirtyCount.get(color) - 1);
                K--;
            }
        }
        for (Map.Entry<Integer, Integer> entry : dirtyCount.entrySet()) {
            if (K < 2) break;
            int color = entry.getKey();
            int count = entry.getValue();
            int pairs = Math.min(count / 2, K / 2);
            totalPairs += pairs;
            K -= pairs * 2;
        }
        return totalPairs;
    }
}
