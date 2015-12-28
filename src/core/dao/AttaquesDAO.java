package core.dao;

import java.util.ArrayList;

import core.pokemon.Attaques;


public interface AttaquesDAO {
	public ArrayList<Attaques> Select();
	
	public Attaques Select(Integer id_attaque);
}
