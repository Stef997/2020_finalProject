package sample;
import com.sun.javafx.scene.paint.GradientUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import java.io.*;
import java.util.Scanner;
import java.util.Random;
import javafx.scene.layout.Pane;
import javafx.geometry.Point2D;
import javafx.animation.PathTransition;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Main extends Application {
    //Question 1 variables
    final static File dir = new File("/Users/slyce/Desktop/csci2020u/assignment1/src/sample/Cards");

    //Question 3 variables
    private Circle mainCircle = new Circle(100, 100, 100);
    private double radius = 10;
    private Circle[] circle = {new Circle(40, 40, 10), new Circle(140, 40, 10), new Circle(60, 140, 10)};
    private Line line1 = new Line();
    private Line line2 = new Line();
    private Line line3 = new Line();
    private Text[] text = {new Text(), new Text(), new Text()};

    //Question 4 variables
    int group[] = new int[26];




    @Override
    public void start(Stage primaryStage) throws Exception {


        //QUESTION 1
        File[] files = dir.listFiles();
        Random rand = new Random();
        File file1 = files[rand.nextInt(files.length)];
        File file2 = files[rand.nextInt(files.length)];
        File file3 = files[rand.nextInt(files.length)];

        FileInputStream inputStream = new FileInputStream(file1);
        Image image1 = new Image(inputStream);
        ImageView imageView1 = new ImageView(image1);

        FileInputStream inputStream2 = new FileInputStream(file2);
        Image image2 = new Image(inputStream2);
        ImageView imageView2 = new ImageView(image2);

        FileInputStream inputStream3 = new FileInputStream(file3);
        Image image3 = new Image(inputStream3);
        ImageView imageView3 = new ImageView(image3);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(imageView1, imageView2, imageView3);



//        Scene scene = new Scene(hbox);
//        primaryStage.setScene(scene);
//        primaryStage.show();




        //QUESTION 2

        //Make titles and textfields
        Text text1 = new Text("Investment Amount");
        Text text2 = new Text("Years");
        Text text3 = new Text("Annual Interest Rate");
        Text text4 = new Text("Future Value");
        TextField number1 = new TextField();
        TextField number2 = new TextField();
        TextField number3 = new TextField();
        TextField number4 = new TextField();

        //Create calculate button
        Button btCalc = new Button("Calculate");
        btCalc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                float x = Float.parseFloat(number1.getText());
                float y = Float.parseFloat(number2.getText());
                float z = Float.parseFloat(number3.getText());
                float monthlyIR = ((12.0f*y)/(((12.0f*y)* z)/y));

                float futureVal = (float) (x * Math.pow((1.00f + monthlyIR),(y*12.0f)));
                String value = Float.toString(futureVal);
                number4.setText(value);
            }
        });



        //Create gridpane and position items
        GridPane gridPane = new GridPane();
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.add(text1, 0, 0);
        gridPane.add(number1, 1, 0);
        gridPane.add(text2, 0, 1);
        gridPane.add(number2, 1, 1);
        gridPane.add(text3, 0, 2);
        gridPane.add(number3, 1, 2);
        gridPane.add(text4, 0, 3);
        gridPane.add(number4, 1, 3);
        gridPane.add(btCalc,1,4);


        //Show primary stage
//        Scene scene = new Scene(gridPane);
//        primaryStage.setScene(scene);
//        primaryStage.show();







        //QUESTION 3
        //Create new pane
        Pane pane = new Pane();
        setLines();
        //Set mainCircle color
        mainCircle.setFill(Color.TRANSPARENT);
        mainCircle.setStroke(Color.BLACK);
        pane.getChildren().addAll(mainCircle, circle[0], circle[1], circle[2], line1, line2, line3, text[0], text[1], text[2]);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setTitle("Assignment 1"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        circle[0].setOnMouseDragged(e -> {
            if (circle[0].contains(e.getX(), e.getY())) {
                // Recompute and display angles
                circle[0].setCenterX(e.getX());
                circle[0].setCenterY(e.getY());
                setLines();
            }
        });

        circle[1].setOnMouseDragged(e -> {
            if (circle[1].contains(e.getX(), e.getY())) {
                // Recompute and display angles
                circle[1].setCenterX(e.getX());
                circle[1].setCenterY(e.getY());
                setLines();
            }
        });

        circle[2].setOnMouseDragged(e -> {
            if (circle[2].contains(e.getX(), e.getY())) {
                // Recompute and display angles
                circle[2].setCenterX(e.getX());
                circle[2].setCenterY(e.getY());
                setLines();
            }
        });








        //QUESTION 4
        groupData();
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> barChart =
                new BarChart<>(xAxis, yAxis);
        barChart.setCategoryGap(0);
        barChart.setBarGap(0);

        xAxis.setLabel("Frequency");
        yAxis.setLabel("Letters");

        XYChart.Series series1 = new XYChart.Series();
        series1.getData().add(new XYChart.Data("A", group[0]));
        series1.getData().add(new XYChart.Data("B", group[1]));
        series1.getData().add(new XYChart.Data("C", group[2]));
        series1.getData().add(new XYChart.Data("D", group[3]));
        series1.getData().add(new XYChart.Data("E", group[4]));
        series1.getData().add(new XYChart.Data("F", group[5]));
        series1.getData().add(new XYChart.Data("G", group[6]));
        series1.getData().add(new XYChart.Data("H", group[7]));
        series1.getData().add(new XYChart.Data("I", group[8]));
        series1.getData().add(new XYChart.Data("J", group[9]));
        series1.getData().add(new XYChart.Data("K", group[10]));
        series1.getData().add(new XYChart.Data("L", group[11]));
        series1.getData().add(new XYChart.Data("M", group[12]));
        series1.getData().add(new XYChart.Data("N", group[13]));
        series1.getData().add(new XYChart.Data("O", group[14]));
        series1.getData().add(new XYChart.Data("P", group[15]));
        series1.getData().add(new XYChart.Data("Q", group[16]));
        series1.getData().add(new XYChart.Data("R", group[17]));
        series1.getData().add(new XYChart.Data("S", group[18]));
        series1.getData().add(new XYChart.Data("T", group[19]));
        series1.getData().add(new XYChart.Data("U", group[20]));
        series1.getData().add(new XYChart.Data("V", group[21]));
        series1.getData().add(new XYChart.Data("W", group[22]));
        series1.getData().add(new XYChart.Data("X", group[23]));
        series1.getData().add(new XYChart.Data("Y", group[24]));
        series1.getData().add(new XYChart.Data("Z", group[25]));


        barChart.getData().addAll(series1);
        Text text5 = new Text("Filename: ");
        TextField bartext = new TextField();
        Button viewButton = new Button("View");
        viewButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bartext.getText();

            }
        });



        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll(text5, bartext, viewButton);


//        GridPane gridPane1 = new GridPane();
//        gridPane1.add(barChart, 0, 0);
//        gridPane1.add(hBox1, 0,1);
//        Scene scene = new Scene(gridPane1, 400, 400);
//
//        primaryStage.setTitle("Assignment 1");
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


    //count data population in groups
    private void groupData() throws FileNotFoundException {
        for (int i = 0; i < 26; i++) {
            group[i] = 0;
        }
        Scanner input = new Scanner(new File("/Users/slyce/Desktop/csci2020u/assignment1/src/sample/passage.txt"));
        while (input.hasNextLine()) {
            String answer = input.nextLine();
            answer = answer.toLowerCase();
            char[] characters = answer.toCharArray();
            for (int i = 0; i < characters.length; i++) {
                if ((characters[i] >= 'a') && (characters[i] <= 'z')) {
                    group[characters[i] - 'a']++;
                }
            }
        }

    }


    private void setLines() {
        line1.setStartX(circle[0].getCenterX());
        line1.setStartY(circle[0].getCenterY());
        line1.setEndX(circle[1].getCenterX());
        line1.setEndY(circle[1].getCenterY());
        line2.setStartX(circle[0].getCenterX());
        line2.setStartY(circle[0].getCenterY());
        line2.setEndX(circle[2].getCenterX());
        line2.setEndY(circle[2].getCenterY());
        line3.setStartX(circle[1].getCenterX());
        line3.setStartY(circle[1].getCenterY());
        line3.setEndX(circle[2].getCenterX());
        line3.setEndY(circle[2].getCenterY());

        // Compute angles
        double a = new Point2D(circle[2].getCenterX(), circle[2].getCenterY()).
                distance(circle[1].getCenterX(), circle[1].getCenterY());
        double b = new Point2D(circle[2].getCenterX(), circle[2].getCenterY()).
                distance(circle[0].getCenterX(), circle[0].getCenterY());
        double c = new Point2D(circle[1].getCenterX(), circle[1].getCenterY()).
                distance(circle[0].getCenterX(), circle[0].getCenterY());
        double[] angle = new double[3];
        angle[0] = Math.acos((a * a - b * b - c * c) / (-2 * b * c));
        angle[1] = Math.acos((b * b - a * a - c * c) / (-2 * a * c));
        angle[2] = Math.acos((c * c - b * b - a * a) / (-2 * a * b));

        for (int i = 0; i < 3; i++) {
            text[i].setX(circle[i].getCenterX());
            text[i].setY(circle[i].getCenterY() - radius);
            text[i].setText(String.format("%.2f", Math.toDegrees(angle[i])));
        }
    }

}