package core.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import core.pokemon.Types;
import core.dao.TypesDAO;

public class TypesJDBC extends BaseJDBC implements TypesDAO {

	@Override
	public Types Select(Integer id_type) {
		Types type = null;
		try {
			Statement statement = super.EstablishConnection().createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM pokemon.types WHERE pokemon.types.id_types = " + id_type);

			while (resultSet.next()) {
				type = new Types();
				type.setId_types(Integer.parseInt(resultSet
						.getString("id_types")));
				type.setNom(resultSet.getString("nom"));
				type.setFortContre(this.SelectFort(type.getId_types()));
				type.setFaibleContre(this.SelectFaible(type.getId_types()));
			}
			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return type;
	}

	@Override
	public ArrayList<Types> Select() {
		List<Types> types = new LinkedList<Types>();
        try {
               Statement statement = super.EstablishConnection().createStatement();
               ResultSet resultSet = statement.executeQuery("SELECT * FROM pokemon.types");
                
               Types type = null;
               while(resultSet.next()){
            	   type = new Types();
            	   type.setId_types(Integer.parseInt(resultSet.getString("id_types")));
            	   type.setNom(resultSet.getString("nom"));
            	   type.setFortContre(this.SelectFort(type.getId_types()));
            	   type.setFaibleContre(this.SelectFaible(type.getId_types()));
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
	
	public ArrayList<Types> SelectFort(int id) {
		List<Types> types = new LinkedList<Types>();
        try {
               Statement statement = super.EstablishConnection().createStatement();
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
	
	public ArrayList<Types> SelectFaible(int id) {
		List<Types> types = new LinkedList<Types>();
        try {
               Statement statement = super.EstablishConnection().createStatement();
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
}
