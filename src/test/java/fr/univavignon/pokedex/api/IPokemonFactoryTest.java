package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class IPokemonFactoryTest {

    IPokemonFactory myPokemonFactory;
    Pokemon myBulbizarre;
    Pokemon myAquali;
    @Before
    public void initTestEnvironment() {
        myPokemonFactory = Mockito.mock(IPokemonFactory.class);
        myBulbizarre = new Pokemon(0, "Bulbizarre", 126,126,90,613,64,4000,4,56);
        myAquali = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);

        Mockito.when(myPokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(myBulbizarre);
        Mockito.when(myPokemonFactory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(myAquali);
    }
    @Test
    public void createPokemonTest() {
        assertEquals(myPokemonFactory.createPokemon(0, 613, 64, 4000, 4), myBulbizarre);
        assertEquals(myPokemonFactory.createPokemon(133, 2729, 202, 5000, 4), myAquali);
    }

}
