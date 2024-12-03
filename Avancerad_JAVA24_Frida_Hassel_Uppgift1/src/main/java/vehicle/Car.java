package vehicle;

public class Car extends AbstractVehicle {
    //Skapar en instansvariabel för bilens bränslesort
    private String fuelType;

    /**
     * Konstruktor som tilldelar instansvariablerna i super-klassen och klassens egna instansvariabel värden från de inhämtade egenskaperna
     *
     * @param registrationNumber
     * @param vehicleType
     * @param rentPrice
     * @param isRented
     * @param fuelType
     */
    public Car(String registrationNumber, String vehicleType, double rentPrice, boolean isRented, String fuelType) {
        super(registrationNumber, vehicleType, rentPrice, isRented);
        this.fuelType = fuelType;
    }

    /**
     * Metod som skriver ut klassen Cars egna egenskap
     */
    public void displayFuelType() {
        System.out.printf(" (bränslesort: %s)", fuelType);
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
        displayFuelType();
    }
}
