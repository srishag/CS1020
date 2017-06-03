import java.util.Scanner;

class approxpi {
   public static void main(String[] args) {
      System.out.print("Number of terms to be used:");
      Scanner terms = new Scanner(System.in);
      int nterms = terms.nextInt();
      int i, count = 1;
      double pi = 0.0;

      for(i = 1; i <= nterms; i++) {
         pi = (count*(4.0/(2*i - 1))) + pi;
         count = count*-1;
      }

      System.out.printf("approx of pi: 2%2\n");
   }
}
