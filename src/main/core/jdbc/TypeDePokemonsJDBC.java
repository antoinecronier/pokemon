package main.core.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import main.core.pokemon.TypeDePokemons;
import main.core.pokemon.Types;
import main.core.dao.TypeDePokemonsDAO;

public class TypeDePokemonsJDBC extends BaseJDBC implements TypeDePokemonsDAO {

	@Override
	public ArrayList<TypeDePokemons> Select() {
		List<TypeDePokemons> typeDePokemons = new LinkedList<TypeDePokemons>();
		try {
			Statement statement = super.EstablishConnection().createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM pokemon.typedepokemons");

			TypeDePokemons typeDePokemon = null;
			while (resultSet.next()) {
				typeDePokemon = new TypeDePokemons();
				typeDePokemon.setId_type_pokemons(Integer.parseInt(resultSet
						.getString("id_type_pokemons")));
				typeDePokemon.setNom(resultSet.getString("nom"));
				typeDePokemon.setAttaque(Integer.parseInt(resultSet
						.getString("attaque")));
				typeDePokemon.setAttaque_spe(Integer.parseInt(resultSet
						.getString("attaque_spe")));
				typeDePokemon.setDefence(Integer.parseInt(resultSet
						.getString("defence")));
				typeDePokemon.setDefence_spe(Integer.parseInt(resultSet
						.getString("defence_spe")));
				typeDePokemon.setEstDeType(EstDeType(typeDePokemon
						.getId_type_pokemons()));
				typeDePokemon
						.setPv(Integer.parseInt(resultSet.getString("pv")));
				typeDePokemon.setVitesse(Integer.parseInt(resultSet
						.getString("vitesse")));
				typeDePokemons.add(typeDePokemon);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<TypeDePokemons> returnTypeDePokemons = new ArrayList<TypeDePokemons>(
				typeDePokemons);
		return returnTypeDePokemons;
	}

	private ArrayList<Types> EstDeType(int id_type_pokemons) {
		TypesJDBC typesJDBC = new TypesJDBC();
		ArrayList<Types> typesToReturn = new ArrayList<Types>();
		
		try {
			Statement statement = super.EstablishConnection().createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM pokemon.possedelestypes "
							+ "WHERE pokemon.possedelestypes.id_type_pokemons = " + id_type_pokemons);
			while (resultSet.next()) {
				typesToReturn.add(typesJDBC.Select(Integer.parseInt(resultSet.getString("id_types"))));
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return typesToReturn;
	}

	@Override
	public TypeDePokemons Select(Integer id_type_de_pokemon) {
		// TODO Auto-generated method stub
		return null;
	}

}
