package model.fight;

import java.io.Serializable;
import java.util.Arrays;

import model.pokemon.pokemons.Pokemon;

public class Trainer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Pokemon[] pokemons;
	private int currentPokemon;
	private final String name;

	public Trainer(String name, Pokemon[] pokemons) {
		this.name=name;
		
		if(pokemons.length>6) {
			throw new IllegalArgumentException("A trainer can't have more than 6 pokemons");
		}
		this.pokemons = pokemons;
		currentPokemon=0;
	}
	

	public Pokemon getPokemon() {
		return pokemons[currentPokemon];
	}
	
	public Pokemon getPokemon(int i) {
		return pokemons[i];
	}
	
	public int teamSize() {
		return pokemons.length;
	}
	
	public boolean isPokemonAlive(int i) {
		if(pokemons[i]!=null) {
			return pokemons[i].isAlive();
		}
		return false;
	}
	
	/**
	 * Replace the current Pokemon by another one
	 * @param i Place of the new Pokemon in the team
	 * @return Pokemon Current Pokemon
	 */
	public Pokemon changePokemon(int i) {
		currentPokemon=i;
		return pokemons[currentPokemon];
	}
	
	/**
	 * Restore life of all the pokemons of the trainer
	 * @param 
	 * @return void
	 */
	public void restoreTrainer() {
		for (Pokemon pokemon : pokemons) {
			pokemon.restore();
		}

	}

	@Override
	public String toString() {
		return "Trainer [pokemons=" + Arrays.toString(pokemons) + ", currentPokemon=" + currentPokemon + "]";
	}
	
	/**
	 * Check if the player loose the game
	 * @param 
	 * @return boolean Result
	 */
	public boolean loose() {
		for (Pokemon pokemon : pokemons) {
			if(pokemon!=null && pokemon.isAlive()) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Check if there is only on pokemon alive left
	 * @param 
	 * @return boolean Result
	 */
	public boolean onlyOnePokemonAlive() {
		int count =0;
		for (Pokemon pokemon : pokemons) {
			if(pokemon!=null && pokemon.isAlive()) {
				count+=1;
			}
		}
		if(count==1) {
			return true;
		}
		return false;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + currentPokemon;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Arrays.hashCode(pokemons);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trainer other = (Trainer) obj;
		if (currentPokemon != other.currentPokemon)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (!Arrays.equals(pokemons, other.pokemons))
			return false;
		return true;
	}

	
	
	

}
