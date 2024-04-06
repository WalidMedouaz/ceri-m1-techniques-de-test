package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RocketPokemonFactoryTest {

    RocketPokemonFactory rocketPokemonFactory;
    Pokemon myBulbizarre;
    Pokemon myAquali;
    @Before
    public void initTestEnvironment() {
        rocketPokemonFactory = new RocketPokemonFactory();
        myBulbizarre = new Pokemon(0, "Bulbizarre", 126,126,90,613,64,4000,4,56);
        myAquali = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
    }

    @Test
    public void createPokemonTest() {
        assertNotNull(rocketPokemonFactory.createPokemon(0, 613, 64, 4000, 4));
        assertNotNull(rocketPokemonFactory.createPokemon(133, 2729, 202, 5000, 4));
    }

    @Test
    public void negativeIndexTest() {
        assertEquals(1000, rocketPokemonFactory.createPokemon(-1, 613, 64, 4000, 4).getAttack());
        assertEquals(1000, rocketPokemonFactory.createPokemon(-1, 613, 64, 4000, 4).getDefense());
        assertEquals(1000, rocketPokemonFactory.createPokemon(-1, 613, 64, 4000, 4).getStamina());
        assertEquals(0, rocketPokemonFactory.createPokemon(-1, 613, 64, 4000, 4).getIv(), 0);
    }



}
