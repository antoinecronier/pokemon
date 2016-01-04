package main.core.dao;

import java.util.ArrayList;

import main.core.pokemon.Dresseurs;

public interface DresseursDAO {
	public ArrayList<Dresseurs> Select();
	
	public Dresseurs Select(Integer id_dresseur);
}
