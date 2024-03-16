package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class IPokedexFactoryTest {
    IPokemonMetadataProvider pokemonMetadataProvider;
    IPokedexFactory pokedexFactory;
    IPokemonFactory pokemonFactory;
    IPokedex pokedex;

    @Before
    public void initTestEnvironment() {
        pokemonMetadataProvider = new PokemonMetadataProvider();
        pokedexFactory = new PokedexFactory();
        pokedex = new Pokedex(pokemonFactory, pokemonMetadataProvider);
        pokemonFactory = new PokemonFactory();
    }

    @Test
    public void createPokedexTest() {
        assertNotNull(pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory));
    }
}
