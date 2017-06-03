import java.util.*;

public class Alice {
   private Stack<Integer> s = new Stack<Integer>();
   private Queue<Integer> q = new LinkedList<Integer>();

   public static void main(String[] args) {
      Alice alice = new Alice();
      alice.run();
   }

   public void run() {
      Scanner scan = new Scanner(System.in);
      int num = scan.nextInt();
      addPancake(num);
      int numQuery = scan.nextInt();
      doQ(scan, numQuery);
   }

   public void doQ(Scanner ss, int num) {
      int i, j;
      int tru = 1, fal = 0;
      int sum = 0;

      for(i = 0; i < num; i++) {
         String query = ss.next();

         if(query.equals("FLIP")) {
            int numFlip = ss.nextInt();
            
            for(j = 0; j < numFlip; j++) {
               q.offer(s.pop());
               q.offer(s.pop());
            }

            if(!s.empty()) {
               int b = q.peek();
               if(b == 1) {
                  s.pop();
                  s.push(b);
               }
            }
            while(q.size() > 0) {
               s.push(q.poll());
            }
            s.pop();
            s.push(tru);
         } else if(query.equals("ADD")) {
            s.push(s.peek());
            s.push(fal);
         } else if(query.equals("COUNT")) {
            sum = 0;
            Stack<Integer> temp = new Stack<Integer>();
            while(!s.empty()) {
               temp.push(s.pop());
            }
            while(!temp.empty()) {
               s.push(temp.pop());
               int a = s.peek();
               s.push(temp.pop());
               int b = s.peek();
               if(a == 1 || b == 1) {
                  sum++;
               }
            }
            System.out.println(sum);
         }
      }
   }

   public void addPancake(int num) {
      int i;
      int temp = 0;

      for(i = 0; i < num; i++) {
         s.push(temp);      
         s.push(temp);      
      }
   }

}
