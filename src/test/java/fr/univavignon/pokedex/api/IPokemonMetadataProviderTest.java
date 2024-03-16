package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IPokemonMetadataProviderTest {

    IPokemonMetadataProvider myDataProvider;
    PokemonMetadata bulbizarreMetadata;
    PokemonMetadata aqualiMetadata;
    @Before
    public void initTestEnvironment() throws PokedexException {
        myDataProvider = new PokemonMetadataProvider();

        bulbizarreMetadata = myDataProvider.getPokemonMetadata(0);
        aqualiMetadata = myDataProvider.getPokemonMetadata(133);
    }

    @Test
    public void MetadataNotFoundTest() throws PokedexException {
        assertNull(myDataProvider.getPokemonMetadata(126));
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
    @Test
    public void throwPokedexException() {
        assertThrows(PokedexException.class, () -> {
            myDataProvider.getPokemonMetadata(-1);
        });
        assertThrows(PokedexException.class, () -> {
            myDataProvider.getPokemonMetadata(172);
        });
    }

}
