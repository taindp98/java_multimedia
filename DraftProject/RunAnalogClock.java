import java.awt.Color;  
import java.awt.Font;  
import java.awt.Graphics;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Locale;  
import javax.swing.JFrame;  
import javax.swing.JPanel;  

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.transform.Translate; 
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import java.util.Calendar;


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
            primaryStage.setTitle("Manual Setting Time");
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
        Application.launch(RunTimeSpinner.class, args);

    JFrame window = new JFrame();  
    // Color c = new Color(118, 73, 190);  
    Color wallcolor = Color.decode("0x495B53");    
    window.setBackground(wallcolor);  
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    window.setBounds(0, 0, 400, 400);  
    
    AnalogClock clock = new AnalogClock(hour, minute, second);
    window.getContentPane().add(clock);  
    window.setVisible(true);  
    clock.start();  
    }  
}
