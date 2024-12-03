package vehicle;

public abstract class AbstractVehicle implements InterfaceRentable {
    //Skapar en instansvariabel för fordonets registreringsnummer
    private String registrationNumber;
    //Skapar en instansvariabel för fordonets fordonstyp
    private String vehicleType;
    //Skapar en instansvariabel för fordonets hyrpris
    private double rentPrice;
    //Skapar en instansvariabel för fordonets tillgänglighet
    private boolean isRented;

    /**
     * Konstruktor som tilldelar instansvariablerna värden från de inhämtade egenskaperna
     *
     * @param registrationNumber
     * @param vehicleType
     * @param rentPrice
     * @param isRented
     */
    public AbstractVehicle(String registrationNumber, String vehicleType, double rentPrice, boolean isRented) {
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
        this.rentPrice = rentPrice;
        this.isRented = isRented;
    }

    /**
     * Metod från Interface, som definieras med en utskrift som informerar användaren om vilket fordon som hyrts
     * och sätter fordonets boolean isRented till true
     */
    @Override
    public void rentVehicle() {
        System.out.printf("Du har hyrt: %s", this.registrationNumber);
        System.out.println();
        this.isRented = true;
    }

    /**
     * Metod från Interface, som definieras med en utskrift som informerar användaren om vilket fordon som återlämnats
     * och sätter fordonets boolean isRented till false
     */
    @Override
    public void returnVehicle() {
        System.out.printf("Du har återlämnat: %s", this.registrationNumber);
        System.out.println();
        this.isRented = false;
    }

    /**
     * Metod från Interface, som definieras genom att inhämta användarens inmatade antat hyrdagar,
     * därefter multipliceras hyrdagarna med fordonets pris och sparar totalsumman i en lokal variabel
     *
     * En utskrift informerar därefter användaren om totalsumman
     * @param rentDays
     */
    @Override
    public void calculateRentCost(int rentDays) {
        double totalRentCost = this.rentPrice * rentDays;
        System.out.printf("Hyran för %d dagar blir: %.2f kronor", rentDays, totalRentCost);
        System.out.println();
    }

    /**
     * Metod som skriver ut fordonets egenskaper
     */
    public void displayVehicle(){
        System.out.printf("%s, %s, hyrpris/dag: %.2f kronor",
                this.registrationNumber, this.vehicleType, this.rentPrice);
    }

    /**
     * Getter för registrationNumber
     * @return
     */
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * Getter för isRented
     * @return
     */
    public boolean isRented() {
        return isRented;
    }
}

