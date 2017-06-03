import java.util.*;

public class GasStation {
   private int numCity;
   private ArrayList<City> map = new ArrayList<City>();
   private int ans = 0;
   private int maxCap = 200;

   public void run() {
      Scanner scan = new Scanner(System.in);
      numCity = scan.nextInt();
      add(scan);
      recursion(0,0,200);
      System.out.println(ans);
   }

   public void recursion(int index, int cost, int cap) {
      //tbc
   }

   public void add(Scanner s) {
      int i;

      for(i = 0; i < numCity; i++) {
         map.add(new City(s.nextInt(), s.nextInt()));
      }
      map.add(new City(s.nextInt(), 0));
   }

   public static void main(String[] args) {
      GasStation gas = new GasStation();
      gas.run();
   }
}

class City {
   private int dist;
   private int cost;

   public City(int d, int c) {
      dist = d;
      cost = c;
   }

   public int getDist() {
      return dist;
   }

   public int getCost() {
      return cost;
   }
}
