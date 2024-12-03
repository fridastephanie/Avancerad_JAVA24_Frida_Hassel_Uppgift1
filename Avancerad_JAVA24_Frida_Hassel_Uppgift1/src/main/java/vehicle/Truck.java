package vehicle;

public class Truck extends AbstractVehicle {
    //Skapar en instansvariabel för lastbilens maxhastighet
    private int maxSpeed;

    /**
     * Konstruktor som tilldelar instansvariablerna i super-klassen och klassens egna instansvariabel värden från de inhämtade egenskaperna
     *
     * @param registrationNumber
     * @param vehicleType
     * @param vehicleRentPrice
     * @param isRented
     * @param maxSpeed
     */
    public Truck(String registrationNumber, String vehicleType, double vehicleRentPrice, boolean isRented, int maxSpeed) {
        super(registrationNumber, vehicleType, vehicleRentPrice, isRented);
        this.maxSpeed = maxSpeed;
    }

    /**
     * Metod som skriver ut klassen Trucks egna egenskap
     */
    public void displayMaxSpeed() {
        System.out.printf(" (maxhastighet: %d km/h)", maxSpeed);
    }

    /**
     * Metod som anropar en metod från super-klassen där egenskaperna från super-klassen skrivs ut
     * samt anropas klassens egna metod som skriver ut klassens egna egenskap, så att alla egenskaper skrivs ut
     *
     * Metoden har samma namn som super-klassens och skriver över super-klassens metod
     */
    @Override
    public void displayVehicle() {
        super.displayVehicle();
        displayMaxSpeed();
    }
}
