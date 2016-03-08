package main.core.jdbc;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import main.core.pokemon.Attaques;
import main.core.pokemon.Pokemons;
import main.core.pokemon.TypeDePokemons;
import main.core.dao.PokemonsDAO;

public class PokemonsJDBC implements PokemonsDAO {

	@Override
	public ArrayList<Pokemons> Select() {
		List<Pokemons> pokemons = new LinkedList<Pokemons>();
		try {
			Statement statement = BaseJDBC.getInstance().EstablishConnection().createStatement();
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
				pokemon.setId_type_de_pokemon(resultSet
						.getInt("id_type_pokemons"));

				TypeDePokemonsJDBC selectTypeDePokemonsJDBC = new TypeDePokemonsJDBC();
				pokemon.setTypeDePokemon(selectTypeDePokemonsJDBC
						.Select(pokemon.getId_type_de_pokemon()));

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
			Statement statement = BaseJDBC.getInstance().EstablishConnection().createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM pokemon.pokemons WHERE pokemon.pokemons.id_pokemons = "
							+ id_pokemon);

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
		try {
			PreparedStatement preparedStatement = (PreparedStatement) BaseJDBC.getInstance()
					.EstablishConnection()
					.prepareStatement(
							"INSERT INTO pokemon.pokemons (surnom, niveau, capture, id_dresseur, id_attaques_1, id_attaques_2, id_attaques_3, id_attaques_4, id_type_pokemons) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

			for (Pokemons pokemon : pokemons) {
				preparedStatement.setString(1, pokemon.getSurnom());
				preparedStatement.setInt(2, pokemon.getNiveau());
				preparedStatement.setDate(3, new java.sql.Date(pokemon
						.getCapture().getTime()));
				preparedStatement.setInt(4, pokemon.getId_dresseurs());
				preparedStatement.setInt(5, pokemon.getAttaques().get(0)
						.getId_attaques());
				preparedStatement.setInt(6, pokemon.getAttaques().get(1)
						.getId_attaques());
				preparedStatement.setInt(7, pokemon.getAttaques().get(2)
						.getId_attaques());
				preparedStatement.setInt(8, pokemon.getAttaques().get(3)
						.getId_attaques());
				preparedStatement.setInt(9, pokemon.getId_type_de_pokemon());

				preparedStatement.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void Delete(ArrayList<Pokemons> pokemons) {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) BaseJDBC.getInstance()
					.EstablishConnection()
					.prepareStatement(
							"DELETE FROM pokemon.pokemons WHERE pokemons.id_pokemons = ?");

			for (Pokemons pokemon : pokemons) {
				preparedStatement.setInt(1, pokemon.getId_pokemons());

				preparedStatement.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void Update(ArrayList<Pokemons> pokemons) {
		// TODO Auto-generated method stub

	}

}
