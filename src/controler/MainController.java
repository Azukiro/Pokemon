package controler;

import java.io.IOException;
import java.nio.file.Paths;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.stage.Stage;
import vue.MainView;

public class MainController {
	
	private AudioClip music;
	
    @FXML
    private Button launchFightButton;
    
    /**
	 * It is called automatically when the controller launch.
	 * @param 
	 * @return void
	 */
    public void initialize() {
    	setMusic();
    }
    
    /**
	 * Set the background music
	 * @param 
	 * @return void
	 */
    private void setMusic() {

		String bip = "Musics/mainTheme.mp3";
		Media hit = new Media(Paths.get(bip).toUri().toString());
		AudioClip mediaPlayer = new AudioClip(hit.getSource());
		mediaPlayer.setVolume(0.05);
		mediaPlayer.setCycleCount(AudioClip.INDEFINITE);
		mediaPlayer.play();
		music = mediaPlayer;
		
	}
    
    @FXML
    void launchFight(ActionEvent event) throws IOException {
    	music.stop();
    	MainView.changeScene((Stage)launchFightButton.getScene().getWindow(), "Fight.fxml");
    }
    
    @FXML
    void launchPokedex(ActionEvent event) throws IOException {
    	music.stop();
    	MainView.changeScene((Stage)launchFightButton.getScene().getWindow(), "Pokedex.fxml");
    }
    
    @FXML
    void lauchLeague(ActionEvent event) throws IOException {
    	music.stop();
    	MainView.changeScene((Stage)launchFightButton.getScene().getWindow(), "League.fxml");
    }


}
