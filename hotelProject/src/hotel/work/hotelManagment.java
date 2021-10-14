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
	
	
}
