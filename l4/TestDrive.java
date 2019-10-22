package l3;
import java.awt.Color;
import java.util.*;
/**
 * TestDrive demonstrates creating and calling 
 * methods on Car  object. 
 *
 * @author Laboratory Team
 */
public class TestDrive 
{
    Car cars[];
    /**
     * Default number of cars in a test drive
     */
    public static final int NUM_CARS=5;
    /**
     * Constuctor for class TestDrive
     * makes a test drive for NUM_CARS cars
     */
    TestDrive()
    {
        this(NUM_CARS);
    }

    /**
     * Constuctor for class TestDrive
     * makes a test drive for numCars cars
     * @param numCars number of cars in atest drive
     */

    TestDrive(int numCars)
    {
        if (numCars > 0)
            cars = new Car[numCars];
        else
            cars = new Car[NUM_CARS];
    }
    //The Java virtual machine (JVM) always starts 
    //execution with the 'main' method of the class passed
    //as a argument to the java command
    public static void main(String []args) 
    {
        TestDrive td = new TestDrive();
        td.start();
        //exit TestDrive
    }
    public void start()
    {
    	int i=0;
        //Create a Volkswagen beetle Car
        Car beetle = new Car("Volskwagen Beetle", Color.orange, 80, 160, 10, 60, 5, 120);
        cars[i++]=beetle;
        //Take it for a drive
        //System.out.println("Starting beetle test drive!");
        //driveCar(beetle);
        //Create a Ferrari
        Car ferrari = new Car("Ferrari Testarosa", Color.red, 300, 280, 30, 100, 7, 100);
        cars[i++]=ferrari;
        //Take it for a drive
        //System.out.println("Starting ferrari test drive!");
        //driveCar(ferrari);
        
        Car bmv = new Car("Bmv 3rd series", Color.gray, 250, 270, 25, 50, 6, 130);
        cars[i++]=bmv;
        //System.out.println("Starting bmv 3rd series test drive!");
        //driveCar(bmv);
        
        Car ford = new Car("Ford", Color.blue, 200, 180, 25, 70, 5, 110);
        cars[i++]=ford;
        //System.out.println("Starting ford test drive!");
        //driveCar(ford);
        Car c= null;
        driveCar(c);
    }
    /**
     * Factory method to create a Car object with valid parameters
     * @param brand name or manufacturer.
     * @param color color of the Car object - one of Java color constants
     * @param power engine power
     * @param accelerationStep increase in speed when gas pedal pushed
     */
    private Car createCar(String brand, Color color, int power, int maxSpeed, int accelerationStep, int capacity, int nbOfGears, int breakPower)
    {
    	if(brand.isEmpty())
    	{
    		System.out.println("Invalid name. Setting the default configured car...");
    		brand="Volkswagen";
    	}
        // TODO validate parameters. If wrong, then give message and create a default configured car
        Car c = new Car(brand, color, power, maxSpeed, accelerationStep, capacity, nbOfGears, breakPower);
        return c;
    }
    /**
     * Displays a list of known cars (kept in the Cars array)
     * and allows user to select one using a text-based menu
     * @return a reference to a car from the array 
     */
    private Car selectCar() {
		// TODO
		Scanner in= new Scanner(System.in);
		int i=in.nextInt();
		//in.close();
		if(i>=0 && i<cars.length-1)
			{
			System.out.println(cars[i].getBrandName());
			return cars[i];
			}
		else {
			System.out.println("Invalid carID");
			return null;
		}
	}
    private Color getColor(String s)
    {
    	Color c;
    	switch(s)
    	{
    	case "red": c= Color.red;
    	break;
    	case "blue": c= Color.blue;
    	break;
    	case "black": c= Color.black;
    	break;
    	case "gray": c= Color.gray;
    	break;
    	case "white": c= Color.white;
    	break;
    	default : c=Color.black;
        break;
    	}
    	return c;
    }
    /**
     * Asks for user input for a car identificated by carId
     * and shows the effect of controlling it
     * @param carId id of car; noinnegative integer
     */
    private void driveCar(Car c) 
    {
    	int i;
		for(i=0;i<cars.length-1;i++)
			System.out.println(cars[i].getBrandName());
        // TODO: change to get input from the user
    	Scanner in= new Scanner(System.in);
        // TODO: show effect of commands from user
        // former contents
    	System.out.println("Use another car? yes/no");
    	String cmd= in.nextLine();
   
    	if(cmd.equals("yes"))
    	{
    		System.out.println("Add a new car: ");
    		String brand = in.next();
    		in.nextLine();
        	String col= in.next();
        	Color color= getColor(col);
        	in.nextLine();
        	int power= in.nextInt();
        	int maxSpeed= in.nextInt();
        	int accStep = in.nextInt();
        	int cap= in.nextInt();
        	int nbGears= in.nextInt();
        	int breakPow= in.nextInt();
    		c=createCar(brand,color,power,maxSpeed,accStep,cap,nbGears,breakPow);
    	}
    	else if(cmd.equals("no"))
    		c=selectCar();
    	else
    	{
    		System.out.println("No car chosen. Can't start the test drive.");
    		return;
    	}
    	System.out.println("Starting "+c.getBrandName()+" test drive!");
    	System.out.print("Car is a " + c.getBrandName());
   		System.out.println(" colored  " + c.getColor());
   		System.out.print("\t engine power is " + c.getPower());
   		System.out.println(" speeding step is " +c.getAcceleration());
        //press the accelerator 15 "times"
        for(i = 0; i < 15; i++) {
            System.out.println("accelerating: " + c.accelerate() + "; current gear: " + c.currentGear+"; remaining fuel: " + c.getFuelLevel());
        }
        System.out.println("breaking: " + c.breaking() + "; current gear: " + c.currentGear+"; remaining fuel: " + c.getFuelLevel());
        //release the accelerator 5 "times"
        for(i = 0; i < 5; i++) {
            System.out.println("decelerating: " + c.decelerate() + "; current gear: " + c.currentGear+"; remaining fuel: " + c.getFuelLevel());
        }
        System.out.println("final cruising speed: " + c.getSpeed());
    }
    /**
     * Provides for controlling what operation to be performed
     * createCar, selectCar, driveCar
     * TODO: decide on parameters and return value
     */
    
}

