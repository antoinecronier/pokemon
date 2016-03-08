package main.core.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import main.core.pokemon.Attaques;
import main.core.dao.AttaquesDAO;

public class AttaquesJDBC implements AttaquesDAO{

	@Override
	public ArrayList<Attaques> Select() {
		List<Attaques> attaques = new LinkedList<Attaques>();
        try {
               Statement statement = BaseJDBC.getInstance().EstablishConnection().createStatement();
               ResultSet resultSet = statement.executeQuery("SELECT * FROM pokemon.attaques");
                
               Attaques attaque = null;
               while(resultSet.next()){
            	   attaque = new Attaques();
            	   attaque.setId_attaques(Integer.parseInt(resultSet.getString("id_attaques")));
            	   attaque.setNom(resultSet.getString("nom"));
            	   attaque.setPuissance(Integer.parseInt(resultSet.getString("puissance")));
            	   attaque.setPrecision(Integer.parseInt(resultSet.getString("precis")));
            	   TypesJDBC types = new TypesJDBC();
            	   try {
            		   attaque.setType(types.Select(Integer.parseInt(resultSet.getString("id_types"))));
				} catch (Exception e) {
				}
            	   attaques.add(attaque);
               }
               resultSet.close();
               statement.close();
                
           } catch (SQLException e) {
               e.printStackTrace();
           }
           ArrayList<Attaques> returnAttaques = new ArrayList<Attaques>(attaques);
           return returnAttaques;
	}

	@Override
	public Attaques Select(Integer id_attaque) {
		Attaques attaque = null;
        try {
               Statement statement = BaseJDBC.getInstance().EstablishConnection().createStatement();
               ResultSet resultSet = statement.executeQuery("SELECT * FROM pokemon.attaques "
               		+ "WHERE pokemon.attaques.id_attaques = " + id_attaque);
                
               while(resultSet.next()){
            	   attaque = new Attaques();
            	   attaque.setId_attaques(Integer.parseInt(resultSet.getString("id_attaques")));
            	   attaque.setNom(resultSet.getString("nom"));
            	   attaque.setPuissance(Integer.parseInt(resultSet.getString("puissance")));
            	   attaque.setPrecision(Integer.parseInt(resultSet.getString("precis")));
            	   TypesJDBC types = new TypesJDBC();
            	   try {
            		   attaque.setType(types.Select(Integer.parseInt(resultSet.getString("id_types"))));
				} catch (Exception e) {
				}
               }
               resultSet.close();
               statement.close();
                
           } catch (SQLException e) {
               e.printStackTrace();
           }
           return attaque;
	}

	@Override
	public void Insert(ArrayList<Attaques> attaques) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete(ArrayList<Attaques> attaques) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(ArrayList<Attaques> attaques) {
		// TODO Auto-generated method stub
		
	}

}
