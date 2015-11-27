package dao;

import java.util.ArrayList;

import pokemon.Badges;

public interface BadgesDAO {
	public ArrayList<Badges> Select();
	
	public Badges Select(Integer id_badge);
}
