package core.dao;

import java.util.ArrayList;

import core.pokemon.Types;

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
}
