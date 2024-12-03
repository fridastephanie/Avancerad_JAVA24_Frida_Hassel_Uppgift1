package ui;
import vehicle.*;
import manager.VehicleManager;
import java.util.Scanner;

public class RentMenu {
    //Skapar ett scanner objekt
    Scanner scan = new Scanner(System.in);
    //Skapar ett objekt av klassen VehicleManager
    private VehicleManager vehicleManager = new VehicleManager();
    //Deklarerar en referensvariabel av typen AbstractVehicle (polymorfism)
    private AbstractVehicle chosenVehicle;
    //Skapar en boolean med värdet true
    private boolean menuRunning = true;

    /**
     * Konstruktor som anropar metoden displayMenu
     */
    public RentMenu() {
        this.displayMenu();
    }

    /**
     * Metod som skriver ut menyn, inhämtar användarens menyval och skapar en switch case
     * som antingen anropar nya metoder beroende på användarens val, eller avslutar programmet
     *
     * En try catch fångar upp om användaren inte matar in ett heltal som menyval (för att undvika att programmet kraschar)
     */
    public void displayMenu() {
        while (menuRunning) {
            try {
                System.out.println("\nMENY");
                System.out.println("1. Hyr ett fordon \n2. Returnera ett fordon \n3. Avsluta");
                System.out.print("\nVal: ");
                String inputMenuChoice = scan.nextLine();

                int menuChoice = Integer.parseInt(inputMenuChoice);

                switch (menuChoice) {
                    case 1:
                        vehicleManager.displayAllVehicles();
                        chooseRentVehicle();
                        break;

                    case 2:
                        vehicleManager.displayAllVehicles();
                        chooseReturnVehicle();
                        break;

                    case 3:
                        System.out.println("Avslutar, välkommen åter!");
                        menuRunning = false;
                        scan.close();
                        break;

                    default:
                        System.out.println("Felaktig inmatning, var vänlig ange en siffra mellan 1 och 3!");
                        break;
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Felaktig inmatning, var vänlig ange en siffra mellan 1 och 3!");
            }
        }
    }

    /**
     * Metod som inhämtar användarens fordonsval (eller val att återgå till menyn)
     * Användarens fordonsval kontrolleras via en metod i VehicleManager, vid match refererar chosenVehicle till det befintliga objektet
     *
     * Metoden kontrollerar sedan om det befintliga objektet är ledigt eller uthyrt
     * och antingen anropas en ny metod för att hyra ut fordonet, eller skrivs ett felmeddelande ut
     */
    private void chooseRentVehicle() {
        while (true) {
            System.out.print("\nAnge registreringsnumret på fordonet du vill hyra eller X för att återgå till huvudmenyn: ");
            String vehicleRentChoice = scan.nextLine();

            if (vehicleRentChoice.equalsIgnoreCase("X")) {
                return;
            }

            chosenVehicle = vehicleManager.findVehicleChoice(vehicleRentChoice);

            if (chosenVehicle != null) {
                if (!chosenVehicle.isRented()) {
                    chosenVehicle.rentVehicle();
                    return;
                }
                else {
                    System.out.printf("%s är redan uthyrt!", chosenVehicle.getRegistrationNumber());
                    System.out.println();
                }
            }
            else {
                System.out.printf("\"%s\" finns inte i fordonslistan, försök igen!", vehicleRentChoice);
                System.out.println();
            }
        }
    }

    /**
     * Metod som inhämtar användarens fordonsval (eller val att återgå till menyn)
     * Användarens fordonsval kontrolleras via en metod i VehicleManager, vid match refererar chosenVehicle till det befintliga objektet
     *
     *  Metoden kontrollerar sedan om det befintliga objektet är ledigt eller uthyrt
     *  och antingen anropas nya metod för att returnera fordonet samt ange antal hyrdagar, eller skrivs ett felmeddelande ut
     */
    private void chooseReturnVehicle() {
        while (true) {
            System.out.print("\nAnge registreringsnumret på fordonet du vill återlämna eller X för att återgå till huvudmenyn: ");
            String vehicleReturnChoice = scan.nextLine();

            if (vehicleReturnChoice.equalsIgnoreCase("X")) {
                return;
            }

            chosenVehicle = vehicleManager.findVehicleChoice(vehicleReturnChoice);

            if (chosenVehicle != null) {
                if (chosenVehicle.isRented()) {
                    chosenVehicle.returnVehicle();
                    chooseRentDays();
                    return;
                }
                else {
                    System.out.printf("%s är inte uthyrt!", chosenVehicle.getRegistrationNumber());
                    System.out.println();
                }
            }
            else {
                System.out.printf("\"%s\" finns inte i fordonslistan, försök igen!", vehicleReturnChoice);
                System.out.println();
            }
        }
    }

    /**
     * Metod som inhämtar användarens angivna antal hyrdagar och kontrollerar att inmatningen är ett heltal över 0
     * Vid korrekt inmatning anroaps en ny metod som beräknar det totala hyrpriset, annars skrivs felmeddelanden ut
     */
    private void chooseRentDays() {
        while (true) {
            try {
                System.out.print("\nAnge hur många dagar du har hyrt fordonet: ");
                String inputRentDays = scan.nextLine();
                int rentDays = Integer.parseInt(inputRentDays);

                if (rentDays <= 0) {
                    System.out.println("Antalet dagar måste vara större än noll!");
                    continue;
                }
                chosenVehicle.calculateRentCost(rentDays);
                break;
            }
            catch (NumberFormatException e) {
                System.out.println("Felaktig inmatning, var vänlig ange ett heltal!");
            }
        }
    }
}

