package sample;

import javafx.scene.Group;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class IOMenu {

    private Group group = new Group();

    private MenuBar menuBar = new MenuBar();
    public FileChooser fileChooser = new FileChooser();
    public Stage mainStage;

    private Menu menu = new Menu("Menu");
    public MenuItem load = new MenuItem("Load");
    public MenuItem save = new MenuItem("Save");

    public IOMenuHandler menuHandler;
    public FightBox fightBox;

    public IOMenu(FightBox fightBox, Stage mainStage){

        this.fightBox = fightBox;
        this.mainStage = mainStage;
        this.menuHandler = new IOMenuHandler(this);

        init();

    }

    private void init(){

        load.setOnAction(menuHandler);
        save.setOnAction(menuHandler);
        menu.getItems().addAll(load, save);
        menuBar.getMenus().addAll(menu);
        group.getChildren().add(menuBar);
    }
    public FightBox getFightBox(){
        return this.fightBox;
    }
    public void setFightBox(FightBox fightBox){
        this.fightBox = fightBox;
    }
    public Group getGroup(){
        return this.group;
    }
}
