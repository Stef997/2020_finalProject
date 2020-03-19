package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class FightBoxHandler implements EventHandler<ActionEvent> {

    private FightBox fightBox;


    public FightBoxHandler(FightBox fightBox){
        this.fightBox = fightBox;
    }

    @Override
    public void handle(ActionEvent e) {
        if(e.getSource() == fightBox.skillButton[0]){
            System.out.println("Skill1");
            fightBox.target.setHP(fightBox.target.getHP() - fightBox.monster.getSkillDamage()[0]);
            System.out.println(fightBox.monster.getName() + " did " + fightBox.monster.getSkillDamage()[0] + " damage to "
            + fightBox.target.getName() + "(" + fightBox.target.getHP() + ")");

        }else if(e.getSource() == fightBox.skillButton[1]){
            System.out.println("Skill2");
            fightBox.target.setHP(fightBox.target.getHP() - fightBox.monster.getSkillDamage()[1]);
            System.out.println(fightBox.monster.getName() + " did " + fightBox.monster.getSkillDamage()[1] + " damage to "
                    + fightBox.target.getName() + "(" + fightBox.target.getHP() + ")");

        } else if(e.getSource() == fightBox.skillButton[2]){
            System.out.println("Skill3");
            fightBox.target.setHP(fightBox.target.getHP() - fightBox.monster.getSkillDamage()[2]);
            System.out.println(fightBox.monster.getName() + " did " + fightBox.monster.getSkillDamage()[2] + " damage to "
                    + fightBox.target.getName() + "(" + fightBox.target.getHP() + ")");

        }else if(e.getSource() == fightBox.skillButton[3]){
            System.out.println("Skill4");
            fightBox.target.setHP(fightBox.target.getHP() - fightBox.monster.getSkillDamage()[3]);
            System.out.println(fightBox.monster.getName() + " did " + fightBox.monster.getSkillDamage()[3] + " damage to "
                    + fightBox.target.getName() + "(" + fightBox.target.getHP() + ")");
        }

    }
}
