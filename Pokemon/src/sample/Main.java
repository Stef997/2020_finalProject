package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.scene.layout.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main extends Application {
    private int maxHP = 45;
    private StackPane infoPane = new StackPane();
    public Main() throws FileNotFoundException {
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        StackPane mainPane = new StackPane();
        Image background = new Image(new FileInputStream("background/backgroundfinal.png"));
        ImageView backset = new ImageView();
        backset.setImage(background);
        mainPane.getChildren().add(backset);

        BorderPane bp = new BorderPane();
        bp.setMinHeight(700);
        bp.setMinWidth(900);
        String skills[] = {"SKILL1","SKILL2","SKILL3","SKILL4"};
        int skillDamage[] = {10, 10, 5, 25};

        FightBox fb = new FightBox(new Monster(skills, skillDamage, 10, "John"));
        MonsterInfoBox mIB = new MonsterInfoBox(fb.monster);
        MonsterInfoBox tIB = new MonsterInfoBox(fb.target);
        MonsterImageBox monsterImage = new MonsterImageBox(fb.monster, fb.target);

        Image i = new Image(new FileInputStream("background/sprite1.png"));
        ImageView iv = new ImageView();

        iv.setImage(i);
        iv.setFitWidth(900);
        iv.setFitHeight(650);
        bp.setCenter(monsterImage.getMainPane());
        bp.setBottom(fb.getMainPane());


        VBox vBox = new VBox(mIB.getMainPane());
        infoPane.setAlignment(Pos.BOTTOM_LEFT);
        infoPane.getChildren().addAll(vBox);
        mainPane.getChildren().addAll(bp,infoPane);

        Scene scene = new Scene(mainPane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

    public int calculateProgressBar(Monster monster){
        int hP = monster.getHP();
        return hP/maxHP;
    }
}


