/**
* Name       : srishti aggarwal
* Matric No.  : A0157006M
* PLab Acct. :
*/

import java.util.*;

public class Radiation {
   private Stack<Element> stack = new Stack<Element>();
   
   public void run() {
      // implement your "main" method here...
      Scanner scan = new Scanner(System.in);
      int num = scan.nextInt();
      doQ(scan, num);
   }

   public void doQ(Scanner s, int num) {
      int i;
      int prev = 0;
      int maxYears = 0;

      for(i = 0; i < num; i++) {
         int strength = s.nextInt();
         Element curr = new Element(strength, 0);

         if(stack.empty()) {
            stack.push(curr);
         } else if(stack.peek().getStrength() >= strength) {
            while(!stack.empty() && stack.peek().getStrength() >= strength) {
               if(stack.peek().getYearsBeforeDecay() > prev) {
                  prev = stack.peek().getYearsBeforeDecay();
               }
               stack.pop();
            }
            if(stack.empty()) {
               stack.push(curr);
            } else {
               curr.setYearsBeforeDecay(prev+1);
               stack.push(curr);
            }
            prev = 0;
         } else {
            curr.setYearsBeforeDecay(1);
            stack.push(curr);
         }
         if(curr.getYearsBeforeDecay() > maxYears) {
            maxYears = curr.getYearsBeforeDecay();
         }
         //System.out.println(curr.getYearsBeforeDecay());
      }
      System.out.println(maxYears);
   }

   public static void main(String[] args) {
      Radiation myChemicalElements = new Radiation();
      myChemicalElements.run();
   }
}

// hint for O(N) solution...
class Element {
   private int strength;
   private int yearsBeforeDecay;

   public Element(int strength, int yearsBeforeDecay) {
      this.strength = strength;
      this.yearsBeforeDecay = yearsBeforeDecay;
   }

   public int getStrength() {
      return this.strength;
   }

   public int getYearsBeforeDecay() {
      return this.yearsBeforeDecay;
   }

   public void setYearsBeforeDecay(int num) {
      yearsBeforeDecay = num;
   }
}


