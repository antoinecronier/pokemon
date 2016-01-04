package core.dao;

import java.util.ArrayList;

import core.pokemon.Dresseurs;

public interface DresseursDAO {
	public ArrayList<Dresseurs> Select();
	
	public Dresseurs Select(Integer id_dresseur);
}
