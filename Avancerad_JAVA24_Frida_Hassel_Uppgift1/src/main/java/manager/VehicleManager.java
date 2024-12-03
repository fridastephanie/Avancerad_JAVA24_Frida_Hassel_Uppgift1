package manager;
import vehicle.*;
import java.util.HashMap;

public class VehicleManager {
    //Skapar en HashMap med String-objekt som nyckel och innehåll av AbstractVehicle-objekt
    private HashMap<String, AbstractVehicle> vehicleList = new HashMap();

    /**
     * Konstruktor som skapar olika vehicle-objekt och lägger till de i HashMappen med registreringsnumret som nyckel
     */
    public VehicleManager() {
        AbstractVehicle car = new Car("ABC123", "bil", 1500, false, "diesel");
        vehicleList.put(car.getRegistrationNumber(), car);
        AbstractVehicle motorcycle = new Motorcycle("DEF456", "motorcykel", 999.90, false, 'A');
        vehicleList.put(motorcycle.getRegistrationNumber(), motorcycle);
        AbstractVehicle trailer = new Trailer("GHI789", "släpvagn", 500, false, 750);
        vehicleList.put(trailer.getRegistrationNumber(), trailer);
        AbstractVehicle truck = new Truck("JKL123", "lastbil", 2999.50, false, 90);
        vehicleList.put(truck.getRegistrationNumber(), truck);
    }

    /**
     * Metod som loopar igenom alla AbstractVehicle-objekt i HashMappen och skriver ut dem,
     * samt kollar och skriver ut om fordonet är ledigt eller uthyrt
     */
    public void displayAllVehicles(){
        System.out.println("\nFORDON:");
        for (AbstractVehicle vehicle : vehicleList.values()) {
            vehicle.displayVehicle();
            if (!vehicle.isRented()){
                System.out.print(" - LEDIG");
            }
            else {
                System.out.print(" - UTHYRD");
            }
            System.out.println();
        }
    }

    /**
     * Metod som loppar igenom alla nycklarna i HashMappen och jämför med en inhämtad String,
     * om en nyckel och den inhämtade strängen matchar returneras objektet som nyckeln tillhör,
     * annars returneras null
     *
     * @param vehicleRentChoice
     * @return
     */
    public AbstractVehicle findVehicleChoice(String vehicleRentChoice){
        for (String registrationNumber : vehicleList.keySet()) {
            if (registrationNumber.equalsIgnoreCase(vehicleRentChoice)) {
                return vehicleList.get(registrationNumber);
            }
        }
        return null;
    }
}
