
public class Main {
    public static void main(String[] args) {

        Vehicle car = new Car(4, "Mitsubishi");
        Vehicle truck = new Truck(16, "Scania");

        car.startEngine();
        refuelVehicle(car);
        System.out.println(" ");

        truck.startEngine();
        refuelVehicle(truck);

        System.out.println(" ");

        destroyVehicle(car);
        destroyVehicle(truck);

    }
        private static void refuelVehicle(Vehicle refuelVehicle) {
            refuelVehicle.refuel();
        }
        private static void destroyVehicle(Vehicle destroyVehicle) {
            destroyVehicle.destroy();
    }
}