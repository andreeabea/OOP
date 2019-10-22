package l5;

public class RodentTestDrive {

	 public static void main(String[] args) 
	 {
		Rodent[] r = new Rodent[3];
		
		r[0] = new Mouse("Jerry", 145.6);
		r[1] = new Hamster("Amber", 320);
		r[2] = new Squirrel("Joe", 286.5);
		
		for(int i = 0; i < r.length; i++) 
		{
			r[i].info();
		}
		
		System.out.println("");
		
		for(int i = 0; i < r.length; i++) 
		{
			r[i].sleep();
		}
		
		System.out.println("");
		
		for(int i = 0; i < r.length; i++) 
		{
			r[i].eat();
		}
		
		System.out.println("");

	}
	
}
