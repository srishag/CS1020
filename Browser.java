import java.util.*;
import java.util.LinkedList;

public class Browser {
   private LinkedList<String> tabs = new LinkedList<String>();
   private String def = "http://www.comp.nus.edu.sg";
   
   public static void main(String[] args) {
      Browser browser = new Browser();
      browser.run();
   }

   public void run() {
      Scanner scan = new Scanner(System.in);
      int q = scan.nextInt();
      tabs.add(0, def);
      doQ(scan, q);
   }

   public void doQ(Scanner s, int num) {
      int i, j;
      int curr = 0;


      for(i = 0; i < num; i++) {
         String query = s.next();

         if(query.equals("NEWTAB")) {
            tabs.add(curr+1, def);
         } else if(query.equals("CLOSETAB")) {
            tabs.remove(curr);
            if(curr == tabs.size()) {
               curr--;
            }
         } else if(query.equals("NEXTTAB")) {
            if(curr != (tabs.size() - 1)) {
               curr++;
            }
         } else if(query.equals("PREVTAB")) {
            if(curr != 0) {
               curr--;
            }
         } else if(query.equals("OPENHERE")) {
            String url = s.next();
            tabs.remove(curr);
            tabs.add(curr, url);
         } else if(query.equals("OPENNEW")) {
            String url = s.next();
            tabs.add(curr+1, url);
         }
         
         System.out.println(tabs.get(curr));
    /*     for(j = 0; j < tabs.size(); j++) {
            System.out.println(tabs.get(j));
         } */
      }
   }
}
