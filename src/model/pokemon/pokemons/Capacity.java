package model.pokemon.pokemons;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Capacity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static HashMap<String, Capacity> nameMap = new HashMap<String, Capacity>();
	private final String name;
	private final int power;
	private final int accuracy;
	private int powerPoint;
	private final int maxPowerPoint;
	private final CategoryCapacity categoryCapacity;
	private final EnumPokemonType type;
	
	
	/**
     * Class Capcity who permit to the pokemon to attack thanks to the capacity
     *
     * @param name name of the capacity
     * @param power the power of the capacity between 15 and 300 and multiple of 5
     * @param precision the precision of the capacity between 0 and 100
     * @param categoryCapacity that precise if the capacity is physical, special or statut
     * @param type that precise the type of the capacity 
     * @throws IllegalArgumentException if the power or the precision do not respect the condition said before
     * @return Capacity with the param of the function
     */
	private Capacity(String name, int power,int pp, int accuracy, CategoryCapacity categoryCapacity,EnumPokemonType type) {
		super();
		this.name = Objects.requireNonNull(name);
		if((power<15 || power>300 || power%5!=0) && power!=0 ) {
			throw new IllegalArgumentException("The power need to be between 15 and 300, and he should be a multiple of 5 and is  "+power);
		}
		this.power = power;
		this.powerPoint=pp;
		if(accuracy<0 || accuracy>100) {
			throw new IllegalArgumentException("The precision is a percentage rate, it need to be between 0 and 100");
		}
		this.accuracy = accuracy;
		this.categoryCapacity = Objects.requireNonNull(categoryCapacity);
		this.type=type;
		maxPowerPoint=pp;
		
	}
	/**
	 * 
	 * @return EnumPokemonType of the object
	 */
	public EnumPokemonType getType() {
		return type;
	}
	/**
	 * 
	 * @return power of the object
	 */
	public int getPower() {
		return power;
	}
	/**
	 * 
	 * @return name of the object
	 */
	public String getName() {
		return name;
	}
	
	/**
     * Create an Instance of a Capacity, and checking if the name isn't already take.
     *
     * @param name name of the capacity
     * @param power the power of the capacity between 15 and 300 and multiple of 5
     * @param precision the precision of the capacity between 0 and 100
     * @param categoryCapacity that precise if the capacity is physical, special or statut
     * @throws IllegalArgumentException if the name is already taken
     * @return Capacity with the param of the function
     */
	public static Capacity instance(String name, int power,int powerPoint, int accuracy, CategoryCapacity categoryCapacity,EnumPokemonType type) {
		if(nameMap.containsKey(name)) {
			throw new IllegalArgumentException("The capacity name is already taken");
		}
		nameMap.put(name, new Capacity(name, power,powerPoint, accuracy, categoryCapacity,type));
		return new Capacity(name, power,powerPoint, accuracy, categoryCapacity,type);
	}


	@Override
	public String toString() {
		return "Capacity [name=" + name + ", power=" + power + ", accuracy=" + accuracy + ", categoryCapacity="
				+ categoryCapacity + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryCapacity == null) ? 0 : categoryCapacity.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + power;
		result = prime * result + accuracy;
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
		Capacity other = (Capacity) obj;
		if (categoryCapacity != other.categoryCapacity)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (power != other.power)
			return false;
		if (accuracy != other.accuracy)
			return false;
		return true;
	}
	
	/**
	 * Verify the capacity Powerpoint is more than 0
	 * @return boolean if the capcity can be used
	 */
	public boolean isUsable() {
		if(powerPoint==0) {
			return false;
		}
		return true;
	}
	/**
	 * 
	 * @return PowerPoint of the object
	 */
	public int getPowerPoint() {
		return powerPoint;
	}
	/**
	 * 
	 * @return MaxPowerPoint of the object
	 */
	public int getMaxPowerPoint() {
		return maxPowerPoint;
	}
	
	/**
	 * Decrement the PowerPoint when a capaicty is used
	 * @return
	 */
	public void substractPP() {
		if(powerPoint>0) {
			powerPoint-=1;
		}
	}
	
	
	
	
	
	
}
