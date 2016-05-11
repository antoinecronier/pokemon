package test.pokemontest;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

import main.core.jdbc.AttaquesJDBC;
import main.core.pokemon.Attaques;

import org.junit.Assert;
import org.junit.Test;

public class TestAttaquesDAO {

	@Test
	public void test() {
		AttaquesJDBC test = new AttaquesJDBC();
		
		ArrayList<Attaques> attaqueBDD = new ArrayList<Attaques>();
		attaqueBDD.add(new Attaques());
		
		Assert.assertEquals(test.Select(), attaqueBDD);
	}
}
