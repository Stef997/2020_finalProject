package sample;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;

public class FightBoxHandler implements EventHandler<ActionEvent> {

    private FightBox fightBox;
    public Thread thread;

    public FightBoxHandler(FightBox fightBox){
        this.fightBox = fightBox;
        thread = new Thread(fightBox);
        thread.run();
    }
    @Override
    public void handle(ActionEvent e) {
        if(e.getSource() == fightBox.skillButton[0]){
            BorderPane bp = Main.getBp();
            fightBox.target.setHP(fightBox.target.getHP() - fightBox.monster.getSkillDamage()[0]);
            String text = fightBox.monster.getName() + " did " + fightBox.monster.getSkillDamage()[0] + " damage to "
                    + fightBox.target.getName() + "(" + fightBox.target.getHP() + ")";
            fightBox.setInfo(text);
            fightBox.setGameInfoBox(fightBox.getGameInfoBox());
            sleep(bp);

        }else if(e.getSource() == fightBox.skillButton[1]){
            BorderPane bp = Main.getBp();
            fightBox.target.setHP(fightBox.target.getHP() - fightBox.monster.getSkillDamage()[1]);
            String text = fightBox.monster.getName() + " did " + fightBox.monster.getSkillDamage()[1] + " damage to "
                    + fightBox.target.getName() + "(" + fightBox.target.getHP() + ")";
            fightBox.setInfo(text);
            fightBox.setGameInfoBox(fightBox.getGameInfoBox());
            sleep(bp);

        } else if(e.getSource() == fightBox.skillButton[2]){
            BorderPane bp = Main.getBp();
            fightBox.target.setHP(fightBox.target.getHP() - fightBox.monster.getSkillDamage()[2]);
            String text = fightBox.monster.getName() + " did " + fightBox.monster.getSkillDamage()[2] + " damage to "
                    + fightBox.target.getName() + "(" + fightBox.target.getHP() + ")";
            fightBox.setInfo(text);
            fightBox.setGameInfoBox(fightBox.getGameInfoBox());
            sleep(bp);

        }else if(e.getSource() == fightBox.skillButton[3]){
            BorderPane bp = Main.getBp();
            fightBox.target.setHP(fightBox.target.getHP() - fightBox.monster.getSkillDamage()[3]);
            String text = fightBox.monster.getName() + " did " + fightBox.monster.getSkillDamage()[3] + " damage to "
                    + fightBox.target.getName() + "(" + fightBox.target.getHP() + ")";
            fightBox.setInfo(text);
            fightBox.setGameInfoBox(fightBox.getGameInfoBox());
            sleep(bp);

        }
        fightBox.cpuAttack();
    }

    public void sleep(BorderPane bp) {
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() {
                try {
                    thread.sleep(2500);
                } catch (java.lang.InterruptedException e) {}
                return null;
            }
        };

        sleeper.setOnRunning(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent workerStateEvent) {
                bp.setBottom(fightBox.getGroup());
            }
        });
        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent workerStateEvent) {
                fightBox.setGroup(new Group(fightBox.getBackground(), fightBox.getSkillPane(), fightBox.getMonsterName()));
                bp.setBottom(fightBox.getGroup());
            }
        });

        new Thread(sleeper).start();
    }
}
