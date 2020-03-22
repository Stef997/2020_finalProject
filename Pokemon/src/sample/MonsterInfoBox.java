package sample;

import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MonsterInfoBox {
    public int maxHP = 45;
    public Monster monster;
    public StackPane mainPane = new StackPane();
    final private Image backImage = new Image(new FileInputStream("background/textbox.png"));
    final private ImageView background = new ImageView();
    private GridPane infoPane = new GridPane();
    private static final String RED_BAR    = "red-bar";
    private static final String GREEN_BAR  = "green-bar";
    private static final String[] barColorStyleClasses = { RED_BAR, GREEN_BAR };

    public MonsterInfoBox(Monster monster) throws FileNotFoundException {
        this.monster = monster;
        init();
    }

    public void init(){
        System.out.println("init ");
        background.setImage(backImage);
        background.setFitWidth(200);
        background.setFitHeight(70);
        infoPane.setMaxWidth(180);
        infoPane.setMaxHeight(50);

        ProgressBar progressBar = new ColoredProgressBar("green-bar",  0.8);
        progressBar.setPrefWidth(100);
        progressBar.setProgress(calculateProgressBar());

        double progress = calculateProgressBar();
        if (progress < 0.25) {
            setBarStyleClass(progressBar, RED_BAR);
        } else {
            setBarStyleClass(progressBar, GREEN_BAR);
        }


        Text name = new Text(monster.getName().toUpperCase());
        Text HP = new Text(String.valueOf(monster.getHP()));
        Text HP1 = new Text("/"+ String.valueOf(maxHP));
        name.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 12));
        name.setFill(Color.BLACK);

        VBox vBox = new VBox(progressBar);
        vBox.getStylesheets().add(getClass().getResource("root.css").toExternalForm());
        VBox vBox1 = new VBox(name);
        infoPane.add(vBox1, 0, 0);
        infoPane.add(vBox, 2, 2);
        infoPane.add(HP, 3,0);
        infoPane.add(HP1, 4,0);

        mainPane.getChildren().addAll(background,infoPane);


    }
    public StackPane getMainPane(){
        return this.mainPane;
    }

    public double calculateProgressBar(){
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
