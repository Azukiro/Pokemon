package model.pokemon.pokemons;

import java.io.Serializable;
import java.util.Iterator;


public class EnumSetPokemonType implements Iterator<EnumPokemonType>,Serializable {
	/**
	 * Class for have the Two possible ENUMPOKEMONTYPE keept like an collection
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EnumPokemonType enumPokemonType1=null;
	private EnumPokemonType enumPokemonType2=null;
	private int actualPositin=0;
	
	public EnumSetPokemonType(EnumPokemonType enumPokemonType1, EnumPokemonType enumPokemonType2) {

		this.enumPokemonType1 = enumPokemonType1;
		this.enumPokemonType2 = enumPokemonType2;
	}
	public EnumSetPokemonType(EnumPokemonType enumPokemonType1) {

		this(enumPokemonType1, null);
	}
	
	
	/**
	 * Add a pokemonType to the class, if all the pokemonType are not already put
	 * @param enumPokemonType
	 */
	public void Add(EnumPokemonType enumPokemonType) {
		if(enumPokemonType1==null) {
			enumPokemonType1=enumPokemonType;
		}else if(enumPokemonType2==null) {
			enumPokemonType2=enumPokemonType;
		}
	}
	@Override
	public boolean hasNext() {
		if(actualPositin==0) {
			if(enumPokemonType1!=null) {
				return true;
			}
		}else if(actualPositin==1) {
			if(enumPokemonType2!=null) {
				return true;
			}
		}
		return false;
	}
	@Override
	public EnumPokemonType next() {
		if(actualPositin==0) {
			if(enumPokemonType1!=null) {
				actualPositin++;
				return enumPokemonType1;
			}
		}else if(actualPositin==1) {
			if(enumPokemonType2!=null) {
				actualPositin++;
				return enumPokemonType2;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @return number of element un this special set
	 */
	public int Size() {
		if(enumPokemonType1==null) {
			return 0;
		}else if(enumPokemonType2==null) {
			return 1;
		}else 
			return 2;
	}
	
	/**
	 * Return the EnumPokemonType like to this index, the index must be between 0 and 2
	 * @param index
	 * @return EnumPokemonType
	 */
	public EnumPokemonType get(int index) {
		if(index==0) {
			return enumPokemonType1;
		}else if(index==1) {
			return enumPokemonType2;
		}else {
			return null;
		}
	}
	@Override
	public int hashCode() {
		int result = 1;
		result = result + ((enumPokemonType1 == null) ? 0 : enumPokemonType1.hashCode());
		result =  result + ((enumPokemonType2 == null) ? 0 : enumPokemonType2.hashCode());
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
		EnumSetPokemonType other = (EnumSetPokemonType) obj;
	
		if (enumPokemonType1 != other.enumPokemonType1 && enumPokemonType2 !=other.enumPokemonType1) {

			return false;
		}
		if (enumPokemonType2 != other.enumPokemonType2 && enumPokemonType1 !=other.enumPokemonType2)
			return false;
		return true;
	}
	
	/**
	 * Reset the Iterator for recall him
	 */
	public void resetIterator() {
		actualPositin=0;
		
	}
	@Override
	public String toString() {
		return "EnumSetPokemonType [enumPokemonType1=" + enumPokemonType1 + ", enumPokemonType2=" + enumPokemonType2
				+ ", actualPositin=" + actualPositin + "]";
	}
	
	
	
	
	
}
