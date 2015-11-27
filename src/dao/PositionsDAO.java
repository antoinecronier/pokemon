package dao;

import java.util.ArrayList;

import pokemon.Positions;

public interface PositionsDAO {
	public ArrayList<Positions> Select();
	
	public Positions Select(Integer id_position);
}
