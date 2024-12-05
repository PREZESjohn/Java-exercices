package org.example.CountBoundedSlices;

import java.util.Arrays;
import java.util.TreeSet;

public class Solution {
    public int solution(int K, int[] A) {
        int n = A.length;
        int count = 0;
        int left = 0;

        TreeSet<Integer> sliceElements = new TreeSet<>();

        for (int right = 0; right < n; right++) {
            sliceElements.add(A[right]);

            while (sliceElements.last() - sliceElements.first() > K) {
                sliceElements.remove(A[left]);
                left++;
            }

            count += (right - left + 1);

            if (count > 1_000_000_000) {
                return 1_000_000_000;
            }
        }

        return count;
    }
}
