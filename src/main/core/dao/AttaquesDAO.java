package main.core.dao;

import java.util.ArrayList;

import main.core.pokemon.Attaques;


public interface AttaquesDAO {
	public ArrayList<Attaques> Select();
	
	public Attaques Select(Integer id_attaque);
	
	public void Insert(ArrayList<Attaques> attaques);
	public void Delete(ArrayList<Attaques> attaques);
	public void Update(ArrayList<Attaques> attaques);
}
