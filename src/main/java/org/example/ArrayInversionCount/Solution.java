package org.example.ArrayInversionCount;

import java.util.stream.IntStream;

public class Solution {
    public int solution(int[] A) {
        int[] temp = new int[A.length];
        long inversionCount = mergeSortAndCount(A, temp, 0, A.length - 1);
        return inversionCount > 1_000_000_000 ? -1 : (int) inversionCount;
    }

    private long mergeSortAndCount(int[] A, int[] temp, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = (left + right) / 2;
        long inversions = 0;

        inversions += mergeSortAndCount(A, temp, left, mid);
        inversions += mergeSortAndCount(A, temp, mid + 1, right);

        inversions += mergeAndCount(A, temp, left, mid, right);

        return inversions;
    }

    private long mergeAndCount(int[] A, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        long inversions = 0;

        while (i <= mid && j <= right) {
            if (A[i] <= A[j]) {
                temp[k++] = A[i++];
            } else {
                temp[k++] = A[j++];
                inversions += (mid - i + 1);
                if (inversions > 1_000_000_000) {
                    return inversions;
                }
            }
        }

        while (i <= mid) {
            temp[k++] = A[i++];
        }
        while (j <= right) {
            temp[k++] = A[j++];
        }

        for (i = left; i <= right; i++) {
            A[i] = temp[i];
        }

        return inversions;
    }
}
