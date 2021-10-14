package hotel.work;

import java.util.Scanner;

import hotel.rooms.Room;

public class hotelManagment {
	
	private Room hotel[];
	
	public hotelManagment() {
		
		Scanner in = new Scanner(System.in);
		
		String userChoice = " ";
		
        while(userChoice.toUpperCase() != "Q"){
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
				case "B" :
				case "C" :
				case "D" :
				case "E" :
				case "F" :
				case "G" :
				case "H" :
				case "I" :
				case "Q" :
					in.close();
					break;
			}
        }
		
	}
	

	public Room[] getHotel() {
		return hotel;
	}

	public void setHotel(Room hotel[]) {
		this.hotel = hotel;
	}
	
	
}
