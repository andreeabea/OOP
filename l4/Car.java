package l3;
import java.awt.Color;
/**
*  Represents a car.
*  The attributes are speed, engine power and color.
*  The methods are accelerate, 
*  decelerate, getSpeed, getColor, getPower,
*  getAcceleration, and getMaxSpeed.
*
* @author Laboratory Team
*/
public class Car 
{
  private String brandName; 
  private int speed = 0;  // current car speed
  private Color color;
  private int power;
  private int accelerationStep=0; // speed increase when gas pedal pushed
  private int maxSpeed;  // maximum speed for this car
  private int breakPower;
  private int nbOfGears;
  public int currentGear=0;
  public static final int MIN_SPEED = 0; // minimum speed for all cars; km/h
  public static final int MAX_SPEED = 300; // speed limit on all cars; km/h
  public static final int MIN_POWER = 4; // minimum power for all cars; no less than 4 bhp
  public static final int MAX_POWER = 500; // maximum power for all cars.no more than 500 bhp
  public static final int ACCELERATION_MIN_STEP = 1; // minimum speed increase per second when gas pedal pushed
  // TODO integrate fuel tank
  private FuelTank fuelTank;
  private static final int ACCELERATION_MAX_STEP = 30; // maximum speed increase per second
  //  when gas pedal pushed
  private static final int MIN_BREAK_POWER= 20;
  private static final int MAX_BREAK_POWER= 50;
  private static final int MIN_GEARS= 4;
  private static final int MAX_GEARS= 7;
  private static final int[] MIN_SPEEDS= {0, 10, 30, 60, 90, 110, 130, 150};
  private static final int[] MAX_SPEEDS= {0, 40, 80, 120, 160, 210, 250, 300};
  private static final float ACCELERATION_RATIO= 0.003f;
  private static final float CRUISING_RATIO= 0.0007f;
  
  /**
   * Constructor to create a new Car object
   * @param brand name or manufacturer.
   * @param color color of the Car object - one of Java color constants
   * @param power engine power
   * @param accelerationStep increase in speed when gas pedal pushed
   */
  public Car(String brand, Color color, int power, int maxSpeed, int accelerationStep, int capacity, int nbOfGears, int breakPower) 
  {
     //creates a new Car object with specified brand name, color, engine power, and maximum speed
     this.brandName = brand;
     this.color = color;
     fuelTank = new FuelTank(capacity);
     
     if (power > MIN_POWER)
        this.power = power;
     else
        this.power = MIN_POWER;
     if (power < MAX_POWER)
        this.power = power;
     else
        this.power = MAX_POWER;
     if (maxSpeed < 0) this.maxSpeed = MIN_SPEED; // this car wil never move
     else 
     if (maxSpeed < MAX_SPEED) this.maxSpeed = maxSpeed;
     else maxSpeed = MAX_SPEED;
     if (power < MIN_POWER) this.power = MIN_POWER;
     else 
     if (power > MAX_POWER) this.power=MAX_POWER;
     if (accelerationStep < ACCELERATION_MIN_STEP)
        this.accelerationStep = ACCELERATION_MIN_STEP;
     else
     if (accelerationStep > ACCELERATION_MAX_STEP)
        this.accelerationStep = ACCELERATION_MIN_STEP;
     else
        this.accelerationStep = accelerationStep;
     
     if (breakPower< MIN_BREAK_POWER)
    	 this.breakPower=MIN_BREAK_POWER;
     else if (breakPower> MAX_BREAK_POWER)
    	 this.breakPower= MAX_BREAK_POWER;
     else this.breakPower=breakPower;
     
     if (nbOfGears< MIN_GEARS)
    	 this.nbOfGears= MIN_GEARS;
     else if (nbOfGears> MAX_GEARS)
    	 this.nbOfGears= MAX_GEARS;
     else this.nbOfGears= nbOfGears;
  }

  /**
   * Simulates pressing the accelerator.
   * @return the new speed
   */
  public int accelerate() 
  {
     int newSpeed = speed + accelerationStep;
     float consumptionAcc= speed*ACCELERATION_RATIO;
     float consumptionCr= speed*CRUISING_RATIO;
     float tankFuel= fuelTank.getCapacity()*fuelTank.getLevel();
     if(consumptionAcc <= tankFuel)
     {
    	 if(newSpeed <= maxSpeed) 
    	 {
    		 speed = newSpeed;
    	 }
    	 else 
    	 {
    		 speed = maxSpeed;
    	 }
    	 fuelTank.releaseFuel(consumptionAcc);
     }
     else if(consumptionAcc>tankFuel && consumptionCr<=tankFuel)
     {
    	 System.out.println("Not enough fuel to accelerate. Maintaining speed");
    	 fuelTank.releaseFuel(consumptionCr);
     }
     else
     {
    	 System.out.println("Not enough fuel. Decelerating");
    	 decelerate();
    	 tankFuel=0;
     }
     changeGear();
     return speed;
  }
  /**
   * Simulates releasing the accelerator.
   * @return the new speed
   */
  public int decelerate() 
  {
	 int newSpeed= speed - accelerationStep; 
     if(newSpeed >= MIN_SPEED) 
     {
        speed = newSpeed;
     }
     else speed= MIN_SPEED;
     
     changeGear();
     return speed;
  }
  public void changeGear()
  {
	if(currentGear< nbOfGears && speed>MAX_SPEEDS[currentGear])  
		currentGear++;
	else if(currentGear>0 && speed<MIN_SPEEDS[currentGear])
		currentGear--;
  }

  public int breaking()
  {
	  int newSpeed=decelerate()-breakPower;
	  if(newSpeed<MIN_SPEED)
		  newSpeed=MIN_SPEED;
	  else speed=newSpeed;
	  
	  changeGear();
	  return speed;
  }
  /**
   * @return the current speed
   */
  public int getSpeed() 
  {
     return speed;
  }
  /**
   * @return the max speed
   */
  public int getMaxSpeed() 
  {
     return MAX_SPEED;
  }
  /**
   * @return the color of the car
   */
  public Color getColor() 
  {
     return color;
  }
   /**
   * @return the brand name of the car
   */
  public String getBrandName() 
  {
     return brandName;
  }

  /**
   * @return the car's acceleration step
   */
  public int getAcceleration() 
  {
     return accelerationStep;
  }
  /**
   * @return the power of the car
   */
  public int getPower() 
  {
     return power;
  }
  
  public int getBreakPower()
  {
	  return breakPower;
  }
  
  public int getNbOfGears()
  {
	  return nbOfGears;
  }
  
  public int getCurrentGear()
  {
	  return currentGear;
  }
  
  public float getFuelLevel()
  {
	  return fuelTank.getLevel();
  }
  public float getFuelCapacity()
  {
	  return fuelTank.getCapacity();
  }
  // TODO: add a toString method
}
