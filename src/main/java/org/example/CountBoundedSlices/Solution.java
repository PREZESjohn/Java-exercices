package org.example.CountBoundedSlices;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.TreeSet;

public class Solution {
    public int solution(int K, int[] A) {
        int n = A.length;
        int count = 0;
        int left = 0;

        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        for (int right = 0; right < n; right++) {
            while (!maxDeque.isEmpty() && A[maxDeque.peekLast()] <= A[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            while (!minDeque.isEmpty() && A[minDeque.peekLast()] >= A[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);


            while (A[maxDeque.peekFirst()] - A[minDeque.peekFirst()] > K) {
                left++;
                if (maxDeque.peekFirst() < left) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() < left) {
                    minDeque.pollFirst();
                }
            }
            count += (right - left + 1);

            if (count > 1_000_000_000) {
                return 1_000_000_000;
            }
        }

        return count;
    }
}
