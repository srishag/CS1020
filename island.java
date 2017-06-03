/*
*Name: srishti aggarwal
*Matric no: A0157006M
*/

import java.util.*;

public class island {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int R = scan.nextInt();
      int C = scan.nextInt();
      int[][] map = new int[R+1][C+1];
      int i, j;

      for(i = 1; i < (R+1); i++) {
         for(j = 1; j < (C+1); j++) {
            map[i][j] = scan.nextInt();
         }
      }

      findIsland(map, R, C);
  }

  public static void findIsland(int[][] map, int R, int C) {
     int i, j;
     int count = 0;
      
      for(i = 1; i < (R+1); i++) {
         for(j = 1; j < (C+1); j++) {
            if(map[i][j] == 1 && map[i-1][j] == 0 && map[i][j-1] == 0) {
               count++;
            }
         }
      }

      System.out.printf("%d\n", count);
}
}
