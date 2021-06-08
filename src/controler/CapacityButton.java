package controler;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import model.pokemon.pokemons.Capacity;

public class CapacityButton extends BorderPane {
	
	private final Capacity capacity;

	public CapacityButton(Capacity capacity) {
		super();
		this.capacity = capacity;
	}
	
	public Capacity getCapacity() {
		return capacity;
	}
	
}
