package main.core.dao;

import java.util.ArrayList;

import main.core.pokemon.Attaques;


public interface AttaquesDAO {
	public ArrayList<Attaques> Select();
	
	public Attaques Select(Integer id_attaque);
}
