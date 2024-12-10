package org.example.CountriesCount;

public class Solution {
    public int solution(int[][] A){
        // leci po kazdym elemencie w tabeli. Po przejsciu przez komorke, zapisuje w pomocniczej ze odwiedzona
        // jak komorka jest odwiedzona ->skip
        // Jak nie ma sasiada z takim samym "kolorem: -> +1 countriesCount
        // jak wystepuje sąsiad nieodwiedzony to ->+1 countriesCount i zaznaczam "odwiedzenie" na sasiadach
        // jak jest sąsiad odwiedzony to skip
        boolean[][] visited= new boolean[A.length][];
        int countriesCount=0;
        int color;
        boolean sasiad;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if(!visited[i][j]){
                    color=A[i][j];
                    visited[i][j]=true;
                    if(j+1>A[i].length){
                        if (A[i][j + 1] == color && !visited[i][j + 1]) {//prawy sasiad
                            visited[i][j + 1] = true;
                            continue;
                        }
                    }
                    if(j!=0){
                        if (A[i][j - 1] == color && !visited[i][j - 1]) {//lewy sasiad
                            visited[i][j - 1] = true;
                            continue;
                        }
                    }
                    if(i!=0){
                        if (A[i - 1][j] == color && !visited[i - 1][j]) {//gorny sasiad
                            visited[i - 1][j] = true;
                            continue;
                        }
                    }
                    if(j+1>A.length){
                        if (A[i + 1][j] == color && !visited[i + 1][j]) {//dolny sasiad
                            visited[i + 1][j] = true;
                            continue;
                        }
                    }
                    countriesCount++;
                }
            }

        }
        return 1;
    }
}
