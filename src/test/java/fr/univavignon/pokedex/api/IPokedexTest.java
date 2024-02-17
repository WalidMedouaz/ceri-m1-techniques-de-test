package fr.univavignon.pokedex.api;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

import org.mockito.Mockito;
import java.util.ArrayList;

public class IPokedexTest {
    IPokedex myPokedex;
    Pokemon myBulbizarre;
    Pokemon myAquali;
    ArrayList<Pokemon> myArrayList;

    @Before
    public void initTestEnvironment() throws PokedexException {
        myPokedex = Mockito.mock(IPokedex.class);
        myBulbizarre = new Pokemon(0, "Bulbizarre", 126,126,90,613,64,4000,4,56);
        myAquali = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
        myArrayList = new ArrayList<Pokemon>();

        myArrayList.add(myBulbizarre);
        myArrayList.add(myAquali);

        Mockito.when(myPokedex.getPokemons()).thenReturn(myArrayList);
        Mockito.when(myPokedex.size()).thenReturn(myArrayList.size());

        Mockito.when(myPokedex.addPokemon(any(Pokemon.class))).thenAnswer(input -> {
            Pokemon inputPokemon = input.getArgument(0);
            myArrayList.add(inputPokemon);
            return myArrayList.size() - 1;
        });

        Mockito.when(myPokedex.getPokemon(any(Integer.class))).thenAnswer(input -> {
            int index = input.getArgument(0);
            return myArrayList.get(index);
        });
    }
    @Test
    public void addPokemonTest() throws PokedexException {
        int index = myPokedex.addPokemon(myBulbizarre);
        assertEquals(myBulbizarre, myPokedex.getPokemon(index));
    }

    @Test
    public void sizeTest() {
        assertEquals(myPokedex.size(), myArrayList.size());
    }
    @Test
    public void getPokemonTest() throws PokedexException {
        Pokemon p = myPokedex.getPokemon(0);
        assertEquals(p, myArrayList.get(0));
    }

    @Test
    public void getPokemonsTest() throws PokedexException {
        myPokedex.addPokemon(myBulbizarre);
        assertEquals(myPokedex.getPokemons(), myArrayList);
    }

}
