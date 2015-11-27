package dao;

import java.util.ArrayList;

import pokemon.Dresseurs;

public interface DresseursDAO {
	public ArrayList<Dresseurs> Select();
	
	public Dresseurs Select(Integer id_dresseur);
}
