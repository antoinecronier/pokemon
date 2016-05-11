package test.pokemontest;

import static org.junit.Assert.*;
import main.core.pokemon.Pokemons;

import org.junit.Test;

public class TestItem1 {

	@Test
	public void testPokemonCreation() {
		assertNotNull(new Pokemons());
	}

}
