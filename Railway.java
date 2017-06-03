import java.util.*;

public class Railway {
   private Queue<Integer> orig = new LinkedList<Integer>();
   private Stack<Integer> temp = new Stack<Integer>();
   private Queue<Integer> dest = new LinkedList<Integer>();

   public void run() {
      Scanner scan = new Scanner(System.in);
      int numCoach = scan.nextInt();
      scan.nextLine();
      if(numCoach != 0) {
         addCoach(numCoach);
         int numPerm = scan.nextInt();
         scan.nextLine();
         doQ(scan, numPerm, numCoach);
      }
   }

   public void addCoach(int num) {
      int i;

      for(i = 1; i <= num; i++) {
         orig.offer(i);
      }
   }

   public void doQ(Scanner s, int perm, int coach) {
      int i, j;

      for(i = 0; i < perm; i++) {
         for(j = 0; j < coach; j++) {
            dest.offer(s.nextInt());

            int peek = orig.peek();
            temp.push(peek);
            orig.poll();

            while(temp.size() != 0 && temp.peek() == dest.peek()) {
               dest.poll();
               temp.pop();
            }
         }
         if(temp.size() != 0) {
            System.out.println("No");
         } else {  
            System.out.println("Yes");
         }
         
         for(j = 1; j <= coach; j++) {
            orig.offer(j);
         }

      }
   }

   public static void main(String[] args) {
      Railway rail = new Railway();
      rail.run();
   }
}
