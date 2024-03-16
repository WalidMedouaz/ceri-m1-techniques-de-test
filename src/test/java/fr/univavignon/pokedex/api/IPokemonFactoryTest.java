package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IPokemonFactoryTest {

    IPokemonFactory myPokemonFactory;
    Pokemon myBulbizarre;
    Pokemon myAquali;
    @Before
    public void initTestEnvironment() {
        myPokemonFactory = new PokemonFactory();
        myBulbizarre = new Pokemon(0, "Bulbizarre", 126,126,90,613,64,4000,4,56);
        myAquali = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
    }
    @Test
    public void createPokemonTest() {
        assertNotNull(myPokemonFactory.createPokemon(0, 613, 64, 4000, 4));
        assertNotNull(myPokemonFactory.createPokemon(133, 2729, 202, 5000, 4));
    }
    @Test
    public void getCpTest() {
        assertEquals(myPokemonFactory.createPokemon(0, 613, 64, 4000, 4).getCp(), myBulbizarre.getCp());
    }
    @Test
    public void getHpTest() {
        assertEquals(myPokemonFactory.createPokemon(0, 613, 64, 4000, 4).getHp(), myBulbizarre.getHp());
    }
    @Test
    public void getDustTest() {
        assertEquals(myPokemonFactory.createPokemon(0, 613, 64, 4000, 4).getDust(), myBulbizarre.getDust());
    }
    @Test
    public void getCandyTest() {
        assertEquals(myPokemonFactory.createPokemon(0, 613, 64, 4000, 4).getCandy(), myBulbizarre.getCandy());
    }
    @Test
    public void getIvTest() {
        double delta = 0;
        assertEquals(myPokemonFactory.createPokemon(0, 613, 64, 4000, 4).getIv(), myBulbizarre.getIv(), delta);
    }
    @Test
    public void throwPokedexException() {
        myPokemonFactory.createPokemon(192, 0, 0, 0, 0);
    }

}
