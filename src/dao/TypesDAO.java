package dao;

import java.util.ArrayList;

import pokemon.Types;

public interface TypesDAO {
	/**
	 * This is used to retrieve all Types under Mysql.
	 * @return
	 */
	public ArrayList<Types> select();
	
	/**
	 * This is used to retrieve only one Types in Mysql by selecting is id.
	 * @param id_type
	 * @return
	 */
	public Types select(int id_type);
}
