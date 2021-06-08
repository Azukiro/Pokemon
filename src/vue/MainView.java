package vue;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.pokedex.Pokedex;

public class MainView {
	
	private static MainView mainView= new MainView();
	
	public static void changeScene(Stage currentStage, String fxml) throws IOException {
	
    	currentStage.setScene(new Scene(FXMLLoader.load(mainView.getClass().getResource(fxml))));
	}
	

}
