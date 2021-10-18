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
							setReservation(in, userChoice);
							break;
						case "G" :
							System.out.println("test G");
							break;
						case "H" :
							System.out.println("test H");
							break;
						case "I" :
							deleteReservation(in);
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
				if(customers[j] != null && startDates[j].isBefore(response.plusDays(1)) && endDates[j].isAfter(response.minusDays(1))) {
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
				if(customers[j] != null && startDates[j].isBefore(response.plusDays(1)) && endDates[j].isAfter(response.minusDays(1))) {
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
					
					for (int j = 0; j < customers.length; j++) {
						// si on entre dans cette condition c'est que la chambre est occupée
						if(customers[j] != null && startDates[j].isBefore(response.plusDays(1)) && endDates[j].isAfter(response.minusDays(1))) {
							free = false;
							break;
						}		
					}
					// Sinon c'est que la chambre est libre alors on l'affiche
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
				
				// Si on rentre dans cette condition c'est que la chambre est occupée
				if(customers[j] != null && startDates[j].isBefore(response.plusDays(1)) && endDates[j].isAfter(response.minusDays(1))) {
					free = false;
					break;
				}
			}
			// Si on a bouclé sur les 3 clients et que la chambre n'est pas occupée alors on incremente count
			if(free) {
				allOccupied = false;
				count ++;
				if(i == 64) {
					System.out.println(count + " chambres libre de type " + hotel[i].getRoomType());
					break;
				}
				// Si la chambre d'apres n'est pas du meme type on afficher le nombre de chambre libre du type actuel et on remet le compteur a 0
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
	
	public void deleteReservation(Scanner in) {
		System.out.println("Veuillez saisir le nom auquel la reservation à été faite");
		String lastName = in.next();
		
		System.out.println("Veuillez saisir le prénom auquel la reservation à été faite");
		String firstName  = in.next();
		
		System.out.println("Veuillez saisir la date du début de la réservation que vous souhaitez annuler auquel la reservation à été faite");
		LocalDate startDate = askDate(in);
		
		System.out.println("Veuillez saisir la date de fin de la réservation que vous souhaitez annuler auquel la reservation à été faite");
		LocalDate endDate = askDate(in);
		
		boolean notFound = true;
		
		for (int i = 0; i < hotel.length; i++) {
			Customer customers[] = hotel[i].getCustomers();
			LocalDate startDates[] = hotel[i].getStartDates();
			LocalDate endDates[] = hotel[i].getEndDates();
			
				for (int j = 0; j < customers.length; j++) {
					if(customers[j] != null && firstName.equalsIgnoreCase(customers[j].getFirstName()) && lastName.equalsIgnoreCase(customers[j].getLastName()) && startDate.equals(startDates[j]) && endDate.equals(endDates[j])) {
						customers[j] = null;
						startDates[j] = null;
						endDates[j] = null;
						notFound = false;
						System.out.println("La réservation de Monsieur " + lastName + " " + firstName + " du " +  startDate  + " au " + endDate + " à bien été supprimée.");
						break;
					}
				}
				if(!notFound) {
					break;
				}
		}
		if(notFound) {
			System.out.println("Pas de réservation correspondante");
		}
	}
	
	public LocalDate askDate(Scanner in) {
		System.out.println("Insérer l'année ");
		String year = in.next();
		System.out.println("Insérer le mois ");
		String month = in.next();
		System.out.println("Insérer le jour ");
		String day = in.next();
		String date = year + "-" + month + "-" + day;
		LocalDate response = LocalDate.parse(date);
		return response;
	}
	
	public int firstAvailableRoomByType(Scanner in, LocalDate currentDate, LocalDate resaStart, LocalDate resaEnd, String userChoice) {
		int count = 0;
		int fARBTIndex = 0;
		String selection = "";
		// Compteur du nombre de créneaux ok pour le client par chambre.
		// Pour que la chambre puisse être réservée, tous les crénaux doivent être validée
		// le compteur doit être à 3.
		for (int i = 0; i < hotel.length; i++) {
			if(hotel[i].getRoomType().equals("Chambre Vue Piscine")) {
				selection = "1";
			} else if (hotel[i].getRoomType().equals("Chambre Vue Jardin")) {
				selection = "2";
			} else if (hotel[i].getRoomType().equals("Chambre Vue Océan")) {
				selection = "3";
			} else if (hotel[i].getRoomType().equals("Chambre Vue imprenable sur l'océan")) {
				selection = "4";
			} else if (hotel[i].getRoomType().equals("Suite CDA")) {
				selection = "5";
			} else if (hotel[i].getRoomType().equals("Suite Executive")) {
				selection = "6";
			} else if (hotel[i].getRoomType().equals("Suite Ambassadeur")) {
				selection = "7";
			} else if (hotel[i].getRoomType().equals("Suite Royale")) {
				selection = "8";
			}
			if(userChoice.equals(selection)) {
				Customer customers[] = hotel[i].getCustomers();
				LocalDate startDates[] = hotel[i].getStartDates();
				LocalDate endDates[] = hotel[i].getEndDates();
				count = 0;
				for (int j = 0; j < customers.length; j++) {
					if(customers[j] == null) {
						count++;
					}
					if((customers[j] != null) && ((endDates[j].isBefore(resaStart)) || (startDates[j].isAfter(resaEnd)))) {
						count++;
					}
					if(count == 3) {
						fARBTIndex = i;
						count = 0;
						i = hotel.length;
						break;
					}
				}
			}
		}
		return fARBTIndex;
	}
	
	public void allAvailableRoomsToReserve(LocalDate currentDate, LocalDate resaStart, LocalDate resaEnd) {
		int count = 0;
		// Compteur du nombre de créneaux ok pour le client par chambre.
		// Pour que la chambre puisse être réservée, tous les crénaux doivent être validée
		// le compteur doit être à 3.

		if(currentDate.isBefore(resaStart)) { // Si la date est apr�s la date actuelle...
			for (int i = 0; i < hotel.length; i++) {
				Customer customers[] = hotel[i].getCustomers();
				LocalDate startDates[] = hotel[i].getStartDates();
				LocalDate endDates[] = hotel[i].getEndDates();
				count = 0;
				for (int j = 0; j < customers.length; j++) {
					if(customers[j] == null) {
						count++;
					}
					if((customers[j] != null) && ((endDates[j].isBefore(resaStart)) || (startDates[j].isAfter(resaEnd)))) {
						count++;
					}
					if(count == 3) {
						System.out.println("Chambre " + i + " de type " + hotel[i].getRoomType());
						count = 0;
					} else if ((i == hotel.length-1) && (j == customers.length-1) && (count < 3)) {
						System.out.println("Toutes les chambres sont actuellement occup�es.");
					}
				}
			}
		} else {
			System.out.println("Veuillez donner une date ult�rieur � celle d'aujourd'hui.");
		}
	}
	
	public void setReservation(Scanner in, String userChoice) {
		LocalDate currentDate = LocalDate.now(); // date d'aujourd'hui
		
		System.out.println("Date du début de la réservation :");
		LocalDate resaStart = askDate(in);
		System.out.println("Date de fin de la réservation :");
		LocalDate resaEnd = askDate(in);

		System.out.println("Recherche de toutes les chambres libres à cette date :");
		allAvailableRoomsToReserve(resaStart, resaEnd, currentDate);

		System.out.println("Nombre d'adultes ?");
		int adultBeds = in.nextInt();
		System.out.println("Nombre d'enfants ?");
		int childBeds = in.nextInt();
		int bedroomCount = 0;
		if((adultBeds > 2) || (childBeds > 2)) {
			System.out.println("Les clients sont trop nombreux pour la capacité de la chambre.");
			if((adultBeds/2 > childBeds/2) || (adultBeds/2 == childBeds/2)) {
				bedroomCount = (adultBeds/2);
			} else {
				bedroomCount = (childBeds/2);
			}
			System.out.println("Ils devront réserver " + (bedroomCount-1) + " chambre(s) supplémentaire(s).");
		}
		int fARBTIndex = 0;
		System.out.println("Montrer au client la carte des types de chambre en lui indiquant celles qui seront diponible à la date qu'il souhaite.");
		System.out.println("Nom du client");
		String clientFirstName = in.next();
		System.out.println("Prénom du client :");
		String clientLastName = in.next();
		System.out.println("Pour quitter la réservation appuyer sur 'Q'.");
		System.out.println(" ");
		do {
			if (userChoice.toUpperCase().charAt(0) == 'Q') {
				System.out.println("La réservation a été annulée.");
				break;
			}
			if(bedroomCount > 0) {
				System.out.println("Il reste " + bedroomCount + " chambre(s) à réserver.");
				System.out.println(" ");
			}
			System.out.println("Voici les chambres encore disponibles à cette date :");
			allAvailableRoomsToReserve(resaStart, resaEnd, currentDate);
			System.out.println(" ");
			System.out.println("Choisir le type de chambre :");
			System.out.println("-------------------------------");
			System.out.println("1 - Chambre Vue Piscine");
			System.out.println("2 - Chambre Vue Jardin");
			System.out.println("3 - Chambre Vue Océan");
			System.out.println("4 - Chambre Vue imprenable sur l'océan");
			System.out.println("5 - Suite CDA");
			System.out.println("6 - Suite Executive");
			System.out.println("7 - Suite Ambassadeur");
			System.out.println("8 - Suite Royale");
			System.out.println("-------------------------------");
			userChoice = in.next();
			fARBTIndex = firstAvailableRoomByType(in, currentDate, resaStart, resaEnd, userChoice); // Index de la 1ere chambre libre par type
			Customer fARBTCustomers[] = hotel[fARBTIndex].getCustomers(); // initialisation d'un nouveau client
			LocalDate fARBTStartingDate[] = hotel[fARBTIndex].getStartDates(); // initialisation d'un nouveau début de date de résa 
			LocalDate fARBTEndingDate[] = hotel[fARBTIndex].getEndDates(); // initialisation d'une nouvelle fin de date se résa
			for (int i = 0; i < 3; i++) {
				if(fARBTCustomers[i] == null) { // si l'emplacement de résa est libre...
					fARBTCustomers[i] = new Customer(clientFirstName, clientLastName);
					fARBTStartingDate[i] = resaStart;
					fARBTEndingDate[i] = resaEnd;
					break;
				}
			}
			bedroomCount--;
		} while (bedroomCount > 0);
		System.out.println(" ");
		System.out.println("Réservation effectuée avec succés.");
		System.out.println(" ");
		getClientByNames(clientFirstName, clientLastName);
		System.out.println(" ");
		System.out.println("Retour au menu employé de l'hôtel.");
		System.out.println(" ");
		 // Il manque l'encaissement
	}
	
	
	public void displayClientResa(String userChoice) {
		int userResaCount = 0;
		boolean clientFound = false;
		for (int k = 0; k < hotel.length; k++) {
			Customer customers[] = hotel[k].getCustomers();
			LocalDate startDates[] = hotel[k].getStartDates();
			LocalDate endDates[] = hotel[k].getEndDates();
			for (int l = 0; l < customers.length; l++) {
				if((customers[l] != null) && (userChoice.equals(customers[l].getLogin()))) {
					clientFound = true;
					if(userResaCount == 0) {
						System.out.println("Bienvenue " + customers[l].getFirstName() + " " + customers[l].getLastName() +  ".");
						System.out.println("Vous avez r�serv� la chambre : " + hotel[k].getRoomType() + " au num�ro " + k + ". Vos dates de r�servation pour ce bien vont du " + startDates[l] + " au " + endDates[l] + ".");
						userResaCount++;
					}
					else {
						System.out.println("Vous avez aussi r�serv� la chambre : " + hotel[k].getRoomType() + " au num�ro " + k + ". Vos dates de r�servation pour ce bien vont du " + startDates[l] + " au " + endDates[l] + ".");
					}
				}
				else {
					if((k == hotel.length-1) && (clientFound == false)){
						System.out.println("Vous ne semblez pas encore faire parti des clients de l'h�tel.");
						k = hotel.length;
						break;
					}
				}
			}
		}
        TimerTask task = new TimerTask() {
            public void run() {  
        		System.out.println("Entrez votre identifiant pour vous connecter ou connaitre les d�tails de votre r�servation :");
            }
        };
        Timer timer = new Timer("Timer");
        long delay = 4000L;
        timer.schedule(task, delay);
	}
	
	public void getClientByNames(String clientFirstName, String clientLastName) {
		int userResaCount = 0;
		boolean clientFound = false;
		for (int k = 0; k < hotel.length; k++) {
			Customer customers[] = hotel[k].getCustomers();
			LocalDate startDates[] = hotel[k].getStartDates();
			LocalDate endDates[] = hotel[k].getEndDates();
			for (int l = 0; l < customers.length; l++) {
				if((customers[l] != null) && (clientFirstName.equals(customers[l].getFirstName())) && (clientLastName.equals(customers[l].getLastName()))) {
					clientFound = true;
					if(userResaCount == 0) {
						System.out.println(customers[l].getFirstName() + " " + customers[l].getLastName() +  ". Identifiant client : " + customers[l].getLogin());
						System.out.println("Les dates de réservation pour ce bien vont du " + startDates[l] + " au " + endDates[l] + ".");
						System.out.println("Voici la liste des chambres qu'il a réservé :");
						System.out.println(hotel[k].getRoomType() + " au numéro " + k + ".");
						userResaCount++;
					} else {
						System.out.println(hotel[k].getRoomType() + " au numéro " + k + ".");
					}
				} else {
					if((k == hotel.length-1) && (clientFound == false)){
						System.out.println("Désolé il semble qu'il y ai eu une erreur dans la réservation.");
						k = hotel.length;
						break;
					}
				}
			}
		}
        TimerTask task = new TimerTask() {
            public void run() {  
        		System.out.println("Entrez votre identifiant pour vous connecter ou connaitre les détails de votre réservation :");
            }
        };
        Timer timer = new Timer("Timer");
        long delay = 4000L;
        timer.schedule(task, delay);
	}
	
}