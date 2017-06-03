
import java.util.*;

public class colouredBalls {

	private Queue<Ball> queue = new LinkedList<Ball>();	
	private HashMap<Integer,Integer> hash = new HashMap<>();
	private int min=0; // to store the min price for minColors of ball
	private int Absmin=0; // to store the absolute min price
	private int minColors; // to store the minimum number of balls
	
	private void doQuer(Scanner scan, int num)
	{	
		int diffColors = 0; // to keep track on the number of different color balls
		for(int i=0;i<num;i++){
			Ball curr = new Ball(scan.nextInt(),scan.nextInt());
			// if queue is empty, just add the ball and increment the color and min price
			// indicate that the color has been added into the hashmap
			if(queue.size()==0){
				queue.offer(curr);
				diffColors++;
				min+=curr.getPrice();
				hash.put(curr.getColor(),1);
			}
			//if the top and end of the queue got the same color, then we remove the first
			// and add the second
			// change the value of min respectively
			else if(curr.getColor()==queue.peek().getColor())
			{
				min-=queue.peek().getPrice();
				queue.poll();
				queue.offer(curr);
				min+=curr.getPrice();
			}
			// as long as the color is already present, just add the ball and increament the min and hashmap
			else if(hash.get(curr.getColor())!=null)
			{
				int temp = hash.get(curr.getColor());
				hash.remove(curr.getColor());
				hash.put(curr.getColor(),temp+1);
				queue.offer(curr);
				min+=curr.getPrice();
			}
			
			// if color not present, and still able to add differernt color balls,
			// increase the different balls and increase the min and update hashmap
			// offer to the queue
			else if(diffColors<minColors )
			{
					diffColors++;
					queue.offer(curr);
					min+=curr.getPrice();
					hash.put(curr.getColor(),1);

			}
			
			// if minColors is reached and we need to add another ball that is of different color,
			// we have to keep removing balls from the front till there is space to add more
			// then update hashmap and min
			else if(diffColors>=minColors)
			{
				Ball x = queue.peek();
				while(diffColors>=minColors)
				{
					int temp = hash.get(x.getColor());
					hash.remove(x.getColor());
					if(temp>1)
						hash.put(x.getColor(), temp-1);
					else
						diffColors--;
					min-=x.getPrice();
					queue.poll();
					x = queue.peek();
				}
				diffColors++;
				queue.offer(curr);
				min+=curr.getPrice();
				hash.put(curr.getColor(),1);
				//System.out.println(minColors + " : " + diffColors);
				x = queue.peek();
				while(diffColors==minColors)
				{
					if(hash.get(x.getColor())>1)
					{
						int temp = hash.get(x.getColor());
						hash.remove(x.getColor());
						hash.put(x.getColor(),temp-1);
						queue.poll();
						min-=x.getPrice();
					}
					else
						break;
					x = queue.peek();
				}
			}
			// if the minColors is reached then update the Absmin
			if(diffColors==minColors)
			{
				if(Absmin==0)
					Absmin = min;
				else if(min<Absmin)
					Absmin =min;
			}
		}
	}
	
	public void run()
	{
		Scanner scan = new Scanner(System.in);
		int numBall = scan.nextInt();
		minColors = scan.nextInt();
		doQuer(scan,numBall);
		System.out.println(Absmin);
	}
	
	public static void main(String args[])
	{
		colouredBalls ball = new colouredBalls();
		ball.run();
	}
}

class Ball{
	private int color;
	private int price;
	
	public Ball(int p, int c)
	{
		price = p;
		color = c;
	}
	public int getColor()
	{
		return color;
	}
	public int getPrice()
	{
		return price;
	}
}