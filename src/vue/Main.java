package vue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.EnumSet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.pokemon.pokemons.PokemonType;
import model.pokemon.pokemons.EnumPokemonType;
import model.pokemon.pokemons.StatistiquePokemon;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {

            BorderPane root = FXMLLoader.load(getClass().getResource("interface.fxml"));
            Scene scene = new Scene(root);
            primaryStage.getIcons().add(new Image(new FileInputStream("Pictures/pokeball.png")));
            primaryStage.setScene(scene);
            primaryStage.setTitle("Pokemon - Fabien Courtois & Lucas Billard");
            primaryStage.setResizable(false);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {


        PokemonType.generatePokemonType();
        launch(args);
        /*
        PokemonType.generatePokemonType();
        EnumSet<EnumPokemonType> capp2=EnumSet.of(EnumPokemonType.Vol,EnumPokemonType.Tenebres);
        var t=PokemonType.getPokemonType(capp2);
        System.out.println(t);
        System.out.println(Pokedex.generate());
        PokemonSpecie specie=new PokemonSpecie(12, "Ronflex", t, 10, 20, "Path");
        Capacity[] capp=new Capacity[2];
        capp[0]= Capacity.instance("ronron", 20, 50, CategoryCapacity.Physique);
        Pokemon ronron=new Pokemon(specie,capp, new StatistiquePokemon(0, 0, 0, 0, 0, 0));
        System.out.println(ronron);
        launch(args);
        */



    }
}