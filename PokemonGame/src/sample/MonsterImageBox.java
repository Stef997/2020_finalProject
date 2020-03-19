package sample;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class MonsterImageBox {

    private Monster monster;
    private Monster target;

    private ImageView myMonster = new ImageView();
    private ImageView targetMonster = new ImageView();

    private BorderPane mainPane = new BorderPane();

    private StackPane monsterPane = new StackPane();
    private StackPane targetPane = new StackPane();

    public MonsterImageBox(Monster monster, Monster target){

        this.monster = monster;
        this.target = target;
        init();
    }

    private void init(){
        myMonster.setImage(monster.getMonsterImage());
        targetMonster.setImage(target.getMonsterImage());

        targetMonster.setFitHeight(200);
        targetMonster.setFitWidth(200);

        myMonster.setFitHeight(200);
        myMonster.setFitWidth(200);

        monsterPane.getChildren().add(myMonster);
        monsterPane.setAlignment(Pos.CENTER_LEFT);

        targetPane.getChildren().add(targetMonster);
        targetPane.setAlignment(Pos.CENTER_RIGHT);

        mainPane.setBottom(monsterPane);
        mainPane.setTop(targetPane);
    }

    public BorderPane getMainPane(){
        return this.mainPane;
    }
}
