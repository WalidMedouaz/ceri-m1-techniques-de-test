package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IPokemonTrainerFactoryTest {

    IPokemonTrainerFactory myTrainerFactory;
    IPokedexFactory myPokedexFactory;
    PokemonTrainer myPokemonTrainer;
    String name;
    Team team;

    @Before
    public void initTestEnvironment() {
        myTrainerFactory = new PokemonTrainerFactory();
        myPokedexFactory = new PokedexFactory();

        team = Team.MYSTIC;
        name = "TrainerName";

        myPokemonTrainer = myTrainerFactory.createTrainer(name, team, myPokedexFactory);
    }

    @Test
    public void createTrainerTest() {
        assertNotNull(myTrainerFactory.createTrainer(name, team, myPokedexFactory));
    }

    @Test
    public void getNameTest() {
        assertEquals(myTrainerFactory.createTrainer(name, team, myPokedexFactory).getName(), myPokemonTrainer.getName());
    }

    @Test
    public void getTeam() {
        assertEquals(myTrainerFactory.createTrainer(name, team, myPokedexFactory).getTeam(), myPokemonTrainer.getTeam());
    }

    @Test
    public void getPokedex() {
        assertNotNull(myPokemonTrainer.getPokedex());
    }

}
