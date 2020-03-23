package sample;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;

public class MonsterImageBoxCopy {
    private Monster monster;
    private Monster target;

    private Group group;

    private ImageView myMonster = new ImageView();
    private ImageView targetMonster = new ImageView();
    private MonsterInfoBox monsterInfoBox;

    public MonsterImageBoxCopy(Monster monster, Monster target) throws FileNotFoundException {

        this.monster = monster;
        this.target = target;
        init();
    }

    private void init() throws FileNotFoundException {
        monsterInfoBox = new MonsterInfoBox(monster, target);
        myMonster.setImage(monster.getMonsterImage());
        targetMonster.setImage(target.getMonsterImage());
        targetMonster.setFitHeight(150);
        targetMonster.setFitWidth(150);
        targetMonster.setLayoutX(450);
        targetMonster.setLayoutY(-275);

        myMonster.setFitHeight(150);
        myMonster.setFitWidth(150);
        myMonster.setLayoutX(0);
        myMonster.setLayoutY(-50);

        Group infoBox = monsterInfoBox.getGroup();
        infoBox.setLayoutX(150);
        infoBox.setLayoutX(-300);

        group = new Group(myMonster, targetMonster, monsterInfoBox.getGroup());

    }

    public Group getGroup() {return group;}
}
