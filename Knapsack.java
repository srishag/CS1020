import java.util.*;

public class Knapsack {
   private int numShop;
   private int maxCap;
   private int ans = 0;
   private ArrayList<Integer> arr = new ArrayList<Integer>();

   public void run() {
      Scanner scan = new Scanner(System.in);
      numShop = scan.nextInt();
      maxCap = scan.nextInt();
      add(scan);
      ans = recursion(0,0);
      System.out.println(ans);
   }

   public int recursion(int index, int cap) {
      int result = 0;
      if(index < arr.size()) {
         result += recursion(index+1, cap + arr.get(index));
         result += recursion(index+1, cap);
      } else if(cap <= maxCap) {
         result++;
      }
      return result;
   }

   public void add(Scanner s) {
      int i;

      for(i = 0; i < numShop; i++) {
         arr.add(s.nextInt());
      }
   }

   public static void main(String[] args) {
      Knapsack sack = new Knapsack();
      sack.run();
   }
}
