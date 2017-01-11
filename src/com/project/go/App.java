package com.project.go;/**
 * Created by Joe on 12/20/2016.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.project.go.Wikiparser.getTSymbols;
import static com.project.go.Wikiparser.*;

public class App extends Application { //all that excess at the end is used to call event handlers
    //variables go here
    Button buttonRun, buttonExit;
    Scene scene, scene1;
    TextArea area;
    static String appText;
    static ProgressBar pb;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException{//starts the stage
//write your application below.
        DateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
        Date dateobj = new Date();

        primaryStage.setTitle("BLSH"); //sets the stage title
        Text centertext = new Text("Welcome To BLSH, press Run to get today's report");
        buttonRun = new Button("Run");//instantiate the button
        buttonExit = new Button("Exit");//instantiate the button
        ProgressBar pb = new ProgressBar(0);//instantiate the progress bar

        //this is a lambda function that is treated like an event handler
        //but with much less code
        //exit button
        buttonExit.setOnAction(e -> primaryStage.close());
        //dropdown menu
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("All (A)", "Consumer Discretionary (D)", "Consumer Staples (S)", "Energy (E)","Financial (F)", "Healthcare (H)", "Industrial (I)", "Real Estate (R)", "Info. Tech. (T)", "Utilities (U)");
        choiceBox.setValue("All (A)");


        //set layout 1
        HBox bottom = new HBox();
        bottom.getChildren().addAll(choiceBox, buttonRun, buttonExit, pb);//positions button in the middle
        BorderPane layout = new BorderPane(); // you need to make a layout before anything displays,
        layout.setBottom(bottom);
        layout.setTop(centertext);
        layout.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        layout.setPrefSize(600,400);

        //set text area
        final TextArea area = new TextArea();
        area.setPrefRowCount(10);
        area.setPrefColumnCount(1000);
        area.setWrapText(true);
        area.setPrefWidth(150);
        layout.setAlignment(area, Pos.CENTER);
        layout.setCenter(area);
        String stringBuilderOut = "Weclome To BLSH\nToday's date is: " + df.format(dateobj)+ "\nPress the Run button to run report";
        area.setText(stringBuilderOut);
        buttonRun.setOnAction(e -> {
            try {
                area.setText(getChoice(choiceBox));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });


        //set first scene
        Scene scene = new Scene(layout); //after making the layout, you need to create a scene (what layout, size, size)
        primaryStage.setScene(scene);//puts scene on stage
        primaryStage.show();

    }
//method to get data for stocks just like Main class
    public static String getChoice(ChoiceBox<String> choiceBox) throws IOException{
        String choice = choiceBox.getValue();

        switch (choice) {
            case "All (A)":
                System.out.println("Pulling up All");
                //pulls up all
                String [] sym = Wikiparser.getAllSymbols();
                for (int i = 1 ; i <506 ; i++){
                    String x = sym[i];
                    HtmlParser.parser(x);

                }
                return PasstoGui.ssb.toString();


            case "Consumer Discretionary (D)":
                System.out.println("Pulling up Consumer Disc.");
                String [] sym1 = getDSymbols();
                for (int i = 1 ; i < getDSymbols().length ; i++){
                    String x = sym1[i];
                    HtmlParser.parser(x);
                }
                return PasstoGui.ssb.toString();


            case "Consumer Staples (S)":
                System.out.println("Pulling up Consumer Staples");
                String [] sym2 = getSSymbols();
                for (int i = 1 ; i < getSSymbols().length ; i++){
                    String x = sym2[i];
                    HtmlParser.parser(x);
                }
                return PasstoGui.ssb.toString();


            case "Energy (E)":
                System.out.println("Pulling up Energy");
                String [] sym3 = getESymbols();
                for (int i = 1 ; i < getESymbols().length ; i++){
                    String x = sym3[i];
                    HtmlParser.parser(x);
                }
                return PasstoGui.ssb.toString();

            case "Financial (F)":
                System.out.println("Pulling up Financial");
                String [] sym4 = getFSymbols();
                for (int i = 1 ; i < getFSymbols().length ; i++){
                    String x = sym4[i];
                    HtmlParser.parser(x);
                }
                return PasstoGui.ssb.toString();

            case "Healthcare (H)":
                System.out.println("Pulling up Health Care");
                String [] sym5 = getHSymbols();
                for (int i = 1 ; i < getHSymbols().length ; i++){
                    String x = sym5[i];
                    HtmlParser.parser(x);
                }
                return PasstoGui.ssb.toString();

            case "Industrial (I)":
                System.out.println("Pulling up Industrial");
                String [] sym6 = getISymbols();
                for (int i = 1 ; i < getISymbols().length ; i++){
                    String x = sym6[i];
                    HtmlParser.parser(x);
                }
                return PasstoGui.ssb.toString();

            case "Real Estate (R)":
                System.out.println("Pulling up Real Estate");
                String [] sym7 = getRSymbols();
                for (int i = 1 ; i < getRSymbols().length ; i++){
                    String x = sym7[i];
                    HtmlParser.parser(x);
                }
                return PasstoGui.ssb.toString();

            case "Info. Tech. (T)":
                System.out.println("Pulling up Information Technology");
                String [] sym8 = getTSymbols();
                for (int i = 1 ; i < getTSymbols().length ; i++){
                    String x = sym8[i];
                    HtmlParser.parser(x);
                }
                return PasstoGui.ssb.toString();


            case "Utilities (U)":
                System.out.println("Pulling up Utilities");
                String [] sym9 = getUSymbols();
                for (int i = 1 ; i < getUSymbols().length ; i++){
                    String x = sym9[i];
                    HtmlParser.parser(x);
                }
                return PasstoGui.ssb.toString();

            default: System.out.println("not a valid sector");
                //*this is an error message you get when you input a wrong sector.
                return PasstoGui.ssb.toString();

        }//end swtich statement




    }//end getChoice




    }//end of the class






















