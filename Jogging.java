import java.util.*;

public class Jogging {
   private int target;
   private ArrayList<Integer> go = new ArrayList<Integer>();

   public void run() {
      Scanner scan = new Scanner(System.in);
      target = scan.nextInt();
      int parts = scan.nextInt();

      doQ(scan, parts);
      System.out.println(recursion(0,0));
   }

   public void doQ(Scanner s, int parts) {
      int up = s.nextInt();
      int flat = s.nextInt();
      int down = s.nextInt();

      int i;
      int count = 0;

      for(i = 0; i < parts; i++) {
         String type = s.next();

         if(type.equals("u") || type.equals("d")) {
            go.add(up+down);
         } else if(type.equals("f")) {
            go.add(flat+flat);
         }
      }
   }

   public int recursion(int num, int count) {
      target = target - go.get(num);

      if(target <= 0) {
         return count;
      } else {
         int total = recursion(num+1, count+1);
         return total;
      }
   }

   public static void main(String[] args) {
      Jogging jog = new Jogging();
      jog.run();
   }
}
