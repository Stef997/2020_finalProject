package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.FileInputStream;

public class GameInfoBox{

    private Group group;
    final private TextField gameInfo = new TextField();
    private String infoText = "";

    public GameInfoBox(){
        init();
    }

    void init(){
        gameInfo.setEditable(false);
        gameInfo.setMinHeight(150.0);
        gameInfo.setMinWidth(600.0);
        gameInfo.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        gameInfo.setFont(Font.loadFont("file:resources/fonts/nintendo.ttf", 10.0));
        deselect(gameInfo);

        gameInfo.setLayoutX(45.0);
        gameInfo.setLayoutY(110.0);

        group = new Group(gameInfo);
    }

    private void deselect(TextField textField) {
        Platform.runLater(() -> {
            if (!(textField.selectionProperty().get().getEnd() == 0)) {
                textField.selectEnd();
                textField.deselect();
            } else {
                if (!(textField.getText().length() > 0)) {
                    textField.selectEnd();
                    textField.deselect();
                } else {
                    deselect(textField);
                }
            }
        });
    }

    public Group getGroup(String text){
        infoText = text;
        gameInfo.setText(infoText);
        return group;
    }

}
