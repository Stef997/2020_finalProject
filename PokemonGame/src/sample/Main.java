package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main extends Application {

    private static BorderPane bp;

    public void start(Stage primaryStage) throws Exception {
        ArrayList<Skill> skillArrayList1 = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            Skill skill = new Skill("Skill " + Integer.toString(i+1), 10);
            skillArrayList1.add(skill);

        }
        Monster waterType = new Monster(skillArrayList1, 45, "Water Starter", "water");

        ArrayList<Skill> skillArrayList2 = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            Skill skill = new Skill("Skill " + Integer.toString(i+1), 10);
            skillArrayList1.add(skill);

        }
        Monster fireType = new Monster(skillArrayList2,45, "Fire Starter", "fire");

        ArrayList<Skill> skillArrayList3 = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            Skill skill = new Skill("Skill " + Integer.toString(i+1), 10);
            skillArrayList1.add(skill);

        }
        Monster grassType = new Monster(skillArrayList3, 45, "Grass Starter", "grass");

        FightBox fb = new FightBox(waterType);
        IOMenu ioMenu = new IOMenu(fb,primaryStage);

        MonsterImageBox monsterImage = new MonsterImageBox(ioMenu.fightBox.monster, ioMenu.fightBox.target);
        FightBackground back = new FightBackground();

        bp = new BorderPane();
        bp.setBackground(back.background);
        StackPane sp = new StackPane();

        sp.getChildren().add(monsterImage.getGroup());
        sp.getChildren().add(ioMenu.fightBox.monsterInfoBox.getGroup());

        bp.setMinHeight(700);
        bp.setMinWidth(900);

        bp.setOnMouseClicked(event -> {
            bp.setBottom(null);
            sp.getChildren().remove(1);
            sp.getChildren().add(ioMenu.fightBox.monsterInfoBox.getGroup());
            bp.setBottom(ioMenu.fightBox.getGroup());
        });

        bp.setTop(ioMenu.getGroup());
        bp.setCenter(sp);
        bp.setBottom(ioMenu.fightBox.getGroup());

        Scene scene = new Scene(bp);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static BorderPane getBp(){return bp;}
}
