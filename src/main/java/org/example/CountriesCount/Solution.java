package org.example.CountriesCount;

import java.util.Stack;

public class Solution {
    public int solution(int[][] A){
        // leci po kazdym elemencie w tabeli. Po przejsciu przez komorke, zapisuje w pomocniczej ze odwiedzona
        // jak komorka jest odwiedzona ->skip
        // Jak nie ma sasiada z takim samym "kolorem: -> +1 countriesCount
        // jak wystepuje sąsiad nieodwiedzony to ->+1 countriesCount i zaznaczam "odwiedzenie" na sasiadach
        // jak jest sąsiad odwiedzony to skip
        int rows = A.length;
        int cols = A[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int countries = 0;

        // Directions for moving north, south, east, and west
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};


        // Main loop to find connected components
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {
                    countries++;
                    Stack<int[]> stack = new Stack<>();
                    stack.push(new int[]{i, j});

                    while (!stack.isEmpty()) {
                        int[] current = stack.pop();
                        int r = current[0], c = current[1];

                        if (r < 0 || r >= rows || c < 0 || c >= cols || visited[r][c] || A[r][c] != A[i][j]) {
                            continue;
                        }

                        visited[r][c] = true;
                        for (int k = 0; k < 4; k++) {
                            stack.push(new int[]{r + dRow[k], c + dCol[k]});
                        }
                    }
                }
            }
        }

        return countries;
    }
}
