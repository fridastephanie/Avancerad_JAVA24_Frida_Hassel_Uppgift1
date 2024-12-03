# Uppgift 1 - *Virituell biluthyrning*

### <ins>Om projektet</ins>
Detta är en konsolbaserad Java-applikation för virituell fordonsuthyrning, där användare kan hyra ett fordon, returnera ett fordon eller avsluta programmet.   
Projektet är ett objektorienterat koncept som använder interface, arv, inkapsling och abstraktion

### <ins>Användning</ins>
* Följ menyvalen som skrivs ut när applikationen startas  
  *(1. Hyr ett fordon, 2. Returnera ett fordon, 3. Avsluta)*
    * Vid menyval 1 och 2 skrivs objekten av typen fordon ut, skriv in regitsreringsnumret på fordonet som ska hyras/återlämnas
        * Vid menyval 1, vid lyckad uthyrning skrivs menyvalen ut igen
        * Vid menyval 2, vid lyckad returnering efterfrågas antalet dagar fordonet varit uthyrt och den totala kostnaden för hyran skrivs ut, därefter skrivs menyvalen ut igen
    * Vid menyval 3, avslutas programmet

Programmet hanterar ogiltiga inmatningar och visar användarvänliga meddelanden

### <ins>Projektstruktur</ins>
Applikationen är uppdelad i följande paket:
* main: innehåller klassen Main som startar applikationen
* ui: innehåller klassen RentMenu som hanterar användargränssnittet och felhantering
* manager: innehåller klassen VehicleManager som hanterar logik för fordonsdata
* vehicle: innehåller följande klasser som hanterar logik för att skapa olika objekt
    * InterfaceRentable: interface som specificerar metoder för uthyrning, återlämning och uträkning av hyrkostnaden
    * AbstractVehicle: abstrakt klass som implementerar InterfaceRentable och definierar egenskaper och metoder som alla olika fordonsobjekt ska ha
    * Car, Motorcycle, Trailer, Truck: samtliga klasser extendar AbstractVehicle och skapar speicfika 	fordonstyper med en del ärvda egenskaper och metoder, samt varsin specifik egenskap och metod

### <ins>Övrigt</ins>
* Programmet är skapat i IntelliJ IDEA 2024.2.3 med JDK 23.0.1
* Utskrifterna i programmet är på svenska