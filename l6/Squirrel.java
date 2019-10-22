package l5;
public class Squirrel extends Rodent {
	
	
	Squirrel(String s_name, double weight)
	{
		super(s_name, weight);
	}
	
	void eat()
	{
		System.out.println("Squirrel " + super.name + " is eating");
	}
	
	void sleep() 
	{
		System.out.println("Squirrel " + super.name + " is sleeping");
	}
	
	void info() 
	{
		System.out.println("Squirrel's name is " + super.name + " and it weights " + super.weight + " grams");
	}

}
