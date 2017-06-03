import java.util.*;

public class Instruction {
   private int num;
   private int target;
   private int closest = 0;
   private ArrayList<toDo> todo = new ArrayList<toDo>();

   public void run() {
      Scanner scan = new Scanner(System.in);
      num = scan.nextInt();
      target = scan.nextInt();
      add(scan);
      closest = recursion(0,0);
      System.out.println(closest);
   }

   public int recursion(int index, int closest) {
      int curr = closest;
      
      String oper = todo.get(index).getThis();
      int numb = todo.get(index).getNum();

      if(oper.equals("+")) {
         curr = curr + numb;
      } else if(oper.equals("-")) {
         curr = curr - numb;
      } else if(oper.equals("*")) {
         curr = curr * numb;
      } else if(oper.equals("/")) {
         curr = curr / numb;
      }

      if(index + 1 >= num) {
         if(Math.abs(target - curr) < Math.abs(target - closest)) {
            closest = curr;
         }
      } else {
         int chosen = recursion(index+1, curr);
         int notChosen = recursion(index+1, closest);

         if(Math.abs(target - chosen) < Math.abs(target - notChosen)) {
            closest = chosen;
         } else {
            closest = notChosen;
         }
      }
      return closest;
   }

   public void add(Scanner s) {
      int i;

      for(i = 0; i < num; i++) {
         String temp = s.next();
         int numb = s.nextInt();

         todo.add(new toDo(temp, numb));
      }
   }
   
   public static void main(String[] args) {
      Instruction ins = new Instruction();
      ins.run();
   }
}

class toDo {
   private String doThis;
   private int number;

   public toDo(String d, int n) {
      doThis = d;
      number = n;
   }

   public String getThis() {
      return doThis;
   }

   public int getNum() {
      return number;
   }
}
