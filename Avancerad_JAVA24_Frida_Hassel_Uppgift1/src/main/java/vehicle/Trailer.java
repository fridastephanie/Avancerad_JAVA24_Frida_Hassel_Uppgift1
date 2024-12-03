package vehicle;

public class Trailer extends AbstractVehicle {
    //Skapar en instansvariabel för släpvagnens maxvikt
    private int maxWeigth;

    /**
     * Konstruktor som tilldelar instansvariablerna i super-klassen och klassens egna instansvariabel värden från de inhämtade egenskaperna
     *
     * @param registrationNumber
     * @param vehicleType
     * @param vehicleRentPrice
     * @param isRented
     * @param maxWeigth
     */
    public Trailer(String registrationNumber, String vehicleType, double vehicleRentPrice, boolean isRented, int maxWeigth) {
        super(registrationNumber, vehicleType, vehicleRentPrice, isRented);
        this.maxWeigth = maxWeigth;
    }

    /**
     * Metod som skriver ut klassen Trailers egna egenskap
     */
    public void displayMaxWeight() {
        System.out.printf(" (maxlast: %d kg)", maxWeigth);
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
        displayMaxWeight();
    }
}
