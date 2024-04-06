package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.collections4.map.UnmodifiableMap;

/**
 * Implementation of IPokemonFactory provided by Team Rocket.
 */
public class RocketPokemonFactory implements IPokemonFactory {

	// Mapping from Pokémon index to Pokémon name
	private static Map<Integer, String> indexToName;
	static {
		Map<Integer, String> aMap = new HashMap<>();
		aMap.put(-1, "Ash's Pikachu");
		aMap.put(0, "MISSINGNO");
		aMap.put(1, "Bulbasaur");
		indexToName = UnmodifiableMap.unmodifiableMap(aMap);
	}

	/**
	 * Generates a random number between 0 and 999 for Pokémon stats.
	 * @return the randomly generated stat
	 */
	private static int generateRandomStat() {
		Random random = new Random();
		return random.nextInt(1000);
	}

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		String name;
		if(!indexToName.containsKey(index)) {
			name = indexToName.get(0);
		} else {
			name = indexToName.get(index);
		}
		int attack;
		int defense;
		int stamina;
		double iv;
		if(index < 0) {
			attack = 1000;
			defense = 1000;
			stamina = 1000;
			iv = 0;
		} else {
			attack = generateRandomStat();
			defense = generateRandomStat();
			stamina = generateRandomStat();
			iv = 1;
		}
		return new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);
	}

}
