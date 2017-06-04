/**
* Name        :
* Matric. No  :
* PLab Acct.  :
*/

import java.util.*;

public class Subway {
   private LinkedList<String> subway = new LinkedList<String>();

   public void run() {
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      add(scan, n);
      int q = scan.nextInt();
      doQ(scan, q);
   }

   public void add(Scanner s, int num) {
      int i;

      for(i = 0; i < num; i++) {
         String tempName = s.next();
         subway.add(tempName);
      }
   }

   public void doQ(Scanner s, int num) {
      int i;

      for(i = 0; i < num; i++) {
         String query = s.next();

         if(query.equals("TIME")) {
            String start = s.next();
            String end = s.next();
            
            int indexS = subway.indexOf(start);
            int indexE = subway.indexOf(end);
            int j;
            int countS = 1, count = 0;
            
            //starts and ends at same station
            if (indexE == indexS) {
               count = 0;
            } //goes from first station to last station 
            else if (indexE == (subway.size() - 1) && indexS == 0) {
               count = 2;
            } //goes from last station to first station 
            else if (indexE == 0 && indexS == (subway.size() - 1)) {
               count = 2;
            } //travels clockwise from start to end station 
            else if (indexE > indexS && (indexE - indexS) <= (subway.size() - indexE + indexS)) {
               for(j = indexS; j < indexE; j++) {
                  count += 2;
               }
               count = count + countS*(indexE - indexS - 1);
            } //travels anticlockwise from start to end station 
            else if (indexE < indexS && (indexS - indexE) <= (subway.size() - indexS + indexE)) {
               for(j = indexS; j > indexE; j--) {
                  count += 2;
               }
               count = count + countS*(indexS - indexE - 1);
            } //goes to start then to last to the end station 
            else if (indexE > indexS && (indexE - indexS) > (subway.size() - indexE + indexS)) {
               for(j = indexS; j >= 0; j--) {
                  count += 2;
               }
               for(j = subway.size() - 1; j > indexE; j--) {
                  count += 2;
               }
               count = count + countS*(subway.size() - 1 - indexE + indexS);
            } //goes to last then to first to the end station
            else if (indexE < indexS && (indexS - indexE) > (subway.size() - indexS + indexE)) {
               for(j = indexS; j < subway.size(); j++) {
                  count += 2;
               }
               for(j = 0; j < indexE; j++) {
                  count += 2;
               }
               count = count + countS*(subway.size() - 1 - indexS + indexE);
            }
            System.out.println(count);
         } else if(query.equals("BUILD")) {
            String prev = s.next();
            String next = s.next();

            subway.add(subway.indexOf(prev) + 1, next);
            System.out.printf("station %s has been built\n", next);
         } else if(query.equals("PATH")) {
            String start = s.next();
            String end = s.next();

            int indexS = subway.indexOf(start);
            int indexE = subway.indexOf(end);
            int j;

            //starts and ends at same station
            if (indexE == indexS) {
               System.out.println(start);
            } //goes from first station to last station 
            else if (indexE == (subway.size() - 1) && indexS == 0) {
               System.out.printf("%s ", start);
               System.out.println(end);
            } //goes from last station to first station 
            else if (indexE == 0 && indexS == (subway.size() - 1)) {
               System.out.printf("%s ", start);
               System.out.println(end);
            } //travels clockwise from start to end station 
            else if (indexE > indexS && (indexE - indexS) <= (subway.size() - indexE + indexS)) {
               for(j = indexS; j <= indexE; j++) {
                  if (j == indexE) {
                     System.out.println(end);
                  } else {
                     System.out.printf("%s ", subway.get(j));
                  }
               }
            } //travels anticlockwise from start to end station 
            else if (indexE < indexS && (indexS - indexE) < (subway.size() - indexS + indexE)) {
               for(j = indexS; j >= indexE; j--) {
                  if (j == indexE) {
                     System.out.println(end);
                  } else {
                     System.out.printf("%s ", subway.get(j));
                  }
               }
            } //goes to start then to last to the end station 
            else if (indexE > indexS && (indexE - indexS) > (subway.size() - indexE + indexS)) {
               for(j = indexS; j >= 0; j--) {
                  System.out.printf("%s ", subway.get(j));
               }
               for(j = subway.size() - 1; j >= indexE; j--) {
                  if (j == indexE) {
                     System.out.println(end);
                  } else {
                     System.out.printf("%s ", subway.get(j));
                  }
               }
            } //goes to last then to first to the end station
            else if (indexE < indexS && (indexS - indexE) >= (subway.size() - indexS + indexE)) {
               for(j = indexS; j <= (subway.size() - 1); j++) {
                  System.out.printf("%s ", subway.get(j));
               }
               for(j = 0; j <= indexE; j++) {
                  if (j == indexE) {
                     System.out.println(end);
                  } else {
                     System.out.printf("%s ", subway.get(j));
                  }
               }
            }
         } else if(query.equals("PRINT")) {
            int k;
            String start1 = s.next();
            int indexT = subway.indexOf(start1);
            for(k = indexT; k < subway.size(); k++) {
               if(k == (subway.size()-1)) {
                  System.out.printf("%s", subway.get(k));
               } else {
                  System.out.printf("%s ", subway.get(k));
               }
            }
            if(indexT != 0) {
               for(k = 0; k < indexT; k++) {
                  System.out.printf(" %s", subway.get(k));
               }
            }
            System.out.println();
         } 
      }
   }

   public static void main(String[] args) {
      Subway newSubwayNetwork = new Subway();
      newSubwayNetwork.run();
   }
}

class DoublyLinkedList<E> {

   //Data attributes
   private ListNode<E> head;
   private ListNode<E> tail;
   private int size;

   public DoublyLinkedList() {
      this.head = null;
      this.tail = null;
      this.size = 0;
   }

   // returns the size of the linked list
   public int size() {
      return this.size;
   }

   // returns true if the list is empty, false otherwise
   public boolean isEmpty() {
      return this.size == 0;
   }

   // adds the specified element to the beginning of the list
   public void addFirst(E element) {
      ListNode<E> newNode = new ListNode<E>(element);

      if (size == 0) {
         this.head = newNode;
         this.tail = this.head;
      } else {
         ListNode<E> oldHead = this.head;
         this.head = newNode;
         newNode.setNext(oldHead);
         oldHead.setPrev(newNode);
      }

      this.size++;
   }

   // retrieves the first element of the list
   public E getFirst() throws NoSuchElementException {
      if (head == null) {
         throw new NoSuchElementException("Cannot get from an empty list");
      } else {
         return head.getElement();
      }
   }

   // returns true if the list contains the element, false otherwise
   public boolean contains(E element) {
      for (ListNode<E> current = head; current != null; current = current.getNext()) {
         if (current.getElement().equals(element)) {
            return true;
         }
      }

      return false;
   }

   // removes the first element in the list
   public E removeFirst() throws NoSuchElementException {
      if (head == null) {
         throw new NoSuchElementException("Cannot remove from an empty list");
      } else {
         ListNode<E> currentHead = head;
         head = head.getNext();
         if (head == null) {
            tail = null;
         } else {
            head.setPrev(null);
         }
         this.size--;
         return currentHead.getElement();
      }
   }

   // Returns reference to first node.
   public ListNode<E> getHead() {
      return this.head;
   }

   // Returns reference to last node of list.
   public ListNode<E> getTail() {
      return this.tail;
   }

}

class ListNode<E> {
   private E element;
   private ListNode<E> next;
   private ListNode<E> prev;

   public ListNode(E newElement) {
      this.element = newElement;
      this.next = null;
      this.prev = null;
   }

   public void setElement(E newElement) {
      this.element = newElement;
   }

   public E getElement() {
      return this.element;
   }

   public void setPrev(ListNode<E> previous) {
      this.prev = previous;
   }

   public void setNext(ListNode<E> next) {
      this.next = next;
   }

   public ListNode<E> getNext() {
      return next;
   }

   public ListNode<E> getPrev() {
      return prev;
   }
}


