package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
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

        FightBox fb = new FightBox(new Monster(skills, skillDamage, 45, "John"));
        MonsterImageBox monsterImage = new MonsterImageBox(fb.monster, fb.target);

        Image i = new Image(new FileInputStream("background/sprite1.png"));
        ImageView iv = new ImageView();

        iv.setImage(i);
        iv.setFitWidth(900);
        iv.setFitHeight(650);
        bp.setCenter(monsterImage.getMainPane());
        bp.setBottom(fb.getMainPane());
        mainPane.getChildren().add(bp);
        Scene scene = new Scene(mainPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
