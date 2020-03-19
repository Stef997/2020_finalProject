package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("2020 Assignment 2");
        BorderPane pane = new BorderPane();
        TextField gameInfo = new TextField();

        gameInfo.setEditable(false);
        gameInfo.setMinHeight(100.0);
        gameInfo.setMaxWidth(600.0);
        gameInfo.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
                                            CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        gameInfo.setFont(Font.loadFont("file:resources/fonts/nintendo.ttf", 10.0));
        gameInfo.setText("Example game info. Probably output it to system input");
        deselect(gameInfo);
        
        pane.setBottom(gameInfo);
        Scene scene = new Scene(pane, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
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

    public static void main(String[] args) {
        launch(args);
    }
}
