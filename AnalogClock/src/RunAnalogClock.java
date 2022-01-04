import javax.swing.JFrame;

import java.awt.Color;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class RunAnalogClock {
    static int hour, minute, second;

    public static class RunTimeSpinner extends Application  {


        @Override
        public void start(Stage primaryStage) {

            TimeSpinner spinner = new TimeSpinner();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");

            spinner.valueProperty().addListener((obs, oldTime, newTime) ->

                    System.out.println(formatter.format(newTime))

            );
            StackPane root = new StackPane(spinner);

            Button btn = new Button("Apply");
            btn.setTranslateX(200);
            primaryStage.setTitle("Time Picker");
            root.getChildren().add(btn);

            // action event
            EventHandler <ActionEvent> event = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e)
                {
                    hour = spinner.getValue().get(ChronoField.CLOCK_HOUR_OF_DAY);
                    minute = spinner.getValue().get(ChronoField.MINUTE_OF_HOUR);
                    second = spinner.getValue().get(ChronoField.SECOND_OF_MINUTE);
                    primaryStage.close();
                }
            };
            btn.setOnAction(event);

            Scene scene = new Scene(root, 600, 120);
            primaryStage.setScene(scene);
            primaryStage.show();

        }
    }
    // main
    public static void main(String args[])
    {
        // Launch the JavaFX application is TimeSpinner Class
        Application.launch(RunTimeSpinner.class, args);

        // Create the new application window from Java Swing
        JFrame window = new JFrame();
        // Set the background color with a color code
        Color wallcolor = Color.decode("0x495B53");
        window.setBackground(wallcolor);
        // Set the window operation
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set size and position for the window
        window.setBounds(1200, 200, 420, 460);

        // Create a new object by inheriting DisplayClock Class
        DisplayClock clock = new DisplayClock(hour, minute, second);

        // Add the clock into the application window
        window.getContentPane().add(clock);
        window.setVisible(true);

        // Run the Threads in the clock object
        clock.start();
    }
}
