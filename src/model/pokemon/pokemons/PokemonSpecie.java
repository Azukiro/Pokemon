package model.pokemon.pokemons;

import java.io.Serializable;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Objects;

public class PokemonSpecie implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int nbPokemon;
	private final String namePokemon;
	private final PokemonType types;
	private final Size size;
	private final String imagePath;

	public PokemonSpecie(int nbPokemon, String namePokemon, PokemonType enumPokemonTypes, double height, double weight,
			String imagePath) {
		this.nbPokemon = nbPokemon;
		this.namePokemon = Objects.requireNonNull(namePokemon);
		this.size = new Size(height, weight);

		types = Objects.requireNonNull(enumPokemonTypes);
		this.imagePath = Objects.requireNonNull(imagePath);

	}

	/**
	 * 
	 * @return the number of the specie
	 */
	public int getNbPokemon() {
		return nbPokemon;
	}

	/**
	 * 
	 * @return the name of the specie
	 */
	public String getNamePokemon() {
		return namePokemon;
	}
	
	/**
	 * 
	 * @return the types of the specie
	 */
	public PokemonType getTypes() {
		return types;
	}

	@Override
	public String toString() {
		return "PokemonSpecie [nbPokemon=" + nbPokemon + ", namePokemon=" + namePokemon + ", types=" + types + ", size="
				+ size + ", imagePath=" + imagePath + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imagePath == null) ? 0 : imagePath.hashCode());
		result = prime * result + ((namePokemon == null) ? 0 : namePokemon.hashCode());
		result = prime * result + nbPokemon;
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((types == null) ? 0 : types.hashCode());
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
		PokemonSpecie other = (PokemonSpecie) obj;
		if (imagePath == null) {
			if (other.imagePath != null)
				return false;
		} else if (!imagePath.equals(other.imagePath))
			return false;
		if (namePokemon == null) {
			if (other.namePokemon != null)
				return false;
		} else if (!namePokemon.equals(other.namePokemon))
			return false;
		if (nbPokemon != other.nbPokemon)
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (types == null) {
			if (other.types != null)
				return false;
		} else if (!types.equals(other.types))
			return false;
		return true;
	}
	
	/**
	 * 
	 * @return the pathImage of the specie
	 */
	public String getImagePath() {
		return imagePath;
	}
	
	/**
	 * 
	 * @return the Size of the specie
	 */
	public Size getSize() {
		return size;
	}

}
