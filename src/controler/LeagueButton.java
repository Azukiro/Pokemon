package controler;

import javafx.scene.control.Button;

public class LeagueButton extends Button {
	private final String leagueNameString;

	public LeagueButton(String leagueNameString) {
		super();
		this.leagueNameString = leagueNameString;
		setText(leagueNameString);
	}
	
	public String getLeagueNameString() {
		return leagueNameString;
	}
	
	
}
