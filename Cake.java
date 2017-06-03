/**
* Name: srishti aggarwal
* Matric no: A0157006M
*/

import java.util.*;

public class Cake {
   private Queue<Slice> cake = new LinkedList<Slice>();

   public static void main(String[] args) {
      Cake cake = new Cake();
      cake.run();
   }

   public void run() {
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      int k = scan.nextInt();
      doQ(scan, n, k);
   }

   public void doQ(Scanner s, int num, int max) {
      int i;
      int k = 0;
      int choc = 0, ans = 0;

      for(i = 0; i < num; i++) {
         char check = s.next().charAt(0);
         int idk = s.nextInt();

         if(check == 'C') {
            Slice slice = new Slice(idk, 0);
            cake.offer(slice);
         } else {
            if(k == max) {
               while(cake.peek().getRais() != 1) {
                  choc = choc - cake.peek().getChoc();
                  cake.poll();
               }
               choc = choc - cake.peek().getChoc();
               cake.poll();
               k--;
               Slice slice = new Slice(idk, 1);
               cake.offer(slice);
               k++;
            } else {
               Slice slice = new Slice(idk, 1);
               cake.offer(slice);
               k++;
            }
         }
         choc = choc + idk;
         if(choc > ans) {
            ans = choc;
         }
      }
      System.out.println(ans);
   }
}

class Slice {
   private int choc;
   private int rais;

   public Slice(int c, int r) {
      choc = c;
      rais = r;
   }

   public int getChoc() {
      return choc;
   }

   public int getRais() {
      return rais;
   }
}
