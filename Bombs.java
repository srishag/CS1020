/*
*Name: srishti aggarwal
*Matric no: A0157006M
*/

import java.util.*;

class Bombs {

   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int R = scan.nextInt();
      int C = scan.nextInt();
      int[][] grid = new int[R][C];
      int i, j;
      
      for(i = 0; i < R; i++) {
         for(j = 0; j < C; j++) {
            grid[i][j] = scan.nextInt();
         }
      }

      int Q = scan.nextInt();

      for (int k = 0; k < Q; k++) {
         Type1(grid, R, C, scan);
      }

      Type2(grid, R, C);
   }

   public static void Type1(int[][] grid, int R, int C, Scanner scan) {
      int i, j, a = 0, b = 0;
      int sum = 0;
      int maxSum = 0;
      int iBest = 0, jBest = 0;

      int N = scan.nextInt();

         for(i = 0; i < grid.length; i++) {
            for(j = 0; j < grid[i].length; j++) {
               int topLeftx = (j - ((N-1)/2)), topLefty = (i - ((N-1)/2));
               int botRightx = (j + ((N-1)/2)), botRighty = (i + ((N-1)/2));

               for(a = topLefty; ((a < (botRighty + 1)) && (a < grid.length)); a++) {
                  for(b = topLeftx; ((b < (botRightx + 1)) && (b < grid[0].length)); b++) {
                     if((a >= 0) && (b >= 0)) {
                        sum = sum + grid[a][b];
                     }
                  }
               }

               if (sum > maxSum) {
                  maxSum = sum;
                  iBest = i;
                  jBest = j;

               }

               sum = 0;

            }
         }

         System.out.printf("%d %d\n", iBest, jBest);
         return;

      }

   public static void Type2(int grid[][], int R, int C) {
      int i, j, a = 0, b = 0;
      int iBest = 0, jBest = 0;
      int N = 0;
      int point = 0, maxPoint = 0;
      int bestN = 1;

      while (N <= C || N <= R) {
         for(i = 0; i < grid.length; i++) {
            for(j = 0; j < grid[i].length; j++) {
               int topLeftx = (j - (N/2)), topLefty = (i - (N/2));
               int botRightx = (j + (N/2)), botRighty = (i + (N/2));

               for(a = topLefty; ((a < (botRighty + 1)) && (a < grid.length)); a++) {
                  for(b = topLeftx; ((b < (botRightx + 1)) && (b < grid[0].length)); b++) {
                     if((a >= 0) && (b >= 0)) {
                        if(grid[a][b] == 1) {
                           point = point + 3;
                        } else if (grid[a][b] == 0) {
                           point = point - 1;
                        }
                     }
                  }
               }

               if (point > maxPoint) {
                  maxPoint = point;
                  bestN = N + 1;
                  iBest = i;
                  jBest = j;
               }
               point = 0;
            }
         }
         N = N + 2;
      }

      System.out.printf("%d %d %d\n", iBest, jBest, bestN);
      return;
   }
}


