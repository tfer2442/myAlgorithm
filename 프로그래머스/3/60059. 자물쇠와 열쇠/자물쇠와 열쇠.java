import java.util.*;


class Solution {
    
    void calculate(int r, int c, int d, int[][] arr, int[][] key) {
        int m = key.length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (d == 0) {
                    arr[r+i][c+j] += key[i][j];    
                } else if (d == 1) {
                    arr[r+i][c+j] += key[j][m-i-1];
                } else if (d == 2) {
                    arr[r+i][c+j] += key[m-i-1][m-j-1];
                } else if (d == 3) {
                    arr[r+i][c+j] += key[m-j-1][i];
                }
            }
        }
    }

    boolean check(int[][] arr, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i+m][j+m] != 1) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean solution(int[][] key, int[][] lock) {
        
        for (int i = 0; i < lock.length + key.length - 1; i++) {
            for (int j = 0; j < lock.length + key.length - 1; j++) {   
                for (int d = 0; d < 4; d++) {
                    int[][] arr = new int[58][58];
                    
                    for (int k = 0; k < lock.length; k++) {
                        for (int m = 0; m < lock.length; m++) {
                            arr[k+key.length-1][m+key.length-1] = lock[k][m];
                        }
                    }
                    
                    calculate(i, j, d, arr, key); 
                    
                    if (check(arr, lock.length, key.length-1)) {
                        return true; 
                    }
                }
            }
        }
        
        return false;
    }
}