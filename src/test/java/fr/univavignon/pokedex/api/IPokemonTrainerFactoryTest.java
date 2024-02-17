package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {

    IPokemonTrainerFactory myTrainerFactory;
    IPokedex myPokedex;
    IPokedexFactory myPokedexFactory;
    PokemonTrainer myPokemonTrainer;
    String name;
    Team team;

    @Before
    public void initTestEnvironment() {
        myTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
        myPokedex = Mockito.mock(IPokedex.class);
        myPokedexFactory = Mockito.mock(IPokedexFactory.class);

        team = Team.MYSTIC;
        name = "TrainerName";

        myPokemonTrainer = new PokemonTrainer(name, team, myPokedex);
        Mockito.when(myTrainerFactory.createTrainer(name, team, myPokedexFactory)).thenReturn(myPokemonTrainer);
    }

    @Test
    public void createTrainerTest() {
        assertEquals(myTrainerFactory.createTrainer(name, team, myPokedexFactory), myPokemonTrainer);
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
        assertEquals(myTrainerFactory.createTrainer(name, team, myPokedexFactory).getPokedex(), myPokemonTrainer.getPokedex());
    }
}
