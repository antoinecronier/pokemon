package dao;

import java.util.ArrayList;

import pokemon.Attaques;


public interface AttaquesDAO {
	public ArrayList<Attaques> Select();
	
	public Attaques Select(Integer id_attaque);
}
