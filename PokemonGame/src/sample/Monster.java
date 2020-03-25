package sample;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Monster {

    private Image monsterImage;
    private String skills[] = new String[4];
    private int skillDamage[] = new int[4];

    private final Image FIRETYPE = new Image(new FileInputStream("images/sprite1.png"));
    private final Image WATERTYPE = new Image(new FileInputStream("images/WaterStarter-1.png.png"));
    private final Image GRASSTYPE = new Image(new FileInputStream("images/GrassStart-1.png.png"));
    private final Image TARGET_DUMMY = new Image(new FileInputStream("images/unnamed.png"));

    //maybe a specialSkill List for abilities like dodge or leer that do 0 damage
    private int HP;
    private String name;
    private String type;


    public Monster(String skills[], int skillDamage[], int HP, String name, String type) throws FileNotFoundException {
        this.name = name;
        this.skills = skills;
        this.skillDamage = skillDamage;
        this.type = type;
        this.HP = HP;
        imageInit();
    }

    public Monster(int skillDamage[], int HP, String name) throws FileNotFoundException {
        this.name = name;
        this.skillDamage = skillDamage;
        this.HP = HP;
        imageInit();
    }

    private void imageInit(){
        //if fire iif whatever
        if(this.type == "fire"){
            monsterImage = FIRETYPE;
        }else if(this.type == "water"){
            monsterImage = WATERTYPE;
        }else if(this.type == "grass"){
            monsterImage = GRASSTYPE;
        }else{
            monsterImage = TARGET_DUMMY;
        }
    }

    public Image getMonsterImage(){
        return this.monsterImage;
    }
    public int getHP(){
        return HP;
    }
    public int[] getSkillDamage(){
        return this.skillDamage;
    }
    public String getName(){
        return this.name;
    }
    public String[] getSkills(){
        return this.skills;
    }

    public void setHP(int HP){
        this.HP = HP;
    }
    public String toString(){
        // Skill names, skill damage, name,0ty0e, HP
        return skills[0] + ", " + skills[1] + ", " + skills[2] + ", " + skills[3] + ", " +
                skillDamage[0] + ", " +  skillDamage[1] + ", " + skillDamage[2] + ", " + skillDamage[3] + ", " +
                name + ", " + type + ", " + HP;
    }
}
