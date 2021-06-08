package model.pokemon.pokemons;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import model.pokedex.Pokedex;

public class CapacityDeck{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final HashMap<EnumPokemonType,Set<Capacity>> hashMap =new HashMap<EnumPokemonType, Set<Capacity>>();

	public void add(EnumPokemonType type, Capacity cap) {
		var x=hashMap.get(type);
				x.add(cap);	
	}
	
	public boolean containsKey(EnumPokemonType e) {
		return hashMap.containsKey(e);
	}
	
	/**
	 * Put the capcity in link with the specified key
	 * @param key
	 * @param value
	 * @return Set<Capacity> who correspond to the key asked
	 */
	public Set<Capacity> put(EnumPokemonType key, Capacity value) {
		// TODO Auto-generated method stub
		var x=new HashSet<Capacity>();
		x.add(value);
		return hashMap.put(key, x);
	}
	
	
	/**
	 * Give  capcities that correspond to the specifique pokemonType and also the NormalType
	 * @param types
	 * @return
	 */
	public Set<Capacity> get(PokemonType types){
		Set<Capacity> capacities=new HashSet<Capacity>();
		
		while (types.hasNext()) {
			EnumPokemonType type=types.next();
			capacities.addAll(hashMap.get(type));
			
		}
		capacities.addAll(hashMap.get(EnumPokemonType.NORMAL));
		types.resetIterator();
		return capacities;
	}
	
	
	
}