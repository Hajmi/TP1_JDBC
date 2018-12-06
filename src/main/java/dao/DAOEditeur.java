package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import dev.jdbc.ConnectionLivre.ConnectionLivre;
/**
 *
 * Classe DAOEditeur permettant de se connecter à la base de données Livre afin d'accéder à la table Editeur
 *
 * @author Samir Benakcha
 * @since 06/12/2018
 */
public class DAOEditeur {

	/**
	 * Méthode pour récupérer tout les auteur à partir de la base de données Livre table Editeur
	 */
	public void getAllEditeur() {
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try{
			conn = ConnectionLivre.getConnection();
			statement = conn.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM editeur");
			ResultSetMetaData resultMetaData = resultSet.getMetaData();
			
			System.out.println("\r\n//****************EDITEUR****************//");

			for (int i = 1; i <= resultMetaData.getColumnCount(); i++){
				System.out.print("\t" + resultMetaData.getColumnName(i).toUpperCase() + "\t");
			}
			System.out.println();

			while (resultSet.next()){
				System.out.print("\t" + resultSet.getInt("id") + "\t\t" + resultSet.getString("nom") + "\r\n");
			}
			
			System.out.println("\r\n//***************************************//");
			
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally{
			try {
				resultSet.close();
				statement.close();
				conn.close();
			}
			catch (SQLException e){

				e.printStackTrace();
			}
		}
	}
	/**
	 * Méthode pour supprimer un editeur de la base de données livre, table editeur 
	 * @param id de l'auteur dans la base de donnee livre, à partir de la table editeur
	 * @throws SQLException
	 */
	public static void deleteEditeur(int id ) throws SQLException{
		Connection conn = null;
		PreparedStatement preparedstatement = null;
		try{
			//On créé une connexion 
			conn = ConnectionLivre.getConnection();
			//On crée la requête et on l'exécute 
			preparedstatement = conn.prepareStatement("DELETE FROM editeur WHERE id=?");
			preparedstatement.setInt(1, id);
			// On affiche la requête exécutée
			System.out.println(preparedstatement.toString());
			int result = preparedstatement.executeUpdate();
			if(result ==0) System.out.println("Aucun editeur à supprimer");
			
		}
		catch (Exception e){
			throw new SQLException("La suppression de l'editeur n'a pas abouti");
		}
		finally{
				
				preparedstatement.close();
				conn.close();
		}
	}

	/**
	 * Méthode permettant d'ajouter un editeur à la base de données livre, table editeur
	 * @param name le nom de l'editeur à ajouter
	 * @throws SQLException
	 */
	public static void insertEditeur(String name) throws SQLException{
		Connection conn = null;
		PreparedStatement preparedstatement = null;
		try{
			//On créé une connexion 
			conn = ConnectionLivre.getConnection();
			// On crée la requête et on l'exécute 
			preparedstatement = conn.prepareStatement("INSERT INTO editeur (nom) values (?)");
			preparedstatement.setString(1, name);
			// On affiche la requête exécutée
			System.out.println(preparedstatement.toString());
			int result = preparedstatement.executeUpdate();
			if(result ==0) System.out.println("pas de editeur ajouté");
			
		}
		catch (Exception e){
			throw new SQLException("l'ajout de la editeur n'a pas abouti");
		}
		finally{
				
				preparedstatement.close();
				conn.close();
		}
	}
	/**
	 * Méthode pour modifier un editeur à la base de données livre, table editeur
	 * @param id est l'identifiant de l'editeur à modifier
	 * @param nom est le nouveau nom de l'éditeur modifié
	 * @throws SQLException
	 */
	public static void updateEditeur(int id , String nom) throws SQLException{
		Connection conn = null;
		PreparedStatement preparedstatement = null;
		try{
			conn = ConnectionLivre.getConnection();

			preparedstatement = conn.prepareStatement("UPDATE editeur SET nom =? WHERE id = ?");
			preparedstatement.setString(1, nom);
			preparedstatement.setInt(2, id);
			int result = preparedstatement.executeUpdate();
			if(result ==0) System.out.println("Pas d'éditeur trouvé");
			
		}
		catch (Exception e){
			throw new SQLException("La mofication de l'éditeur n'a pas abouti");
		}
		finally{
				
				preparedstatement.close();
				conn.close();
		}
	}
}
