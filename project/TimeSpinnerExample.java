import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;

import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.transform.Translate; 
import javafx.geometry.Pos;
import javafx.event.EventHandler;

public class TimeSpinnerExample extends Application  {

    private int hour;

    @Override
    public void start(Stage primaryStage) {

        TimeSpinner spinner = new TimeSpinner();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");

        // init value in spinner box
        // spinner.valueProperty().addListener((obs, oldTime, newTime) -> 
        
        //     System.out.println(formatter.format(newTime))
            
        //     );
        StackPane root = new StackPane(spinner);

        Button btn = new Button("Apply");
        btn.setTranslateX(200);
        primaryStage.setTitle("Manual Setting Time");
        root.getChildren().add(btn);

                // action event
        EventHandler <ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                hour = spinner.getValue().get(ChronoField.CLOCK_HOUR_OF_DAY);
                // int minute = spinner.getValue().get(ChronoField.MINUTE_OF_HOUR);
                // int second = spinner.getValue().get(ChronoField.SECOND_OF_MINUTE);
                // int[] arr = new int [3]; 
                // arr[0] = hour;
                // arr[1] = minute;
                // arr[2] = second;
                // System.out.println(arr);
                primaryStage.close();
            }
        };
        btn.setOnAction(event);

        Scene scene = new Scene(root, 700, 120);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    int getData() {
        return hour;
    }
    // public static void main(String[] args) {
    //     launch(args);
    // }
}