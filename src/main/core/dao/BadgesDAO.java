package main.core.dao;

import java.util.ArrayList;

import main.core.pokemon.Attaques;
import main.core.pokemon.Badges;

public interface BadgesDAO {
	public ArrayList<Badges> Select();
	
	public Badges Select(Integer id_badge);
	
	public void Insert(ArrayList<Badges> badges);
	public void Delete(ArrayList<Badges> badges);
	public void Update(ArrayList<Badges> badges);
}
