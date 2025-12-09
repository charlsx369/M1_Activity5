public abstract class Vehicle {


    private int noOfWheels;
    private String brand;

    public Vehicle() {

    }

    public void destroy() {
    }

    public void refuel() {
    }

    public Vehicle(int noOfWheels, String brand) {
        this.noOfWheels = noOfWheels;
        this.brand = brand;
    }

    abstract void startEngine();


    public void setNoOfWheels(int noOfWheels) {

        this.noOfWheels = noOfWheels;
    }

    public int getNoOfWheels() {

        return noOfWheels;
    }

    public void setBrand(String brand) {

        this.brand = brand;
    }

    public String getBrand() {

        return brand;
    }



}
