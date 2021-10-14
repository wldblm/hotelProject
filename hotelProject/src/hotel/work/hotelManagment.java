package hotel.work;

import java.util.Scanner;

import hotel.rooms.Room;

public class hotelManagment {
	
	private Room hotel[];
	
	public hotelManagment() {
		
		Scanner in = new Scanner(System.in);
		
		String userChoice = " ";
		
		// d�but du menu pour un employ�
        while(userChoice.toUpperCase() != "Q"){
        	
    		if(userChoice.equalsIgnoreCase("Q")) { // Pour sortir du while
    			in.close();
    			break;
    		}
    		
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
        // fin du menu pour un employ�
        
		hotel = generate();
		
		for (int i = 0; i < hotel.length; i++) {
			System.out.println(hotel[i].getRoomType());
			System.out.println(hotel[i].getView());
			System.out.println(hotel[i].getMaxPer());
			System.out.println(hotel[i].getSize());
			System.out.println(hotel[i].getPrice());
			String options[] = hotel[i].getOptions();
			for (int j = 0; j < options.length; j++) {
				System.out.println(options[j]);
			}
			System.out.println("");
		}
		
		
	}
	

	public Room[] getHotel() {
		return hotel;
	}

	public void setHotel(Room hotel[]) {
		this.hotel = hotel;
	}
	
	public Room[] generate() {
		String listeChambresCsv [] ={"Type chambre;Taille;Vues;Occupation;tarif;Nombre de chambre;Options",
				"Chambre Vue Piscine;44 m�tres carr�s;Piscine Centrale;2 adultes et 2 enfants de moins de 12 ans;300;7;Fer et planche � repasser sur demande|T�l�phone |T�l�vision par c�ble|Climatisation|Bouilloire �lectrique|Concierge 24h/24",
				"Chambre Vue Jardin;44 m�tres carr�s;Jardin, For�t ou Golf;2 adultes et 2 enfants de moins de 12 ans;314;12;Fer et planche � repasser sur demande|T�l�phone |T�l�vision par c�ble|Climatisation|Bouilloire �lectrique|Concierge 24h/24",
				"Chambre Vue Oc�an;44 m�tres carr�s;Partielle Oc�an et For�t ou Golf;2 adultes et 2 enfants de moins de 12 ans;350;8;Fer et planche � repasser sur demande|T�l�phone |Acc�s Internet haut d�bit sans fil|Lecteur DVD sur demande|T�l�vision par c�ble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
				"Chambre vue imprenable sur l'oc�an;44 m�tres carr�s;Oc�an;2 adultes et 2 enfants de moins de 12 ans;350;10;Fer et planche � repasser sur demande|T�l�phone |Acc�s Internet haut d�bit sans fil|Lecteur DVD sur demande|T�l�vision par c�ble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
				"Suite CDA;82 m�tres carr�s;Oc�an et Golf;2 adultes et 2 enfants de moins de 12 ans;450;12;S�che-cheveux|Coffre-fort dans la chambre|Minibar|T�l�phone |Acc�s Internet haut d�bit sans fil|Lecteur DVD sur demande|T�l�vision par c�ble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
				"Suite Executive;140 m�tres carr�s;Oc�an;2 adultes et 2 enfants de moins de 12 ans;550;5;S�che-cheveux|Coffre-fort dans la chambre|Minibar|T�l�phone |Acc�s Internet haut d�bit sans fil|Lecteur DVD sur demande|T�l�vision par c�ble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
				"Suite Ambassadeur;230 m�tres carr�s;Oc�an;2 adultes et 2 enfants de moins de 12 ans;1650;7;S�che-cheveux|Coffre-fort dans la chambre|Minibar|T�l�phone |Acc�s Internet haut d�bit sans fil|Lecteur DVD sur demande|T�l�vision par c�ble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
				"Suite Royale;342 m�tres carr�s;Oc�an;2 adultes et 2 enfants de moins de 12 ans;2400;4;S�che-cheveux|Coffre-fort dans la chambre|Minibar|T�l�phone |Acc�s Internet haut d�bit sans fil|Lecteur DVD sur demande|T�l�vision par c�ble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24"};
		hotel = new Room[65];
		int nbPrev = 0;
		for (int i = 1; i < listeChambresCsv.length; i++) {
			
			String tab[] = listeChambresCsv[i].split(";");
			String roomType = tab[0];
			String size = tab[1];
			String view = tab[2];
			String maxPer = tab[3];
			String price = tab[4];
			int nb = Integer.parseInt(tab[5]);
			String options[] = tab[6].split("\\|");
				for (int k = 0; k < nb; k++) {
					hotel[nbPrev] = new Room(roomType, view, maxPer, size, price,options);
					nbPrev++;
				}
			
			
		}
		
		return hotel;
	}
	
	
}
