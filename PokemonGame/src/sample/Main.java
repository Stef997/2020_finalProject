package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main extends Application {

    public void start(Stage primaryStage) throws Exception {

        String skills[] = {"SKILL1","SKILL2","SKILL3","SKILL4"};
        int skillDamage[] = {10, 10, 5, 25};
        Monster waterType = new Monster(skills, skillDamage, 45, "Water Starter", "water");

        String skills1[] = {"SKILL1","SKILL2","SKILL3","SKILL4"};
        int skillDamage1[] = {10, 10, 5, 25};
        Monster fireType = new Monster(skills, skillDamage, 45, "Fire Starter", "fire");

        String skills2[] = {"SKILL1","SKILL2","SKILL3","SKILL4"};
        int skillDamage2[] = {10, 10, 5, 25};
        Monster grassType = new Monster(skills, skillDamage, 45, "Grass Starter", "grass");

        FightBox fb = new FightBox(waterType);
        IOMenu ioMenu = new IOMenu(fb,primaryStage);

        MonsterImageBox monsterImage = new MonsterImageBox(ioMenu.fightBox.monster, ioMenu.fightBox.target);

        FightBackground back = new FightBackground();

        BorderPane bp = new BorderPane();
        StackPane sp = new StackPane();
        bp.setBackground(back.background);
        bp.setTop(ioMenu.getGroup());
        bp.setMinHeight(700);
        bp.setMinWidth(900);

        bp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                bp.setBottom(null);
                sp.getChildren().remove(1);
                sp.getChildren().add(ioMenu.fightBox.monsterInfoBox.getGroup());
                bp.setBottom(ioMenu.fightBox.getGroup());
            }
        });

        sp.getChildren().add(monsterImage.getGroup());
        sp.getChildren().add(ioMenu.fightBox.monsterInfoBox.getGroup());
        bp.setCenter(sp);
        bp.setBottom(ioMenu.fightBox.getGroup());

        Scene scene = new Scene(bp);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
