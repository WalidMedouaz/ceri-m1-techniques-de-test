package fr.univavignon.pokedex.api;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import java.util.ArrayList;

public class IPokedexTest {
    IPokedex myPokedex;
    Pokemon myBulbizarre;
    Pokemon myAquali;
    ArrayList<Pokemon> myArrayList;

    @Before
    public void initTestEnvironment() {
        myPokedex = Mockito.mock(IPokedex.class);
        myBulbizarre = new Pokemon(0, "Bulbizarre", 126,126,90,613,64,4000,4,56);
        myAquali = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
        myArrayList = new ArrayList<Pokemon>();
    }




}
