public class Main {
    public static void main(String[] args) {

        // Instantiate first car using NO-ARGS constructor
        Car car1 = new Car();

        // Assign values to attributes using setter
        car1.setMake("Mitsubishi");
        car1.setModel("Xpander");
        car1.setYear(2019);

        // Instantiate a second car using PARAMETERIZED constructor
        Car car2 = new Car("Honda", "Civic Type R", 2025);

        // Call methods on both cars
        car1.carInfo();
        car2.carInfo();

    }
}