package sample;

import javafx.scene.image.Image;

public class Monster {

    private Image monsterImage;
    private String skills[] = new String[4];
    private int skillDamage[] = new int[4];
    //maybe a specialSkill List for abilities like dodge or leer that do 0 damage
    private int HP;
    private String name;

    public Monster(String skills[], int skillDamage[], int HP, String name){
        this.name = name;
        this.skills = skills;
        this.skillDamage = skillDamage;
        this.HP = HP;

    }

    public int getHP(){
        return this.HP;
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

}
