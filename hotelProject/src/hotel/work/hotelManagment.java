package hotel.work;

import java.time.LocalDate;
import java.util.Scanner;

import hotel.customers.Customer;
import hotel.rooms.Room;

public class hotelManagment {
	
	private Room hotel[];
	
	public hotelManagment() {
		hotel = generate();
		Scanner in = new Scanner(System.in);
		
		String userChoice = " ";
		
		// début du menu pour un employé
        while(userChoice.toUpperCase() != "Q"){
        	
    		if(userChoice.equalsIgnoreCase("Q")) { // Pour sortir du while
    			in.close();
    			break;
    		}
    		
            System.out.println("");
            System.out.println("----------------------------------------  MENU HOTEL CDA JAVA  ----------------------------------------");
            System.out.println("A - Afficher l'état de l'hôtel");
            System.out.println("B - Afficher le nombre de chambres réservées");
            System.out.println("C - Afficher le nombre de chambres libres");
            System.out.println("D - Afficher le numéro de la première chambre vide");
            System.out.println("E - Afficher le numéro de la dernière chambre vide");
            System.out.println("F - Réserver une chambre (Le programme doit réserver la première chambre videselon les critéres choisis)");
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
					hotelStatus();
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
	

	// Generation des chambres d'hotel
	public Room[] generate() {
		
		String listeChambresCsv [] ={"Type chambre;Taille;Vues;Occupation;tarif;Nombre de chambre;Options",
				"Chambre Vue Piscine;44 mètres carrés;Piscine Centrale;2 adultes et 2 enfants de moins de 12 ans;300;7;Fer et planche à repasser sur demande|Téléphone |Télévision par câble|Climatisation|Bouilloire électrique|Concierge 24h/24",
				"Chambre Vue Jardin;44 mètres carrés;Jardin, Forêt ou Golf;2 adultes et 2 enfants de moins de 12 ans;314;12;Fer et planche à repasser sur demande|Téléphone |Télévision par câble|Climatisation|Bouilloire électrique|Concierge 24h/24",
				"Chambre Vue Océan;44 mètres carrés;Partielle Océan et Forêt ou Golf;2 adultes et 2 enfants de moins de 12 ans;350;8;Fer et planche à repasser sur demande|Téléphone |Accès Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
				"Chambre vue imprenable sur l'océan;44 mètres carrés;Océan;2 adultes et 2 enfants de moins de 12 ans;350;10;Fer et planche à repasser sur demande|Téléphone |Accès Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
				"Suite CDA;82 mètres carrés;Océan et Golf;2 adultes et 2 enfants de moins de 12 ans;450;12;Sèche-cheveux|Coffre-fort dans la chambre|Minibar|Téléphone |Accès Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
				"Suite Executive;140 mètres carrés;Océan;2 adultes et 2 enfants de moins de 12 ans;550;5;Sèche-cheveux|Coffre-fort dans la chambre|Minibar|Téléphone |Accès Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
				"Suite Ambassadeur;230 mètres carrés;Océan;2 adultes et 2 enfants de moins de 12 ans;1650;7;Sèche-cheveux|Coffre-fort dans la chambre|Minibar|Téléphone |Accès Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
				"Suite Royale;342  mètres carrés;Océan;2 adultes et 2 enfants de moins de 12 ans;2400;4;Sèche-cheveux|Coffre-fort dans la chambre|Minibar|Téléphone |Accès Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24"};
		
		hotel = new Room[65];
		// nbPrev correspond à la dernière chambre instanciée
		int nbPrev = 0;
		
		//On boucle sur le Csv et à chaque itération on crée un tableau de chaque attributs de classe qu'on met dans des variables puis on instance une room nb fois dans le tableau hotel
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
	
	public void hotelStatus() {
		for (int i = 0; i < hotel.length; i++) {
			// On recupère les clients de la chambre i ainsi que les dates de debut et de fin de séjour
			Customer customers[] = hotel[i].getCustomers();
			LocalDate startDates[] = hotel[i].getStartDates();
			LocalDate endDates[] = hotel[i].getEndDates();
			boolean isFree = true;
			
			// si il y a au moins un client alors la chambre n'est pas "vide" donc on affiche les informations de la reservation 
			for (int j = 0; j < customers.length; j++) {
				if(customers[j] != null) {
					isFree = false;
					System.out.println("La chambre " + i + " de type " + hotel[i].getRoomType() + " est occupé par " + customers[j].getFirstName() + " " + customers[j].getLastName() + " du " + startDates[j] + " au " + endDates[j]);
				}
				
			}
			// Si elle est vide on affiche la chambre vide
			if(isFree) {
				System.out.println("La chambre numéro " + i + " de type " + hotel[i].getRoomType() + " est libre.");
			}
		}
	}
	
	
}
