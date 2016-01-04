package pokemontest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestPokemonDBA {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		assertFalse(false);
	}

	@Test
	public void test1() {
		int a = 1;
		a += 1;
		assertTrue(a == 2);
	}
}
