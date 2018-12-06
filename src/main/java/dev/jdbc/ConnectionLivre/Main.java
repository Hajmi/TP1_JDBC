package dev.jdbc.ConnectionLivre;
import java.util.*;
import dao.DAOEditeur;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean sortie = false;
		String newNom = ""; //Variable dédié à la mémorisation du nom de l'auteur, saisie par l'utilisateur
		int id ; //Variable dédié à la mémorisation de l'ID de l'auteur, saisie par l'utilisateur
		DAOEditeur dao = new DAOEditeur();
		
		Scanner scan = new Scanner(System.in);
		while(!sortie) {
			menu();
			int choix = Integer.parseInt(scan.nextLine());
			//Lister tous les auteurs
			if(choix == 1 ) {
				dao.getAllEditeur();
			}
			//Ajouter un auteur
			else if(choix == 2 ) {
				System.out.println("Veuillez saisir le nouvel auteur svp");
				newNom = scan.nextLine();
				try {
					dao.insertEditeur(newNom);
					
				} catch(Exception e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
			}
			//Supprimer un auteur
			else if(choix == 3) {
				System.out.println("Veuillez saisir l'id de l'auteur à supprimer svp");
				id = Integer.parseInt(scan.nextLine());
				try {
					dao.deleteEditeur(id);
					
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
			}
			//Modifier un auteur
			else if(choix == 4) {
				System.out.println("Veuillez saisir l'id de l'auteur à modifier svp");
				id = Integer.parseInt(scan.nextLine());
				System.out.println("Veuillez saisir le nouveau nom de l'auteur svp");
				newNom = scan.nextLine();
				try {
					dao.updateEditeur(id, newNom);
					
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
					
				}
			}
			
			else if(choix == 5) {
				System.out.println("Au revoir");
				break;
			}
			
			else
				System.out.println("Erreur de choix\r\n");
				continue;
		}
		
	}
	
	public static void menu() {
		System.out.println("Veuillez faire un choix : ");
		System.out.println("1.  Liste des auteurs");
		System.out.println("2.  Ajouter un auteur");
		System.out.println("3.  Supprimer un auteur");
		System.out.println("4.  Modifier un auteur");
		System.out.println("5.  Sortir du programme");
	}

	
}
