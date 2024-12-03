package vehicle;

public interface InterfaceRentable {
    /**
     * Definierar metod utan impletering
     */
    void rentVehicle();
    /**
     * Definierar metod utan impletering
     */
    void returnVehicle();
    /**
     * Definierar metod utan impletering, som även inhämtar en egenskap
     */
    void calculateRentCost(int rentDays);
}
