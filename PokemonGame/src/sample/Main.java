package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main extends Application {

    public void start(Stage primaryStage) throws Exception {

        String skills[] = {"SKILL1","SKILL2","SKILL3","SKILL4"};
        int skillDamage[] = {10, 10, 5, 25};

        FightBox fb = new FightBox(new Monster(skills, skillDamage, 45, "Water Starter", "water"));
        MonsterImageBox monsterImage = new MonsterImageBox(fb.monster, fb.target);
        FightBackground back = new FightBackground();

        BorderPane bp = new BorderPane();
        bp.setBackground(back.background);

        bp.setMinHeight(700);
        bp.setMinWidth(900);

        bp.setCenter(monsterImage.getGroup());
        bp.setBottom(fb.getGroup());


        Scene scene = new Scene(bp);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
