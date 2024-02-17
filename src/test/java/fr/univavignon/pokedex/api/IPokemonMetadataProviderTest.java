package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.ArgumentMatchers.any;

public class IPokemonMetadataProviderTest {

    IPokemonMetadataProvider myDataProvider;
    PokemonMetadata bulbizarreMetadata;
    PokemonMetadata aqualiMetadata;
    @Before
    public void initTestEnvironment() throws PokedexException {
        myDataProvider = Mockito.mock(IPokemonMetadataProvider.class);

        bulbizarreMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126,90);
        aqualiMetadata = new PokemonMetadata(133,"Aquali",186,168,260);

        Mockito.when(myDataProvider.getPokemonMetadata(any(Integer.class))).thenAnswer(input -> {
            int inputMetadata = input.getArgument(0);
            if(inputMetadata == 0) {
                return bulbizarreMetadata;
            }
            else if(inputMetadata == 133){
                return aqualiMetadata;
            }
            else {
                throw new PokedexException("Index inexistant !");
            }
        });
    }

    @Test
    public void PokedexExceptionTest() throws PokedexException {
        assertThrows(PokedexException.class, () -> myDataProvider.getPokemonMetadata(126));
    }
}
