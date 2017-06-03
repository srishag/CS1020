import java.util.*;

public class BarryPutter {
   private int numChambers;
   private int maxAppar;
   private Chamber[] arr;
   private int max = 0;
   public void run() {
      Scanner scan = new Scanner(System.in);
      numChambers = scan.nextInt();
      maxAppar = scan.nextInt();
      arr = new Chamber[numChambers];

      add(scan);
      recursion(0,0,0);
      System.out.println(max);
   }

   public int recursion(int start, int gold, int leave) {
      int curr, total = 0;
      //this chamber does not exist
      if(start >= numChambers) {
         leave--;
      } //this is the last chamber you can go to  
      else if(leave >= maxAppar) {
         gold = arr[start].getGold() + gold;

         if(gold > max) {
            max = gold;
         }
      } //continue collecting gold
      else {
         gold = arr[start].getGold() + gold;
         int ways = arr[start].getWays();
         int[] out = arr[start].getLeave();
         int i;

         for(i = 0; i < ways; i++) {
            total = recursion(start+out[i], gold, leave+1); 

            if(total > max) {
               max = total;
            }
         }
      }
      return max;
   }

   public void add(Scanner s) {
      int i, j = 0;

      for(i = 0; i < numChambers; i++) {
         int name = s.nextInt();
         int gold = s.nextInt();
         int ways = s.nextInt();
         int[] leave = new int[ways];

         for(j = 0; j < ways; j++) {
            leave[j] = s.nextInt();
         }
         
         arr[i] = new Chamber(name, gold, ways, leave);
      }
   }
   
   public static void main(String[] args) {
      BarryPutter barry = new BarryPutter();
      barry.run();
   }
}

class Chamber {
   private int name;
   private int gold;
   private int ways;
   private int[] leave;

   public Chamber(int n, int g, int w, int[] l) {
      name = n;
      gold = g;
      ways = w;
      leave = new int[ways];
      leave = l;
   }

   public int getName() {
      return name;
   }

   public int getGold() {
      return gold;
   }

   public int getWays() {
      return ways;
   }

   public int[] getLeave() {
      return leave;
   }
}
