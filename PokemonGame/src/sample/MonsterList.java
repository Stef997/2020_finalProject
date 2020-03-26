package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MonsterList {
    private Group group = new Group();
    private static BorderPane bp;
    private ArrayList<Skill> skillArrayList = new ArrayList<>();
    private ArrayList<Monster> monsters = new ArrayList<>();
    private Stage primaryStage;

    public MonsterList(Stage stage) throws FileNotFoundException {
        primaryStage = stage;
        ArrayList<Skill> wStarterSkills = new ArrayList<>();
        wStarterSkills.add(new Skill("Water Canon", 20));
        wStarterSkills.add(new Skill("Water Gun", 15));
        wStarterSkills.add(new Skill("Water Splash", 5));
        wStarterSkills.add(new Skill("Water Ultimate", 30));
        Monster waterType = new Monster(wStarterSkills, 45, "Fiji", "water");

        ArrayList<Skill> fStarterSkills = new ArrayList<>();
        fStarterSkills.add(new Skill("Flame Burst", 5));
        fStarterSkills.add(new Skill("Fire Gun", 15));
        fStarterSkills.add(new Skill("Fire Explosion", 20));
        fStarterSkills.add(new Skill("Fire Ultimate", 30));
        Monster fireType = new Monster(fStarterSkills,45, "Toaster", "fire");


        ArrayList<Skill> gStarterSkills = new ArrayList<>();
        fStarterSkills.add(new Skill("Grass Blade", 5));
        fStarterSkills.add(new Skill("Bristle Bush", 15));
        fStarterSkills.add(new Skill("Poison Ivy", 20));
        fStarterSkills.add(new Skill("Grass Ultimate", 30));
        Monster grassType = new Monster(gStarterSkills, 45, "Lawn", "grass");

        monsters.add(waterType);
        monsters.add(fireType);
        monsters.add(grassType);

        StackPane pane = new StackPane();
        pane.setMinHeight(700);;
        pane.setMinWidth(900);
        VBox vBox = new VBox();

        int pos = 0;
        for(Monster m : monsters){
            GridPane gridPane = new GridPane();
            Text c1Name = new Text(m.getName());
            Text c1Type = new Text(m.getType());
            Button c1Choose = new Button("Choose " + c1Name.getText());
            c1Choose.setOnMouseClicked(mouseEvent -> {
                FightBox fb = null;
                try {
                    fb = new FightBox(m);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                IOMenu ioMenu = new IOMenu(fb,primaryStage);

                MonsterImageBox monsterImage = null;
                try {
                    monsterImage = new MonsterImageBox(ioMenu.fightBox.monster, ioMenu.fightBox.target);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                FightBackground back = null;
                try {
                    back = new FightBackground();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

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

                primaryStage.setScene(new Scene(new Group(bp)));
            });
            gridPane.add(c1Name, 0, pos);
            gridPane.add(c1Type, 1, pos);
            gridPane.add(c1Choose, 2, pos);
            ColumnConstraints column1 = new ColumnConstraints();
            column1.setPercentWidth(33);
            ColumnConstraints column2 = new ColumnConstraints();
            column2.setPercentWidth(33);
            ColumnConstraints column3 = new ColumnConstraints();
            column3.setPercentWidth(33);
            gridPane.getColumnConstraints().addAll(column1, column2, column3);
            gridPane.setAlignment(Pos.CENTER);
            gridPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DASHED,
                    CornerRadii.EMPTY, new BorderWidths(2))));
            gridPane.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, new Insets(2))));
            gridPane.setMinHeight(100);
            gridPane.setMinWidth(900);
            vBox.getChildren().add(gridPane);
            vBox.setAlignment(Pos.CENTER);
            ++pos;
        }
        pane.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("background/initBackground.png")),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(700, 900, true,
                        true,true, true))));
        pane.getChildren().add(vBox);
        group.getChildren().add(pane);

    }

    public Group getGroup() { return group; }
    public Stage getPrimaryStage() { return primaryStage; }
    public static BorderPane getBp(){return bp;}
    public ArrayList<Skill> getSkillArrayList() { return skillArrayList; }
    public ArrayList<Monster> getMonsters() { return monsters; }
}
