public class Truck extends Vehicle implements Refuelable {


    public Truck(int noOfWheels, String brand ) {
        this.setNoOfWheels(noOfWheels);
        this.setBrand(brand);
    }

    @Override
    public void startEngine() {
        System.out.println("The Car Brand " + getBrand() + "'s engine is starting...");
    }

    @Override
    public void refuel(){
        System.out.println("The " + getNoOfWheels() + " Wheeler "
                + getBrand() + " has been refueled");
    }

    public void destroy(){
        System.out.println("The Car Brand " + getBrand() + " is Destroyed!");

    }
}
