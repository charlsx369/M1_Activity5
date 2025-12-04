public class Car {

    // --- Attributes (fields)
    private String make;
    private String model;
    private int year;

    // --- No-args constructor ---
    public Car() {
        this.make = "Unknown";
        this.model = "Unknown";
        this.year = 0;
    }

    // --- Parameterized constructor ---
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // --- A method ---
    public void carInfo() {
        System.out.println("Make: " + make);
        System.out.println("Model:" + model);
        System.out.println("Year Model : " + year + "\n");
    }

    // --- Setters ---
    public void setMake(String make) {

        this.make = make;
    }
    public void setModel(String model)  {

        this.model = model;
    }
    public void setYear(int year) {

        this.year = year;
    }

    // --- Getters ---
    public String getMake() {

        return make;
    }
    public String getModel() {

        return model;
    }
    public int getYear() {

     return year;

    }

}
