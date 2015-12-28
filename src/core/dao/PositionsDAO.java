package core.dao;

import java.util.ArrayList;

import core.pokemon.Positions;

public interface PositionsDAO {
	public ArrayList<Positions> Select();
	
	public Positions Select(Integer id_position);
}
