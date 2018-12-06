package dao;

import java.sql.SQLException;

public interface IlivreDAO {
	
	void getAllEditeur();
	void deleteEditeur(int id ) throws SQLException ;
	void insertEditeur(String name) throws SQLException;
	void updateEditeur(int id , String cat) throws SQLException;
	
	
}
