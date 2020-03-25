package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

public class FightBox {

    public Monster monster;
    public Monster target;

    public MonsterInfoBox monsterInfoBox;

    private Group group;

    private GridPane skillPane = new GridPane();
    private FightBoxHandler fightBoxHandler;
    private Text monsterName;

    final private Image backImage = new Image(new FileInputStream("background/textbox.png"));
    final private ImageView background = new ImageView();

    public Button skillButton[] = new Button[4];

    public FightBox(Monster monster) throws FileNotFoundException {
        //Monster used for the fight skill box
        this.monster = monster;
        fightBoxHandler = new FightBoxHandler(this);
        createTargetDummy();
        init();

    }
    public FightBox(Monster monster, Monster target) throws FileNotFoundException {
        this.monster = monster;
        this.target = target;
        fightBoxHandler = new FightBoxHandler(this);
        init();
    }
    private void createTargetDummy() throws FileNotFoundException {
        int skillDamage[] = {5, 0, 0, 0};
        target = new Monster(skillDamage, 0, "Target Dummy");
    }

    private void init() throws FileNotFoundException {

        System.out.println("init ");

        monsterInfoBox = new MonsterInfoBox(monster, target);

        background.setImage(backImage);
        background.setFitWidth(600);
        background.setFitHeight(150);

        for(int i = 0; i < skillButton.length; i++){
            skillButton[i] = new Button(monster.getSkills()[i]);
        }

        skillButton[0].setOnAction(fightBoxHandler);
        skillButton[1].setOnAction(fightBoxHandler);
        skillButton[2].setOnAction(fightBoxHandler);
        skillButton[3].setOnAction(fightBoxHandler);

        //Maybe have power points so abilities can only be used x times
        skillPane.add(skillButton[0], 0, 0);
        skillPane.add(skillButton[1], 1, 0);
        skillPane.add(skillButton[2], 0, 1);
        skillPane.add(skillButton[3], 1, 1);

        skillPane.setHgap(25);
        skillPane.setVgap(15);
        skillPane.setPadding(new Insets(3,3,3,3));
        skillPane.setAlignment(Pos.CENTER_LEFT);

        monsterName = new Text(monster.getName() + " skills");
        monsterName.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        monsterName.setFill(Color.BLACK);

        skillPane.setLayoutX(110);
        skillPane.setLayoutY(45);
        monsterName.setLayoutX(skillPane.getLayoutX());
        monsterName.setLayoutY(30);

        group = new Group(background, skillPane, monsterName);

    }

    public void cpuAttack(){
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((4));
        System.out.println(randomNum);

        int damage = target.getSkillDamage()[randomNum];
        monster.setHP(monster.getHP() - damage);
        System.out.println(target.getName() + " did " + target.getSkillDamage()[randomNum] + " damage to "
                + monster.getName() + "(" + monster.getHP() + ")");



    }
    public Group getGroup(){return group;}

}