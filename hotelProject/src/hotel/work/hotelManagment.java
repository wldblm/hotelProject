package hotel.work;

import java.util.Scanner;

import hotel.rooms.Room;

public class hotelManagment {
	
	private Room hotel[];
	
	public hotelManagment() {
		
		Scanner in = new Scanner(System.in);
		
		String userChoice = " ";
		
		// début du menu pour un employé
        while(userChoice.toUpperCase() != "Q"){
        	
    		if(userChoice.equalsIgnoreCase("Q")) { // Pour sortir du while
    			break;
    		}
    		
            System.out.println("");
            System.out.println("----------------------------------------  MENU HOTEL CDA JAVA  ----------------------------------------");
            System.out.println("A - Afficher l’état de l’hôtel");
            System.out.println("B - Afficher le nombre de chambres réservées");
            System.out.println("C - Afficher le nombre de chambres libres");
            System.out.println("D - Afficher le numéro de la première chambre vide");
            System.out.println("E - Afficher le numéro de la dernière chambre vide");
            System.out.println("F - Réserver une chambre (Le programme doit réserver la première chambre videselon les critères choisis)");
            System.out.println("G - Libérer une chambre (Le programme doit libérer la chambre en utilisant le numéro de chambre ou le nom du client)");
            System.out.println("H - Modifier une réservation");
            System.out.println("I - Annuler une réservation");
            System.out.println("Q - Quitter");
            System.out.println("----------------------------------------  MENU HOTEL CDA JAVA  ----------------------------------------");
            System.out.println("");
            System.out.println("Que voulez-vous faire ?");

            userChoice = in.next();

			switch(userChoice.toUpperCase()){
				case "A" :
					System.out.println("test A");
					break;
				case "B" :
					System.out.println("test B");
					break;
				case "C" :
					System.out.println("test C");
					break;
				case "D" :
					System.out.println("test D");
					break;
				case "E" :
					System.out.println("test E");
					break;
				case "F" :
					System.out.println("test F");
					break;
				case "G" :
					System.out.println("test G");
					break;
				case "H" :
					System.out.println("test H");
					break;
				case "I" :
					System.out.println("test I");
					break;
			}
        }
        // fin du menu pour un employé
		
	}
	

	public Room[] getHotel() {
		return hotel;
	}

	public void setHotel(Room hotel[]) {
		this.hotel = hotel;
	}
	
	
}
