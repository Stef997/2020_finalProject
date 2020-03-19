package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class FightBoxHandler implements EventHandler<ActionEvent> {
    private FightBox fightBox;
    private Monster monster;
    private Monster enemy;


    public FightBoxHandler(fightBox){
        this.monster = monster;
    }

    @Override
    public void handle(ActionEvent e) {
        if(e.getSource().toString().equals(monster.getSkills()[0])){
            System.out.println("got" + monster.getSkills()[0]);
        }
        System.out.println(monster.getSkillDamage()[0]);
    }
}
