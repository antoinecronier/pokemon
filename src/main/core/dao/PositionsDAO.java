package main.core.dao;

import java.util.ArrayList;

import main.core.pokemon.Pokemons;
import main.core.pokemon.Positions;

public interface PositionsDAO {
	public ArrayList<Positions> Select();
	
	public Positions Select(Integer id_position);
	
	public void Insert(ArrayList<Positions> positions);
	public void Delete(ArrayList<Positions> positions);
	public void Update(ArrayList<Positions> positions);
}
