package model.pokemon.pokemons;

import java.io.Serializable;

public class Size implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final double weight;
	private final double height;
	
	public Size(double height , double weight) {
		super();
		this.weight = weight;
		this.height = height;
	}
	
	/**
	 * 
	 * @return the height of teh size
	 */
	public double getHeight() {
		return height;
	}
	
	/**
	 * 
	 * @return the weight of teh size
	 */
	public double getWeight() {
		return weight;
	}
	@Override
	public String toString() {
		return "Size [weight=" + weight + ", height=" + height + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Size other = (Size) obj;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}
	
}
