/*
 *Name: srishti aggarwal
 *Matric no: A0157006M
 */

import java.util.*;

class compare {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int i;
      String[] input = new String[2];

      scanInput(input, scan);
      decideOutput(input);
   }

   public static void scanInput(String[] input, Scanner scan) {
      int i;
      for(i = 0; i < 2; i++) {
         input[i] = scan.next();
         input[i] = input[i].toLowerCase();
      }
   }

   public static void decideOutput(String[] input) {
      int i, j;
      int count = 0;
      for(i = 0; i < 1; i++) {
         for(j = 0; j < input[i].length(); j++) {
            if(input[i].charAt(j) > input[i+1].charAt(j)) {
               System.out.printf("2\n");
               break;
            } else if(input[i].charAt(j) < input[i+1].charAt(j)) {
               System.out.printf("1\n");
               break;
            } else if(input[i].charAt(j) == input[i+1].charAt(j)) {
               count++;
            } 
            } 
         }
         if(count == input[0].length()) {
               System.out.printf("0\n");
         }
      }
}
