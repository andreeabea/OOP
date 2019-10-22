package l6;

import l6interf.Car;

public class T1 implements Car {

	public static void main(String args[])
	{
		String name="Volkswagen";
		int speed=100;
		T1 car= new T1();
		car.printCar(name,speed);
		speed=car.accelerate(speed);
		speed=car.accelerate(speed);
		car.printCar(name,speed);
		speed=car.decelerate(speed);
		car.printCar(name,speed);
	}
	
	public int accelerate(int speed) {
		speed+=10;
		return speed;
	}

	public int decelerate(int speed) {
		speed-=10;
		return speed;
	}

	public void printCar(String name, int speed) {
		System.out.println(name+" "+speed);
	}
}
