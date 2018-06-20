
import java.util.Random;
import java.util.Scanner;

public class dice {

	int sides;
	String output;
	
	public dice(int sides){
		this.sides = sides;
	}
		
	public String Roll(){
		Random rn = new Random();
		String coin[]= {"head","tail"};
		String dices6[]= {"one","two","three","four","five","six"};
		String dices4[]= {"one","two","three","four"};
		
		if(this.sides==2)
		{
			int output = rn.nextInt(this.sides);
			return coin[output];
		}
		
		if(this.sides==4)
		{
			int output = rn.nextInt(this.sides);
			return dices4[output];
		}
	else
	{
		int output = rn.nextInt(this.sides);
		return dices6[output];
	}
	}
	
	public static void main(String[] args) 
	{  
		System.out.println("enter the number of sides");
		Scanner sc = new Scanner(System.in);
		int sides=sc.nextInt();
		dice ob = new dice(sides);
		System.out.println("dice number is" + " " + ob.Roll());
	}


}