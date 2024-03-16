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
    @Test
    public void getPokemonMetadataTest() throws PokedexException {
        assertEquals(myDataProvider.getPokemonMetadata(0), bulbizarreMetadata);
        assertEquals(myDataProvider.getPokemonMetadata(133), aqualiMetadata);
    }
    @Test
    public void getPokemonMetadataIndexTest() throws PokedexException {
        assertEquals(myDataProvider.getPokemonMetadata(0).getIndex(), bulbizarreMetadata.getIndex());
    }
    @Test
    public void getPokemonMetadataNameTest() throws PokedexException {
        assertEquals(myDataProvider.getPokemonMetadata(0).getName(), bulbizarreMetadata.getName());
    }
    @Test
    public void getPokemonMetadataAttackTest() throws PokedexException {
        assertEquals(myDataProvider.getPokemonMetadata(0).getAttack(), bulbizarreMetadata.getAttack());
    }
    @Test
    public void getPokemonMetadataDefenseTest() throws PokedexException {
        assertEquals(myDataProvider.getPokemonMetadata(0).getDefense(), bulbizarreMetadata.getDefense());
    }
    @Test
    public void getPokemonMetadataStaminaTest() throws PokedexException {
        assertEquals(myDataProvider.getPokemonMetadata(0).getStamina(), bulbizarreMetadata.getStamina());
    }

}
