package l6;

interface FastFood {
	public int command();
	public void hasCheese();
}

class Meal  {   
	Meal() { System.out.println("Meal()"); } 
} 
class Bread  {
	Bread() { System.out.println("Bread()"); } 
} 
class Cheese  { 
	Cheese() { System.out.println("Cheese()"); }
} 
class Lettuce  {   
	Lettuce() { System.out.println("Lettuce()"); } 
} 
class Lunch extends Meal  {
	Lunch() { System.out.println("Lunch()"); } 
}
class PortableLunch extends Lunch  {  
	PortableLunch() { System.out.println("PortableLunch()");} 
} 
public class Sandwich extends PortableLunch implements FastFood  {  
	private Bread b = new Bread();  
	private Cheese c = new Cheese(); 
	private Lettuce l = new Lettuce();
	public Sandwich(){
		System.out.println("Sandwich()");  
	}   
	public static void main(String[] args)  
	{   
		Sandwich s = new Sandwich();
		s.command();
		s.hasCheese();
		
	} 
	public int command()
	{
		System.out.println("Command a sandwich. The sandwich has: ");
		return 1;
	}
	public void hasCheese()
	{
		System.out.println("cheese");
	}
}
