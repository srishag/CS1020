import java.util.*;
import java.util.LinkedList;

public class Classroom {
   private LinkedList<String> students = new LinkedList<String>();

   public static void main(String[] args) {
      Classroom student = new Classroom();
      student.run();
   }

   public void run() {
      Scanner scan = new Scanner(System.in);
      int q = scan.nextInt();
      doQ(scan, q);
   }

   public void doQ(Scanner s, int num) {
      int i, j;

      for(i = 0; i < num; i++) {
         String query = s.next();
         if(query.equals("enter")) {
            String temp1 = s.next();
            String temp2 = s.next();
            int k = s.nextInt();

            if(i == 0) {
               students.add(temp2);
            }
            
            int index = students.indexOf(temp2);

            if(k == 0) {
               students.add(index+1, temp1);
            } else {
               if(index < (students.size() - k)) {
                  students.add(index+1+k, temp1);
               } else {
                  students.add(k, temp1);
               }
            }
         } else if(query.equals("leave")) {
            String tempName = s.next();

            for(j = 0; j < students.size(); j++) {
               if(students.get(j).equals(tempName)) {
                  students.remove(j);
                  break;
               }
            }
         } else if(query.equals("list")) {
            for(j = 0; j < students.size(); j++) {
               if(j != (students.size() - 1)) {
                  System.out.printf("%s ", students.get(j));
               } else {
                  System.out.printf("%s\n", students.get(j));
               }
            }
         }

        /* for(j = 0; j < students.size(); j++) {
            System.out.println(students.get(j));
         } */
      }
   }
}
