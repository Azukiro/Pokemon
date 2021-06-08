package controler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.fight.Bot;
import model.fight.League;
import model.fight.Trainer;
import vue.MainView;

public class PersonnalLeagueController {
	
	@FXML
	private BorderPane root;
	
	@FXML
	private TextField label;
	
	
	private static ArrayList<Bot> trainers=new ArrayList<Bot>();
	
	public void initialize() throws FileNotFoundException {
		
		if(!GameControllerStatic.getGameControllerStatic().isCreateLeagueOn()){
		
			System.out.println("Patate");
			GameControllerStatic.getGameControllerStatic().setCreateLeagueOn(true);
			
		}else {
			PersonnalLeagueController.trainers.add(GameControllerStatic.getGameControllerStatic().getBot());
			
		}
		VBox vBox=new VBox();
		for (Bot bot : trainers) {
			Label label =new Label(bot.getName());
			label.setFont(new Font(20));
			vBox.getChildren().add(label);
		}
		vBox.setAlignment(Pos.CENTER);
		
		vBox.setPrefSize(243, 285);
		root.setCenter(vBox);
		BorderPane.setAlignment(vBox, Pos.CENTER);
		
	}
	
	/**
	 * Function for save the Current League
	 * @param event
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@FXML
    void Save(ActionEvent event) throws FileNotFoundException, IOException {
		ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream("League/"+label.getText()+".league")) ;
		oos.writeObject(new League(PersonnalLeagueController.trainers));
		oos.close(); 
	}
	
	/**
	 * Function for add a Trainer to the league
	 * @param event
	 */
	@FXML
    void Add(ActionEvent event) {
		try {
			MainView.changeScene((Stage)root.getScene().getWindow(), "Pokedex.fxml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Function for return to the League menu
	 * @param event
	 */
	@FXML
    void Menu(ActionEvent event) {
		try {
			GameControllerStatic.getGameControllerStatic().setCreateLeagueOn(false);
			MainView.changeScene((Stage)root.getScene().getWindow(), "League.fxml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
