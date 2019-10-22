package l5;
public class Dog extends Animal {
	
	public void sleeps() 
	{
		System.out.println("Dog is sleeping");
	}

	public static void doesSomething() 
	{
		Animal Fluffy = new Dog();
	//	((Dog)Fluffy).sleeps();  // not an abstract method
		Fluffy.sleeps();
		System.out.println("Dog does something");
	}
	
	public static void main(String[] args)
	{
		Dog.doesSomething();
	}
	
}
