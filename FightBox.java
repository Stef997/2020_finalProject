package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javax.script.Bindings;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FightBox{

    private Monster monster;
    private StackPane mainPane = new StackPane();
    private GridPane skillPane = new GridPane();
    private BorderPane textPane = new BorderPane();
    private Text monsterName;
    final private Image backImage = new Image(new FileInputStream("background/695299.jpg"));
    final private ImageView background = new ImageView();

    public Button skillButton[] = new Button[4];


    public FightBox(Monster monster) throws FileNotFoundException {
        //Monster used for the fight skill box
        this.monster = monster;
        init();
    }

    private void init(){
        System.out.println("init ");
        background.setImage(backImage);
        background.setFitWidth(150);
        background.setFitHeight(100);

        for(int i = 0; i < skillButton.length; i++){
            skillButton[i] = new Button(monster.getSkills()[i]);
        }

        skillButton[0].setOnAction(new FightBoxHandler(monster));
        skillButton[1].setOnAction(new FightBoxHandler(monster));
        skillButton[2].setOnAction(new FightBoxHandler(monster));
        //Maybe have power points so abilities can only be used x times
        skillPane.add(skillButton[0], 0, 0);
        skillPane.add(skillButton[1], 1, 0);
        skillPane.add(skillButton[2], 0, 1);
        skillPane.add(skillButton[3], 1, 1);
        skillPane.setHgap(10);
        skillPane.setVgap(5);
        skillPane.setPadding(new Insets(3,3,3,3));
        skillPane.setAlignment(Pos.CENTER);


        monsterName = new Text(monster.getName() + " skills");
        monsterName.setStyle("-fx-stroke: red;");
        textPane.setTop(monsterName);

        mainPane.getChildren().add(background);
        mainPane.getChildren().add(skillPane);
        mainPane.getChildren().add(textPane);

        mainPane.setAlignment(Pos.CENTER);
        mainPane.setMinWidth(150);
        mainPane.setMinHeight(100);

    }

    public StackPane getMainPane(){
        return this.mainPane;
    }

}
