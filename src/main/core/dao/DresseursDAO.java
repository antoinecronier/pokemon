package main.core.dao;

import java.util.ArrayList;

import main.core.pokemon.Badges;
import main.core.pokemon.Dresseurs;

public interface DresseursDAO {
	public ArrayList<Dresseurs> Select();
	public ArrayList<Dresseurs> SelectWithPokemons();
	
	public Dresseurs Select(Integer id_dresseur);
	public Dresseurs SelectWithPokemons(Integer id_dresseur);
	
	public ArrayList<Dresseurs> Insert(ArrayList<Dresseurs> dresseurs);
	public void Delete(ArrayList<Dresseurs> dresseurs);
	public void Update(ArrayList<Dresseurs> dresseurs);
	
	public void InsertWhitPokemons(ArrayList<Dresseurs> dresseurs);
}
