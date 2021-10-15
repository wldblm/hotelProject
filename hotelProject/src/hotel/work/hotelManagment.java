package hotel.work;

import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import hotel.customers.Customer;
import hotel.rooms.Room;

public class hotelManagment {
	
	private Room hotel[];
	
	public hotelManagment() {
		hotel = generate();
		Scanner in = new Scanner(System.in);
		String userChoice = "";
		String employeLoggin = "emLog";
        String employePassword = "emPw";		
		System.out.println("Entrez votre identifiant pour vous connecter ou connaitre les détails de votre réservation :");
		while(true) { // boucle sur l'identification
			userChoice = in.next();
			
			if (userChoice.equals(employeLoggin)) { // Vérifie s'il s'agit d'un employé et affiche le menu jusqu'à ce qu'il le quitte
		        while(userChoice.toUpperCase() != "Q"){
		    		if(userChoice.equalsIgnoreCase("Q")) { // Pour sortir du while et revenir à l'écran d'authentification
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
							hotelStatus(in);
							break;
						case "B" :
							getOccupiedRooms(in);
							break;
						case "C" :
							getFreeRooms(in);
							break;
						case "D" :
							firstFreeRoom(in);
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
		        } // fin du menu pour un employé
			        
			} // fin de l'identification
			else {
				displayClientResa(userChoice); // Vérifie s'il s'agit d'un client enregistré et affiche sa résa pdt quelques secondes
			}
		}
	        
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
				"Suite Royale;342 mètres carrés;Océan;2 adultes et 2 enfants de moins de 12 ans;2400;4;Sèche-cheveux|Coffre-fort dans la chambre|Minibar|Téléphone |Accès Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24"};
		
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
					hotel[nbPrev] = new Room(roomType, view, maxPer, size, price, options);
					nbPrev++;
				}
			
		}
		
		return hotel;
	}

	public void hotelStatus(Scanner in) {
		LocalDate response = askDate(in);
		for (int i = 0; i < hotel.length; i++) {
			
			Customer customers[] = hotel[i].getCustomers();
			LocalDate startDates[] = hotel[i].getStartDates();
			LocalDate endDates[] = hotel[i].getEndDates();
			boolean isFree = true;
			
			// si la date donnée est entre la date de debut et de fin alors la chambre est occupée
			for (int j = 0; j < customers.length; j++) {
				if(customers[j] != null && startDates[j].isBefore(response) && endDates[j].isAfter(response)) {
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
	
	public void getOccupiedRooms(Scanner in) {
		// On recupère la date à laquelle on veut afficher les chambres occupée;
		LocalDate response = askDate(in);	
		boolean allFree = true;
		int count = 0;
		for (int i = 0; i < hotel.length; i++) {
			
			Customer customers[] = hotel[i].getCustomers();
			LocalDate startDates[] = hotel[i].getStartDates();
			LocalDate endDates[] = hotel[i].getEndDates();
			
			// // si la date donnée est entre la date de debut et de fin alors la chambre est occupée
			for (int j = 0; j < customers.length; j++) {
				if(customers[j] != null && startDates[j].isBefore(response) && endDates[j].isAfter(response)) {
					allFree = false;
					count ++; // On incrémente un compteur
					if(i == 64) {
						System.out.println(count + " chambres réservées de type " + hotel[i].getRoomType());
						break;
					}
					// Si la chambre d'apres n'est pas du meme type on afficher le nombre de chambre occupées du type actuel et on remet le compteur a 0
					else if(!hotel[i].getRoomType().equals(hotel[i+1].getRoomType())) {
						System.out.println(count + " chambres réservées de type " + hotel[i].getRoomType());
						count = 0;
					}
				}
				
			}
			
		}
		if(allFree) {
			System.out.println("Toutes les chambres sont libres");
		}
		
	}
	
	public void firstFreeRoom(Scanner  in) {
		
		// On recupère la date à laquelle on veut afficher la chambre libre;
				LocalDate response = askDate(in);	
				boolean allOccupied = true;
				boolean free = true;
				for (int i = 0; i < hotel.length; i++) {
					Customer customers[] = hotel[i].getCustomers();
					LocalDate startDates[] = hotel[i].getStartDates();
					LocalDate endDates[] = hotel[i].getEndDates();
					
					// si la date donnée est entre la date de debut et de fin alors la chambre est occupée
					for (int j = 0; j < customers.length; j++) {
						if(customers[j] != null && startDates[j].isBefore(response) && endDates[j].isAfter(response)) {
							free = false;
							break;
						}		
					}
					if(free) {
						System.out.println("La première chambre libre est la chambre numéro " + i + " de type " + hotel[i].getRoomType());
						allOccupied = false;
						break;
					}
					if(!allOccupied){
						break;
					}
				}
				if(allOccupied) {
					System.out.println("Aucune chambre n'est libre");
				}
	}
	
	public void getFreeRooms(Scanner in) {
		// On recupère la date à laquelle on veut afficher les chambres libre;
		LocalDate response = askDate(in);
		boolean allOccupied = true;
		int count = 0;
		boolean free = true;
		
		for (int i = 0; i < hotel.length; i++) {
			Customer customers[] = hotel[i].getCustomers();
			LocalDate startDates[] = hotel[i].getStartDates();
			LocalDate endDates[] = hotel[i].getEndDates();
			
			for (int j = 0; j < customers.length; j++) {
				
				if(customers[j] != null && startDates[j].isBefore(response) && endDates[j].isAfter(response)) {
					allOccupied = false;
					free = false;
					break;
				}
			}
			if(free) {
				count ++;
				if(i == 64) {
					System.out.println(count + " chambres libre de type " + hotel[i].getRoomType());
					break;
				}
				// Si la chambre d'apres n'est pas du meme type on afficher le nombre de chambre occupées du type actuel et on remet le compteur a 0
				else if(!hotel[i].getRoomType().equals(hotel[i+1].getRoomType())) {
					System.out.println(count + " chambres libre de type " + hotel[i].getRoomType());
					count = 0;
				}
			}
		}
		if(allOccupied) {
			System.out.println("Toutes les chambres sont occupées pour cette date");
		}
	}
	
	public LocalDate askDate(Scanner in) {
		System.out.println("Insérer l'année à laquelle vous souhaitez afficher l'état de l'hotel");
		String year = in.next();
		System.out.println("Insérer le mois ");
		String month = in.next();
		System.out.println("Insérer le jour ");
		String day = in.next();
		String date = year + "-" + month + "-" + day;
		LocalDate response = LocalDate.parse(date);
		return response;
	}
	
	public void displayClientResa(String userChoice) {

//		if(userChoice.equals("0000000000")) {
		for (int k = 0; k < hotel.length; k++) {
			Customer customers[] = hotel[k].getCustomers();
			LocalDate startDates[] = hotel[k].getStartDates();
			LocalDate endDates[] = hotel[k].getEndDates();
			for (int l = 0; l < hotel.length; l++) {
				if(userChoice.equals(customers[k].getLogin())) {
					
//					System.out.println("testing for a few seconds");
					System.out.println("Bienvenue " + customers[k].getFirstName() + " " + customers[k].getLastName() +  ". Vous avez réservé la chambre " + hotel[k].getRoomType() + " au numéro " + k + ". Vos dates de réservation vont du  " + startDates[k] + " au " + endDates[k] + ".");

			        TimerTask task = new TimerTask() {
			            public void run() {  
			        		System.out.println("Entrez votre identifiant pour vous connecter ou connaitre les détails de votre réservation :");
			            }
			        };
			        Timer timer = new Timer("Timer");
			        long delay = 3000L;
			        timer.schedule(task, delay);
				}
			}
		}  
	}
	
}