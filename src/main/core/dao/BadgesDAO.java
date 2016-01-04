package core.dao;

import java.util.ArrayList;

import core.pokemon.Badges;

public interface BadgesDAO {
	public ArrayList<Badges> Select();
	
	public Badges Select(Integer id_badge);
}
