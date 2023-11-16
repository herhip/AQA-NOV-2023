package org.prog;

public class Car implements ITurnable {

    public String color;
    public String engineVolume;

    public void drive() {
        System.out.println("Driving car");
        switchGear();
    }

    private void switchGear() {
        System.out.println("Switching gear");
    }

    @Override
    public void turnLeft() {
        System.out.println("Car turning left");
    }

    @Override
    public void turnRight() {
        System.out.println("Car turning right");
    }

    public void goTo(String city) {
        goTo(city, "current city");
    }

    public void goTo(String city, String fromCity) {
        goTo(city, fromCity, "no additional stops");
    }

    public void goTo(String city, String fromCity, String passingThrough) {
        goTo(city, fromCity, passingThrough, "empty");
    }

    //TODO: overload this method: add return destination
    public void goTo(String city, String fromCity, String passingThrough, String withCargo) {
        goTo(city, fromCity, passingThrough, withCargo, "not planned");
    }

    public void goTo(String city, String fromCity, String passingThrough, String withCargo, String returnDestination) {
        System.out.println("This vehicle goes to " + city + " from " + fromCity +
                " passing through " + passingThrough + " with " + withCargo + " cargo" + " and return destination is " + returnDestination);
    }

}