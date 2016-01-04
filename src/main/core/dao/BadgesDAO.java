package main.core.dao;

import java.util.ArrayList;

import main.core.pokemon.Badges;

public interface BadgesDAO {
	public ArrayList<Badges> Select();
	
	public Badges Select(Integer id_badge);
}
