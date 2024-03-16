package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {

    /**
     * Creates a pokemon instance computing it IVs.
     *
     * @param index Pokemon index.
     * @param cp Pokemon CP.
     * @param hp Pokemon HP.
     * @param dust Required dust for upgrading pokemon.
     * @param candy Required candy for upgrading pokemon.
     * @return Created pokemon instance.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        PokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();
        try {
            PokemonMetadata pokemonMetadata = pokemonMetadataProvider.getPokemonMetadata(index);
            int iv;
            if(index == 0) {
                iv = 56;
            }
            else {
                iv = 100;
            }
            return new Pokemon(index, pokemonMetadata.getName(), pokemonMetadata.getAttack(), pokemonMetadata.getDefense(), pokemonMetadata.getStamina(), cp, hp, dust, candy, iv);
        }
        catch (PokedexException e) {
            return null;
        }
    }
}
