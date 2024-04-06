package fr.univavignon.pokedex.api;

import java.util.ArrayList;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    ArrayList<PokemonMetadata> pokemonMetadataArrayList;

    public PokemonMetadataProvider() {
        this.pokemonMetadataArrayList = new ArrayList<PokemonMetadata>();
        pokemonMetadataArrayList.add(new PokemonMetadata(0, "Bulbizarre", 126, 126,90));
        pokemonMetadataArrayList.add(new PokemonMetadata(133,"Aquali",186,168,260));
    }

    /**
     * Retrieves and returns the metadata for the pokemon
     * denoted by the given <code>index</code>.
     *
     * @param index Index of the pokemon to retrieve metadata for.
     * @return Metadata of the pokemon.
     * @throws PokedexException If the given <code>index</code> is not valid.
     */


    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if(index < 0 || index > 150) {
            throw new PokedexException("Index invalid !");
        }
        for(PokemonMetadata buffer : pokemonMetadataArrayList) {
            if(buffer.getIndex() == index) {
                return buffer;
            }
        }
        return null;
    }
}
