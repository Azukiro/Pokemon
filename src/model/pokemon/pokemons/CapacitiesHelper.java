package model.pokemon.pokemons;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.util.ArrayList;
import java.util.EnumSet;

import model.pokedex.Pokedex;


/**
 * @author billa
 *
 */
public class CapacitiesHelper {

	private static CapacityDeck capacityDeck;
	
	public static CapacityDeck getCapacityDeck() throws IOException {
		if (capacityDeck == null)
			capacityDeck = generate();
		return capacityDeck;
	}
	
	
	/**
	 * Function who generate Capcities of pokemons from an CVS File
	 * @return CapacityDeck
	 * @throws IOException
	 */
	
    private static CapacityDeck generate() throws IOException{
    	if(capacityDeck!=null) {//If the deck his already set we return him
    		return capacityDeck;
    	}
    	capacityDeck = new CapacityDeck();

        FileReader fReader = new FileReader(new File("CSV/moves.csv"));
        int i;
        String line;
        StringBuilder lineBuilder= new StringBuilder();
        while ((i=fReader.read())!=-1) {
            char c = (char)i;
            if(c == '\n') {
                line=lineBuilder.toString();

                    String[] tab =line.split("[,;]");
                    Capacity cap;
                    EnumPokemonType type;
                    try {
                        type= EnumPokemonType.fromString(tab[2]);
                      
                        cap=Capacity.instance(tab[1], !tab[3].equals("")?Integer.parseInt(tab[3]):0, !tab[4].equals("")?Integer.parseInt(tab[4]):0, !tab[5].equals("")?Integer.parseInt(tab[5]):0, CategoryCapacity.fromString(tab[6]),type);
                        if(capacityDeck.containsKey(type)) {//We create an capcity with the file and we add or put them to the deck
                        	capacityDeck.add(type,cap);
                        }else {
                        	capacityDeck.put(type, cap);
                        }
                    } catch (Exception e) {
                      
                    }

                lineBuilder=new StringBuilder();

            }
            else {
                lineBuilder.append(c);
            }
        }
        System.out.println("Cpacity Helpier"+capacityDeck);
        return capacityDeck;
    }

}