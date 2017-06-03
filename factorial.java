import java.util.Scanner;

class factorial {

   public static int factorial(int n) {
      if(n == 0) {
         return 1;
      } else {
         return (n*factorial(n-1));
      }
   }

   public static void main(String[] args) {
      System.out.print("Enter a positive value:");
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();

      System.out.printf("The factorial of %d is %d\n", n, factorial(n));
   }
}
