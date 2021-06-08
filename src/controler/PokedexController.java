package controler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.fight.Bot;
import model.fight.Trainer;
import model.pokedex.Pokedex;
import model.pokemon.pokemons.CapacitiesHelper;
import model.pokemon.pokemons.Capacity;
import model.pokemon.pokemons.CapacityDeck;
import model.pokemon.pokemons.Pokemon;
import model.pokemon.pokemons.PokemonSpecie;
import model.pokemon.pokemons.PokemonType;
import model.pokemon.pokemons.StatistiquePokemon;
import vue.MainView;

public class PokedexController {

	@FXML
	private BorderPane root;

	@FXML
	private GridPane root2;


	private ObservableList<Node> chidreNodes = FXCollections.observableArrayList();

	private ObservableList<RowConstraints> rowContraintsList = FXCollections.observableArrayList();

	private Pokedex pokedex = null;

	private TextField nameFiled;

	private final int column = 6;

	private int row = 0;

	private int choosenPokemon = 0;

	private Pokemon[] pokemons = new Pokemon[column];

	private CapacityDeck deck = null;

	
	/**
	 * Function who initialize the Pokedex with the existing pokemon
	 * @throws FileNotFoundException
	 */
	public void initialize() throws FileNotFoundException {
		System.out.println("Lancement du Pokédex");
		try {
			pokedex = Pokedex.getPokedex();
			deck = CapacitiesHelper.getCapacityDeck();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Ta mere");
			e.printStackTrace();
		}
		int total = pokedex.size();
		row = (int) (total / column);
		int pokemonNumber = 1;
		for (int i = 0; i < row; i++) {//for All the row that we need to create
			RowConstraints rowConstraints = new RowConstraints();
			rowConstraints.setPrefHeight(100.0);
			rowConstraints.setMinHeight(100.0);
			root2.getRowConstraints().add(rowConstraints);
			rowContraintsList.add(rowConstraints);//Create the row on the grid
			HBox vBox = new HBox();
			nameFiled = new TextField("Player");
			vBox.getChildren().add(new Label("Trainer's name :  "));
			vBox.getChildren().add(nameFiled);
			root.setTop(vBox);
			for (int j = 0; j < column; j++) {//for All the columns of the grid
				//Add the PokemonButton with the image and importante information
				PokemonButton rectangle = new PokemonButton(pokedex.get(pokemonNumber));
				rectangle.setPrefWidth(100.0);

				rectangle.setPrefHeight(100.0);
				rectangle.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
						BorderWidths.DEFAULT)));
				rectangle.setTop(new Label(pokemonNumber + " " + pokedex.get(pokemonNumber).getNamePokemon()));
				BorderPane.setAlignment(rectangle.getTop(), Pos.CENTER);
				ImageView view = new ImageView();
				view.prefHeight(75.0);
				view.prefWidth(75.0);
				view.setFitHeight(75.0);
				view.setFitWidth(75.0);
				view.setImage(

						new Image(new FileInputStream("Pictures/" + pokedex.get(pokemonNumber).getImagePath()),

								75.0, 75.0, false, false));
				rectangle.setCenter(view);

				BorderPane.setAlignment(rectangle.getCenter(), Pos.CENTER);
				rectangle.setOnMouseClicked(event);
				root2.add(rectangle, j, i);
				chidreNodes.add(rectangle);
				pokemonNumber++;

			}
		}

	}

	private EventHandler<MouseEvent> event = new EventHandler<MouseEvent>() {
		private int capacitychoosen = 0;
		private int capacityMax = 4;
		private Capacity[] capacities = new Capacity[capacityMax];
		private PokemonSpecie pokemonSpecie;
		private TextField namePokemonField;
		private PokemonButton pokemonButton;

		/**
		 * Function when we click on a pokemonButton, for watch more details on
		 */
		public void handle(MouseEvent e) {
			var x = e.getSource();
			if (x instanceof PokemonButton) {
				PokemonButton pokemonButton = (PokemonButton) x;
				this.pokemonButton = pokemonButton;
				pokemonSpecie = pokemonButton.getPokemonSpecie();

				try {
					setPokemonInterface(pokemonSpecie);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}
		/**
		 * Set the interface for watch the details of the current pokemon
		 * @param pokemonSpecie
		 * @throws FileNotFoundException
		 */
		public void setPokemonInterface(PokemonSpecie pokemonSpecie) throws FileNotFoundException {
			HBox hBox1 = new HBox();
			namePokemonField = new TextField(pokemonSpecie.getNamePokemon());
			hBox1.getChildren().add(new Label("Pokemon's name"));
			hBox1.getChildren().add(namePokemonField);
			root.setTop(hBox1);
			AnchorPane anchorPane = new AnchorPane();
			anchorPane.setPrefWidth(600);
			anchorPane.setPrefHeight(200);
			anchorPane.setMaxHeight(100);
			ImageView view = new ImageView();
			view.setImage(new Image(new FileInputStream("Pictures/" + pokemonSpecie.getImagePath()), 200.0, 150.0,
					false, false));
			AnchorPane.setLeftAnchor(view, 0.0);
			AnchorPane.setTopAnchor(view, 65.0);

			AnchorPane anchorPane3 = new AnchorPane();
			anchorPane3.setPrefWidth(274);
			anchorPane3.setPrefHeight(76);
			AnchorPane.setLeftAnchor(anchorPane3, 286.0);
			AnchorPane.setTopAnchor(anchorPane3, 43.0);
			anchorPane.getChildren().addAll(view, anchorPane3);

			ImageView view2 = new ImageView();
			view2.setImage(new Image(new FileInputStream("Pictures/pokeball.png"), 34.0, 28.0, false, false));
			Label label = new Label(pokemonSpecie.getNbPokemon() +"   "+ pokemonSpecie.getNamePokemon());
			label.setFont(new Font(20));
			AnchorPane.setLeftAnchor(view2, 10.0);
			AnchorPane.setTopAnchor(view2, 10.0);
			AnchorPane.setLeftAnchor(label, 81.0);
			AnchorPane.setTopAnchor(label, 9.0);
			
			BackgroundImage pokedexBackground = new BackgroundImage(new Image(new FileInputStream("Pictures/pokedexBackground.png")),
					BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
					new BackgroundSize(250, 75, false, false, false, false));
			
			anchorPane3.setBackground(new Background(pokedexBackground));
			anchorPane3.getChildren().addAll(view2, label);

			ImageView view3 = new ImageView();
			view3.setImage(new Image(
					new FileInputStream("Pictures/types/" + pokemonSpecie.getTypes().get(0).toString() + ".png"), 30.0,
					30.0, false, false));
			ImageView view4 = new ImageView();
			if (pokemonSpecie.getTypes().size() == 2) {
				view4.setImage(new Image(
						new FileInputStream("Pictures/types/" + pokemonSpecie.getTypes().get(1).toString() + ".png"),
						30.0, 30.0, false, false));

			}

			AnchorPane.setLeftAnchor(view3, 347.0);
			AnchorPane.setTopAnchor(view3, 81.0);
			AnchorPane.setLeftAnchor(view4, 407.0);
			AnchorPane.setTopAnchor(view4, 81.0);
			anchorPane.getChildren().addAll(view3, view4);
			VBox vBox = new VBox();
			vBox.setPrefHeight(69);
			vBox.setPrefWidth(250);
			Label label2 = new Label("Height : " + pokemonSpecie.getSize().getHeight()+"Inch");
			Label label3 = new Label("Weight : " + pokemonSpecie.getSize().getWeight()+".lbs.");
			label2.setFont(new Font(20));
			label3.setFont(new Font(20));
			vBox.getChildren().addAll(label2, label3);
			vBox.setAlignment(Pos.CENTER);
			BackgroundImage pokedexBackground2 = new BackgroundImage(new Image(new FileInputStream("Pictures/pokedexBackground2.png")),
					BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
					new BackgroundSize(250, 69, false, false, false, false));
			vBox.setBackground(new Background(pokedexBackground2));
			AnchorPane.setLeftAnchor(vBox, 311.0);
			AnchorPane.setTopAnchor(vBox, 188.0);

			anchorPane.getChildren().addAll(vBox);
			
			root.setCenter(anchorPane);
			BackgroundImage fightMenu = new BackgroundImage(new Image(new FileInputStream("Pictures/fightMenu.png")),
					BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
					new BackgroundSize(600, 100, false, false, false, false));
			HBox hBox = new HBox();
			Button returnButton = new Button("Return");
			Button selectButton = new Button("Select");
			selectButton.setOnMouseClicked(e -> {
				pokemonButton.setBorder(new Border(
						new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(4))));

				try {
					updateRoot(pokemonSpecie.getTypes());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			returnButton.setOnMouseClicked(event -> root.setCenter(root2));
			returnButton.setPrefHeight(75);
			selectButton.setPrefHeight(75);
			returnButton.setPrefWidth(75);
			selectButton.setPrefWidth(75);
			hBox.setBackground(new Background(fightMenu));
			hBox.getChildren().addAll(returnButton, selectButton);
			hBox.setPrefHeight(100);
			hBox.setPrefWidth(600);
			hBox.setAlignment(Pos.CENTER);
			hBox.setSpacing(10);
			//anchorPane.getChildren().add(hBox);
			root.setBottom(hBox);
			AnchorPane.setLeftAnchor(hBox, 0.0);
			AnchorPane.setTopAnchor(hBox, 300.0);
		

		}

		public void updateRoot(PokemonType type) throws FileNotFoundException {
			var set = deck.get(type);

			root2.getChildren().clear();
			root2.getRowConstraints().clear();

			root.setTop(null);
			root.setBottom(null);
			root.setCenter(root2);
			int k = 0;
			int i, j;
			for (Capacity capacity : set) {
				i = k / column;
				j = k % column;
				if (j == 0) {
					RowConstraints rowConstraints = new RowConstraints();
					rowConstraints.setPrefHeight(100.0);
					rowConstraints.setMinHeight(100.0);
					root2.getRowConstraints().add(rowConstraints);
				}
				CapacityButton rectangle = new CapacityButton(capacity);
				rectangle.setPrefWidth(
						100.0 - ((BorderWidths.DEFAULT.getLeft() + BorderWidths.DEFAULT.getRight()) * column));
				rectangle.setPrefHeight(100.0);
				rectangle.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
						BorderWidths.DEFAULT)));

				// rectangle.setBottom(new
				// Label(pokedex.get(pokemonNumber-1).getNamePokemon()));
				rectangle.setTop(new Label(capacity.getName()));
				BorderPane vBox2 = new BorderPane();
				vBox2.setRight(new Label("Pow:" + capacity.getPower() + ""));
				vBox2.setLeft(new Label("PP:" + capacity.getMaxPowerPoint() + ""));

				rectangle.setBottom(vBox2);
				BorderPane.setAlignment(rectangle.getTop(), Pos.CENTER);
				ImageView view = new ImageView();
				view.prefHeight(50);
				view.prefWidth(50.0);
				view.setFitHeight(50);
				view.setFitWidth(50.0);

				view.setImage(new Image(new FileInputStream("Pictures/types/" + capacity.getType().toString() + ".png"),
						50.0, 50.0, false, false));
				rectangle.setCenter(view);

				BorderPane.setAlignment(rectangle.getCenter(), Pos.CENTER);
				rectangle.setOnMouseClicked(event2);
				root2.add(rectangle, j, i);
				k++;
			}

		}

		private EventHandler<MouseEvent> event2 = new EventHandler<MouseEvent>() {
			/**
			 * Function for create the interface with all the capcities of the current pokemon 
			 */
			public void handle(MouseEvent e) {
				var x = e.getSource();
				if (x instanceof CapacityButton) {
					CapacityButton pokemonButton = (CapacityButton) x;
					boolean newCapacity = true;
					for (int i = 0; i < capacities.length; i++) {
						if (capacities[i] == pokemonButton.getCapacity()) {
							newCapacity = false;
						}
					}
					if (newCapacity) {
						pokemonButton.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID,
								CornerRadii.EMPTY, new BorderWidths(4))));
						capacities[capacitychoosen] = pokemonButton.getCapacity();
						capacitychoosen++;
						if (capacitychoosen == capacityMax) {//If the number of capcity chosse is the max we return to the pokemon interface
							root2.getChildren().clear();
							root2.getChildren().addAll(chidreNodes);
							root2.getRowConstraints().clear();
							root2.getRowConstraints().addAll(rowContraintsList);
							pokemons[choosenPokemon] = new Pokemon(pokemonSpecie, capacities,
									StatistiquePokemon.RandomStat(), namePokemonField.getText());
							choosenPokemon++;
							capacities = new Capacity[capacityMax];
							capacitychoosen = 0;

							if (choosenPokemon == column) {//If we choose all pokmeon we are redirect to an other interface

								try {

									

									if (GameControllerStatic.getGameControllerStatic().isCreateLeagueOn()) {
										GameControllerStatic.getGameControllerStatic().setBot(new Bot(nameFiled.getText(), pokemons));
										MainView.changeScene((Stage) root2.getScene().getWindow(),
												"PersonalLeague.fxml");
									} else {
										GameControllerStatic.getGameControllerStatic().setTrainer(new Trainer(nameFiled.getText(), pokemons));

										MainView.changeScene((Stage) root2.getScene().getWindow(), "interface.fxml");
										GameControllerStatic.Save();

									}
								
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

							}
						}
					}

				}
			}
		};
	};
}
