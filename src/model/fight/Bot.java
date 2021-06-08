package model.fight;

import java.util.ArrayList;
import java.util.Random;

import model.pokemon.pokemons.Capacity;
import model.pokemon.pokemons.Pokemon;
import model.pokemon.pokemons.PokemonSpecie;
import model.pokemon.pokemons.StatistiquePokemon;

public class Bot extends Trainer{
	
	public Bot(String name, Pokemon[] pokemons) {
		super(name, pokemons);
	}
	
	/**
	 * Select a capacity to play
	 * @param 
	 * @return Capacity The capacity used or null if no more usable
	 */
	public Capacity fight() {
		ArrayList<Capacity> usableCapacities = new ArrayList<Capacity>();
		for (Capacity capacity : getPokemon().getCapacities()) {
			if(capacity!=null && capacity.isUsable()) {
				usableCapacities.add(capacity);
			}
		}
		
		if(usableCapacities.size()==0) {
			return null;
		}
		
		Random random = new Random();
		return usableCapacities.get(random.nextInt(usableCapacities.size()));
	}
	
	/**
	 * Select a new Pokemon
	 * @param i No impact
	 * @return Pokemon Pokemon selected
	 */
	@Override
	public Pokemon changePokemon(int i) {
		ArrayList<Integer> usablePokemons = new ArrayList<Integer>();
		for (int j = 0; j < teamSize(); j++) {
			if(isPokemonAlive(j)) {
				usablePokemons.add(j);
			}
		}
		
		Random random = new Random();
		return super.changePokemon(usablePokemons.get(random.nextInt(usablePokemons.size())));
	}
}
