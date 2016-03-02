package main.core.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import main.core.dao.DresseursDAO;
import main.core.pokemon.Dresseurs;
import main.core.pokemon.Pokemons;

public class DresseursJDBC extends BaseJDBC implements DresseursDAO {

	@Override
	public ArrayList<Dresseurs> Select() {
		List<Dresseurs> dresseurs
		= new LinkedList<Dresseurs>();
		try {
			Statement statement = super.EstablishConnection().createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM pokemon.dresseurs");

			Dresseurs dresseur = null;
			while (resultSet.next()) {
				dresseur = new Dresseurs();
				dresseur.setId_dresseur(Integer.parseInt(resultSet
						.getString("id_dresseur")));
				dresseur.setNom(resultSet.getString("nom"));
				dresseurs.add(dresseur);
			}
			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<Dresseurs> returnDresseurs = new ArrayList<Dresseurs>(dresseurs);
		return returnDresseurs;
	}

	@Override
	public Dresseurs Select(Integer id_dresseur) {
		Dresseurs dresseur = null;
		try {
			Statement statement = super.EstablishConnection().createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM pokemon.dresseurs where pokemon.dresseurs.id_dresseur = " + id_dresseur);

			while (resultSet.next()) {
				dresseur = new Dresseurs();
				dresseur.setId_dresseur(Integer.parseInt(resultSet
						.getString("id_dresseur")));
				dresseur.setNom(resultSet.getString("nom"));
			}
			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dresseur;
	}

	@Override
	public ArrayList<Dresseurs> SelectWithPokemons() {
		List<Dresseurs> dresseurs
		= new LinkedList<Dresseurs>();
		try {
			Statement statement = super.EstablishConnection().createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM pokemon.dresseurs");

			Dresseurs dresseur = null;
			
			PokemonsJDBC pokemonsJDBC = new PokemonsJDBC();
			ArrayList<Pokemons> pokemons = pokemonsJDBC.Select();
			
			while (resultSet.next()) {
				dresseur = new Dresseurs();
				dresseur.setId_dresseur(Integer.parseInt(resultSet
						.getString("id_dresseur")));
				dresseur.setNom(resultSet.getString("nom"));
				
				for (Pokemons pokemon : pokemons) {
					if (pokemon.getId_dresseurs() == dresseur.getId_dresseur()) {
						dresseur.getPokemons().add(pokemon);
					}
				}
				
				dresseurs.add(dresseur);
			}
			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<Dresseurs> returnDresseurs = new ArrayList<Dresseurs>(dresseurs);
		return returnDresseurs;
	}

	@Override
	public Dresseurs SelectWithPokemons(Integer id_dresseur) {
		Dresseurs dresseur = null;
		try {
			Statement statement = super.EstablishConnection().createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM pokemon.dresseurs where pokemon.dresseurs.id_dresseur = " + id_dresseur);

			PokemonsJDBC pokemonsJDBC = new PokemonsJDBC();
			ArrayList<Pokemons> pokemons = pokemonsJDBC.Select();
			
			while (resultSet.next()) {
				dresseur = new Dresseurs();
				dresseur.setId_dresseur(Integer.parseInt(resultSet
						.getString("id_dresseur")));
				dresseur.setNom(resultSet.getString("nom"));
				
				for (Pokemons pokemon : pokemons) {
					if (pokemon.getId_dresseurs() == dresseur.getId_dresseur()) {
						dresseur.getPokemons().add(pokemon);
					}
				}
			}
			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dresseur;
	}

	@Override
	public void Insert(ArrayList<Dresseurs> dresseurs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete(ArrayList<Dresseurs> dresseurs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(ArrayList<Dresseurs> dresseurs) {
		// TODO Auto-generated method stub
		
	}

}
