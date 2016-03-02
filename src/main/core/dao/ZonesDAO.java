package main.core.dao;

import java.util.ArrayList;

import main.core.pokemon.Types;
import main.core.pokemon.Zones;

public interface ZonesDAO {
	public ArrayList<Zones> Select();
	
	public Zones Select(Integer id_zone);
	
	public void Insert(ArrayList<Zones> zones);
	public void Delete(ArrayList<Zones> zones);
	public void Update(ArrayList<Zones> zones);
}
