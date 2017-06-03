/**
 * Name: srishti aggarwal
 * Matric no: A0157006M
 */

import java.util.*;

public class Chemistry {
   private Stack<Integer> mass = new Stack<Integer>();
   private HashMap<Character, Integer> table = new HashMap<Character, Integer>();

   public static void main(String[] args) {
      Chemistry chem = new Chemistry();
      chem.run();
   }

   public void run() {
      Scanner scan = new Scanner(System.in);   
      int n = scan.nextInt();
      addMap(scan, n);
      String form = scan.nextLine();
      char[] formula = form.toCharArray();
      doQ(formula);
   }

   public void addMap(Scanner s, int num) {
      int i;

      for(i = 0; i < num; i++) {
         char letter = s.next().charAt(0);
         int weight = s.nextInt();

         table.put(letter, weight);
      }
      s.nextLine();
   }

   public void doQ(char[] form) {
      int i, newPeek = 0;

      mass.push(0);

      for(i = 0; i < form.length; i++) {
         char curr = form[i];

         if(curr == '(') {
            mass.push(0);
         } else if(curr == ')') {
            while(mass.peek() != 0) {
               newPeek = newPeek + mass.peek();
               mass.pop();
               if(mass.peek() == 0) {
                  mass.pop();
               }
            }
            mass.push(newPeek); 
         } else if(Character.isDigit(curr)) {
           System.out.println(curr);
           int tbc = curr;
           System.out.println(tbc);
           mass.pop();
           mass.push(tbc);
         } else {
            mass.push(table.get(curr));
         }
         //System.out.println(mass.peek());
         newPeek = 0;
      }
      while(!mass.empty()) {
         newPeek = newPeek + mass.peek();
         mass.pop();
      }
      mass.push(newPeek);
      System.out.println(mass.peek());
   }
}
