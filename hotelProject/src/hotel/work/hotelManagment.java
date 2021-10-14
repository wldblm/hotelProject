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
            System.out.println("A - Afficher l��tat de l�h�tel");
            System.out.println("B - Afficher le nombre de chambres r�serv�es");
            System.out.println("C - Afficher le nombre de chambres libres");
            System.out.println("D - Afficher le num�ro de la premi�re chambre vide");
            System.out.println("E - Afficher le num�ro de la derni�re chambre vide");
            System.out.println("F - R�server une chambre (Le programme doit r�server la premi�re chambre videselon les crit�res choisis)");
            System.out.println("G - Lib�rer une chambre (Le programme doit lib�rer la chambre en utilisant le num�ro de chambre ou le nom du client)");
            System.out.println("H - Modifier une r�servation");
            System.out.println("I - Annuler une r�servation");
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
