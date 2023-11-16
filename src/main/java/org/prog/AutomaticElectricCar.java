package org.prog;

//my homework
public class AutomaticElectricCar extends ElectricCar implements IMovable{
    public void switchGearsAutomat() {
        System.out.println("Automatic electric car switch gear automatically");
    }

    @Override
    public void moveForward() {
        System.out.println("Automatic electric car is moving forward");
    }

    @Override
    public void moveBackward() {
        System.out.println("Automatic electric car is moving backward");

    }
}
