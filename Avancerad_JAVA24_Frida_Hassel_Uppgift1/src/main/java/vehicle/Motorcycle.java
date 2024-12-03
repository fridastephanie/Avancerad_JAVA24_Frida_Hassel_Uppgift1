package vehicle;

public class Motorcycle extends AbstractVehicle {
    //Skapar en instansvariabel för motorcykelns körkortsbehörighet
    private char drivingLicenseLevel;

    /**
     * Konstruktor som tilldelar instansvariablerna i super-klassen och klassens egna instansvariabel värden från de inhämtade egenskaperna
     *
     * @param registrationNumber
     * @param vehicleType
     * @param vehicleRentPrice
     * @param isRented
     * @param drivingLicenseLevel
     */
    public Motorcycle(String registrationNumber, String vehicleType, double vehicleRentPrice, boolean isRented, char drivingLicenseLevel) {
        super(registrationNumber, vehicleType, vehicleRentPrice, isRented);
        this.drivingLicenseLevel = drivingLicenseLevel;
    }

    /**
     * Metod som skriver ut klassen Motorcycles egna egenskap
     */
    public void displayDrivingLicenseLevel() {
        System.out.printf(" (körkortsbehörighet: %c)", drivingLicenseLevel);
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
        displayDrivingLicenseLevel();
    }

}
