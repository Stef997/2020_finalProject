package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GameInfoBox{


    public GameInfoBox(){
        init();
    }

    void init(){
        TextField gameInfo = new TextField();

        gameInfo.setEditable(false);
        gameInfo.setMinHeight(100.0);
        gameInfo.setMaxWidth(600.0);
        gameInfo.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        gameInfo.setFont(Font.loadFont("file:resources/fonts/nintendo.ttf", 10.0));
        gameInfo.setText("Example game info. Probably output it to system input");
        deselect(gameInfo);

        Group group = new Group(gameInfo);
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


}
