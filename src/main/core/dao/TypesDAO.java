package main.core.dao;

import java.util.ArrayList;

import main.core.pokemon.TypeDePokemons;
import main.core.pokemon.Types;

public interface TypesDAO {
	/**
	 * This is used to retrieve all Types under Mysql.
	 * @return
	 */
	public ArrayList<Types> Select();
	
	/**
	 * This is used to retrieve only one Types in Mysql by selecting is id.
	 * @param id_type
	 * @return
	 */
	public Types Select(Integer id_type);
	
	public void Insert(ArrayList<Types> types);
	public void Delete(ArrayList<Types> types);
	public void Update(ArrayList<Types> types);
}
