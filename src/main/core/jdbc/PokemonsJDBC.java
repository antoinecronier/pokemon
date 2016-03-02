package main.core.jdbc;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import main.core.pokemon.Attaques;
import main.core.pokemon.Pokemons;
import main.core.pokemon.TypeDePokemons;
import main.core.dao.PokemonsDAO;

public class PokemonsJDBC extends BaseJDBC implements PokemonsDAO {

	@Override
	public ArrayList<Pokemons> Select() {
		List<Pokemons> pokemons = new LinkedList<Pokemons>();
		try {
			Statement statement = super.EstablishConnection().createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM pokemon.pokemons");

			Pokemons pokemon = null;
			while (resultSet.next()) {
				// TODO update with Attaques classe
				pokemon = new Pokemons();
				pokemon.setId_pokemons(Integer.parseInt(resultSet
						.getString("id_pokemons")));
				pokemon.setSurnom(resultSet.getString("surnom"));
				pokemon.setCapture(Date.valueOf(resultSet.getString("capture")));
				pokemon.setNiveau(Integer.parseInt(resultSet
						.getString("niveau")));
				pokemon.setId_dresseurs(resultSet.getInt("id_dresseur"));
				
				// pokemon.setTypeDePokemon(SelectTypeDePokemon(pokemon.getId_pokemons()));
				ArrayList<Attaques> attaques = new ArrayList<Attaques>();
				AttaquesJDBC selectAttaques = new AttaquesJDBC();
				attaques.add(selectAttaques.Select(Integer.parseInt(resultSet
						.getString("id_attaques_1"))));
				attaques.add(selectAttaques.Select(Integer.parseInt(resultSet
						.getString("id_attaques_2"))));
				attaques.add(selectAttaques.Select(Integer.parseInt(resultSet
						.getString("id_attaques_3"))));
				attaques.add(selectAttaques.Select(Integer.parseInt(resultSet
						.getString("id_attaques_4"))));
				pokemon.setAttaques(attaques);
				pokemons.add(pokemon);
			}
			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<Pokemons> returnPokemons = new ArrayList<Pokemons>(pokemons);
		return returnPokemons;
	}

	@Override
	public Pokemons Select(Integer id_pokemon) {
		Pokemons pokemon = new Pokemons();
		try {
			Statement statement = super.EstablishConnection().createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM pokemon.pokemons WHERE pokemon.pokemons.id_pokemons = "+ id_pokemon);

			while (resultSet.next()) {
				// TODO update with Attaques classe
				pokemon = new Pokemons();
				pokemon.setId_pokemons(Integer.parseInt(resultSet
						.getString("id_pokemons")));
				pokemon.setSurnom(resultSet.getString("surnom"));
				pokemon.setCapture(Date.valueOf(resultSet.getString("capture")));
				pokemon.setNiveau(Integer.parseInt(resultSet
						.getString("niveau")));
				// pokemon.setTypeDePokemon(SelectTypeDePokemon(pokemon.getId_pokemons()));
				ArrayList<Attaques> attaques = new ArrayList<Attaques>();
				AttaquesJDBC selectAttaques = new AttaquesJDBC();
				attaques.add(selectAttaques.Select(Integer.parseInt(resultSet
						.getString("id_attaques_1"))));
				attaques.add(selectAttaques.Select(Integer.parseInt(resultSet
						.getString("id_attaques_2"))));
				attaques.add(selectAttaques.Select(Integer.parseInt(resultSet
						.getString("id_attaques_3"))));
				attaques.add(selectAttaques.Select(Integer.parseInt(resultSet
						.getString("id_attaques_4"))));
				pokemon.setAttaques(attaques);
			}
			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pokemon;
	}

	@Override
	public void Insert(ArrayList<Pokemons> pokemons) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete(ArrayList<Pokemons> pokemons) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(ArrayList<Pokemons> pokemons) {
		// TODO Auto-generated method stub
		
	}

}
