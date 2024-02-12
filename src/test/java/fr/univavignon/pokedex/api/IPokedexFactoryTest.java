package fr.univavignon.pokedex.api;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

public class IPokedexFactoryTest {
    IPokemonMetadataProvider myProvider;
    IPokedexFactory myPokedexFactory;
    IPokemonFactory myPokemonFactory;
    IPokedex returnedPokedex;

    @Before
    public void initTestEnvironment() {
        myProvider = Mockito.mock(IPokemonMetadataProvider.class);
        myPokedexFactory = Mockito.mock(IPokedexFactory.class);
        returnedPokedex = Mockito.mock(IPokedex.class);
        myPokemonFactory = Mockito.mock(IPokemonFactory.class);
        Mockito.when(myPokedexFactory.createPokedex(myProvider, myPokemonFactory)).thenReturn(returnedPokedex);
    }

    @Test
    public void createPokedexTest() {
        assertEquals(returnedPokedex, myPokedexFactory.createPokedex(myProvider, myPokemonFactory ));
    }
}
