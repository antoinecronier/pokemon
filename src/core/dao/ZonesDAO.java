package core.dao;

import java.util.ArrayList;

import core.pokemon.Zones;

public interface ZonesDAO {
	public ArrayList<Zones> Select();
	
	public Zones Select(Integer id_zone);
}
