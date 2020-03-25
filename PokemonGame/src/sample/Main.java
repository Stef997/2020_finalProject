package sample;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static javafx.scene.media.MediaPlayer.INDEFINITE;

public class Main extends Application {

    final Task music = new Task(){
        @Override
        protected Object call() throws Exception{
            int s = INDEFINITE;
            AudioClip audio = new AudioClip(getClass().getResource("/audio/audio.mp3").toExternalForm());
            audio.setVolume(0.5f);
            audio.setCycleCount(s);
            audio.play();
            return null;
        }
    };
    public void start(Stage primaryStage) throws Exception {

        Thread thread = new Thread(music);
        thread.start();

        /*String musicFile = "audio/audio.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.play();*/

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
        sp.getChildren().add(monsterImage.getGroup());
        sp.getChildren().add(ioMenu.fightBox.monsterInfoBox.getGroup());
        bp.setCenter(sp);
        bp.setBottom(ioMenu.fightBox.getGroup());

        Scene scene = new Scene(bp);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
