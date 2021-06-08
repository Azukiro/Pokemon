package model.pokemon.pokemons;

import java.io.Serializable;
import java.util.Arrays;


public class Pokemon implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final PokemonSpecie specie;
	private final Capacity[] capacities;
	private final StatistiquePokemon stat;
	private final String nickName;
	
	public Pokemon(PokemonSpecie specie, Capacity[] capacities, StatistiquePokemon stat, String nickName) {
		this.nickName=nickName;
		this.specie = specie;
		this.capacities = capacities;
		this.stat = stat;
	}
	
	public Pokemon(PokemonSpecie specie, Capacity[] capacities, StatistiquePokemon stat) {
		this(specie, capacities, stat, specie.getNamePokemon());
	}

	@Override
	public String toString() {
		return "Pokemon [specie=" + specie + ",\n\t capacities=" + Arrays.toString(capacities) + ",\n\t stat=" + stat
				+ ",\n\t nickname=" + getNickName() + "]";
	}
	
	
	/**
	 * 
	 * @return the name of the pokemon of the pokemon
	 */
	public String getNickName() {
		return nickName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(capacities);
		result = prime * result + ((specie == null) ? 0 : specie.hashCode());
		result = prime * result + ((stat == null) ? 0 : stat.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		if (!Arrays.equals(capacities, other.capacities))
			return false;
		if (specie == null) {
			if (other.specie != null)
				return false;
		} else if (!specie.equals(other.specie))
			return false;
		if (stat == null) {
			if (other.stat != null)
				return false;
		} else if (!stat.equals(other.stat))
			return false;
		return true;
	}

	/**
	 * 
	 * @return the specie of the pokemon
	 */
	public PokemonSpecie getSpecie() {
		return specie;
	}

	/**
	 * 
	 * @return the capacities of the pokemon
	 */
	public Capacity[] getCapacities() {
		return capacities;
	}
	
	/**
	 * 
	 * @return the Statistique of the pokemon
	 */
	public StatistiquePokemon getStat() {
		return stat;
	}
	
	/**
	 * Return if the pokemon is alive
	 * @return boolean
	 */
	public boolean isAlive() {
		return !stat.noPv();
	}
	
	/**
	 * Return if the pokemon take fome damage
	 * @param i
	 * @return boolean
	 */
	public boolean takeDmg(int i) {
		return stat.substractDamage(i);
	}
	
	/**
	 * Reset Pv of the pokemon
	 */
	public void restore() {
		stat.restorePv();
		
	}
	
	/**
	 * Say if the pokemon can use some capcity or if he can't
	 * @return
	 */
	public boolean noMoreFight() {
		for (Capacity capacity : capacities) {
			if(capacity.isUsable()) {
				return false;
			}
		}
		return true;
	}

	public boolean takeDmgCap(Capacity capUsed) {
		return takeDmg((int)(specie.getTypes().getRatio(capUsed.getType())*capUsed.getPower()));
		
		
	}
	
}
