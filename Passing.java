/**
 *  Name     :
 *  Matric No.  :
 */

import java.util.*;

public class Passing {
   private LinkedList<Player> players = new LinkedList<Player>();
   
   public static void main(String[] args) {
      Passing game = new Passing();
      game.run();
   }

   public void run() {
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      int m = scan.nextInt();
      int k = scan.nextInt();

      addP(scan, n);
      doQ(scan, m, k);
   }

   public void addP(Scanner s, int num) {
      int i;

      for(i = 0; i < num; i++) {
         String tempName = s.next();
         players.add(new Player(tempName, 0));
      }
   }

   public void doQ(Scanner s, int numT, int numP) {
      int i, j;
      int indexS = 0;
      Player head = players.get(indexS);

      for(i = 0; i < numT; i++) {
         int turns = s.nextInt();
         indexS = players.indexOf(head);
         int indexE = (turns + indexS) % (players.size());
         Player curr = players.get(indexE);

         curr.incElim();
         System.out.printf("%s\n", curr.getName());

         if(curr.getElim() >= numP) {
            players.remove(indexE);
            if(indexE == players.size()) {
               head = players.get(0);
            } else {
               head = players.get(indexE);
            }
         } else if (curr != head) {
             players.remove(indexS);
             players.add(indexS, curr);
             players.remove(indexE);
             players.add(indexE, head);
             head = curr;
         }

         //for(j = 0; j < players.size(); j++) {
          //  System.out.printf("%s\n", players.get(j).getName());
         //}
      }
   }
}

class Player {
   private String name;
   private int elim;

   public Player(String n, int e) {
      name = n;
      elim = e;
   }

   public String getName() {
      return name;
   }

   public int getElim() {
      return elim;
   }

   public void incElim() {
      elim++;
   }
}

class ListNode<E> {
   protected E element;
   protected ListNode<E> next;

   /* constructors */
   public ListNode(E item) {
      element = item;
      next = null;
   }

   public ListNode(E item, ListNode<E> n) {
      element = item;
      next = n;
   }

   /* get the next ListNode */
   public ListNode<E> getNext() {
      return this.next;
   }

   /* get the element of the ListNode */
   public E getElement() {
      return this.element;
   }

   public void setNext(ListNode<E> item) {
      this.next = item;
   }

   public void setElement(E item) {
      this.element = item;
   }
}

