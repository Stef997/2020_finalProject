package sample;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.Group;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MonsterInfoBox {
    public int maxHP = 45;
    public Monster monster;
    private Monster target;

    private Group group;

    final private Image backImage = new Image(new FileInputStream("background/textbox.png"));
    final private ImageView background = new ImageView();
    final private ImageView background1 = new ImageView();

    private static final String RED_BAR    = "red-bar";
    private static final String GREEN_BAR  = "green-bar";
    private static final String[] barColorStyleClasses = { RED_BAR, GREEN_BAR };

    public ProgressBar progressBar = new ColoredProgressBar("green-bar",  0.8);
    public ProgressBar progressBar1 = new ColoredProgressBar("green-bar",  0.8);


    public MonsterInfoBox(Monster monster, Monster target) throws FileNotFoundException {
        this.monster = monster;
        this.target = target;
        init();
    }

    public void init(){
        System.out.println("init ");
        background.setImage(backImage);
        background.setFitWidth(250);
        background.setFitHeight(70);
        background.setLayoutX(450);
        background.setLayoutY(-15);

        background1.setImage(backImage);
        background1.setFitWidth(250);
        background1.setFitHeight(70);
        background1.setLayoutX(450);
        background1.setLayoutY(-275);


        //Need to update Progressbar



        progressBar.setPrefWidth(170);
        progressBar.setProgress(calculateProgressBar(monster));
        //Need to update Progresssbar

        progressBar1.setPrefWidth(170);
        progressBar1.setProgress(calculateProgressBar(target));

        double progressmonster = calculateProgressBar(monster);
        if (progressmonster < 0.25) {
            setBarStyleClass(progressBar, RED_BAR);
        } else {
            setBarStyleClass(progressBar, GREEN_BAR);
        }
        double progresstarget = calculateProgressBar(target);
        if (progresstarget < 0.25) {
            setBarStyleClass(progressBar1, RED_BAR);
        } else {
            setBarStyleClass(progressBar1, GREEN_BAR);
        }


        Text name = new Text(monster.getName().toUpperCase());
        Text targetname = new Text(target.getName().toUpperCase());

        //need to update text


        Text HP = new Text(String.valueOf(monster.getHP())+ "/" + String.valueOf(maxHP));
        Text HP1 = new Text(String.valueOf(target.getHP())+ "/" + String.valueOf(maxHP));

        name.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 12));
        name.setFill(Color.BLACK);
        targetname.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 12));
        targetname.setFill(Color.BLACK);

        VBox vBox = new VBox(progressBar);
        vBox.getStylesheets().add(getClass().getResource("root.css").toExternalForm());
        VBox vBox1 = new VBox(progressBar1);
        vBox1.getStylesheets().add(getClass().getResource("root.css").toExternalForm());

        HBox hBox = new HBox(name, HP);
        hBox.setSpacing(40);
        HBox hBox1 = new HBox(targetname, HP1);
        hBox1.setSpacing(40);

        vBox.setLayoutX(480);
        vBox.setLayoutY(15);
        vBox1.setLayoutX(480);
        vBox1.setLayoutY(-245);

        hBox.setLayoutX(470);
        hBox.setLayoutY(-10);
        hBox1.setLayoutX(470);
        hBox1.setLayoutY(-265);

        group = new Group(background,hBox, vBox, background1, hBox1, vBox1);

    }

    public void updateBar(){
        progressBar.setProgress(calculateProgressBar(monster));
        progressBar1.setProgress(calculateProgressBar(target));
    }

    public Group getGroup() {return group;}

    public double calculateProgressBar(Monster monster){
        double hP = monster.getHP();
        double percent = hP/maxHP;
        System.out.println(hP);
        System.out.println(percent);
        return percent;
    }
    class ColoredProgressBar extends ProgressBar {
        ColoredProgressBar(String styleClass, double progress) {
            super(progress);
            getStyleClass().add(styleClass);
        }
    }
    private void setBarStyleClass(ProgressBar bar, String barStyleClass) {
        bar.getStyleClass().removeAll(barColorStyleClasses);
        bar.getStyleClass().add(barStyleClass);
    }


}
