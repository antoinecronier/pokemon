package test.pokemontest;

import static org.junit.Assert.*;

import java.util.Locale;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.javafaker.Faker;

public class testing2 {

	String test;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Faker faker = new Faker();
		test = faker.sentence();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelect() {
		fail(test);
	}

	@Test
	public void testSelectInteger() {
		fail(test);
	}

	@Test
	public void testInsert() {
		fail(test);
	}

	@Test
	public void testDelete() {
		fail(test);
	}

	@Test
	public void testUpdate() {
		fail(test);
	}

}
