package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import pokemon.Types;
import dao.TypesDAO;

public class TypesJDBC implements TypesDAO {

	private Connection connection = null;

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			if (connection == null)
				connection = DriverManager
						.getConnection("jdbc:mysql://localhost/pokemon?user=root&password=");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return connection;
	}

	@Override
	public Types select(int id_type) {
		Types type = null;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM pokemon.types "
							+ "WHERE pokemon.types.id_types = " + id_type);

			while (resultSet.next()) {
				type = new Types();
				type.setId_types(Integer.parseInt(resultSet
						.getString("id_types")));
				type.setNom(resultSet.getString("nom"));
				type.setFortContre(this.selectFort(type.getId_types()));
				type.setFaibleContre(this.selectFaible(type.getId_types()));
			}
			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return type;
	}

	@Override
	public ArrayList<Types> select() {
		List<Types> types = new LinkedList<Types>();
        try {
               Statement statement = connection.createStatement();
               ResultSet resultSet = statement.executeQuery("SELECT * FROM pokemon.types");
                
               Types type = null;
               while(resultSet.next()){
            	   type = new Types();
            	   type.setId_types(Integer.parseInt(resultSet.getString("id_types")));
            	   type.setNom(resultSet.getString("nom"));
            	   type.setFortContre(this.selectFort(type.getId_types()));
            	   type.setFaibleContre(this.selectFaible(type.getId_types()));
            	   types.add(type);
               }
               resultSet.close();
               statement.close();
                
           } catch (SQLException e) {
               e.printStackTrace();
           }
           ArrayList<Types> returnTypes = new ArrayList<Types>(types);
           return returnTypes;
	}
	
	public ArrayList<Types> selectFort(int id) {
		List<Types> types = new LinkedList<Types>();
        try {
               Statement statement = connection.createStatement();
               ResultSet resultSet = statement.executeQuery("SELECT * FROM pokemon.fortcontre "
               		+ "INNER JOIN pokemon.types ON pokemon.fortcontre.id_types_faible = pokemon.types.id_types "
               		+ "WHERE pokemon.fortcontre.id_types_base = " + id);
                
               Types type = null;
               while(resultSet.next()){
            	   type = new Types();
            	   type.setId_types(Integer.parseInt(resultSet.getString("id_types")));
            	   type.setNom(resultSet.getString("nom"));
            	   types.add(type);
               }
               resultSet.close();
               statement.close();
                
           } catch (SQLException e) {
               e.printStackTrace();
           }
           ArrayList<Types> returnTypes = new ArrayList<Types>(types);
           return returnTypes;
	}
	
	public ArrayList<Types> selectFaible(int id) {
		List<Types> types = new LinkedList<Types>();
        try {
               Statement statement = connection.createStatement();
               ResultSet resultSet = statement.executeQuery("SELECT * FROM pokemon.faiblecontre "
               		+ "INNER JOIN pokemon.types ON pokemon.faiblecontre.id_types_fort = pokemon.types.id_types "
               		+ "WHERE pokemon.faiblecontre.id_types_base = " + id);
                
               Types type = null;
               while(resultSet.next()){
            	   type = new Types();
            	   type.setId_types(Integer.parseInt(resultSet.getString("id_types")));
            	   type.setNom(resultSet.getString("nom"));
            	   types.add(type);
               }
               resultSet.close();
               statement.close();
                
           } catch (SQLException e) {
               e.printStackTrace();
           }
           ArrayList<Types> returnTypes = new ArrayList<Types>(types);
           return returnTypes;
	}

	public void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			// do nothing
		}
	}
}
