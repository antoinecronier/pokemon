package main.core.dao;

import java.util.ArrayList;

import main.core.pokemon.Positions;

public interface PositionsDAO {
	public ArrayList<Positions> Select();
	
	public Positions Select(Integer id_position);
}
