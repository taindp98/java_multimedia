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

    public static class TimeSpinnerExample extends Application  {

    
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
                    minute = spinner.getValue().get(ChronoField.MINUTE_OF_HOUR);
                    second = spinner.getValue().get(ChronoField.SECOND_OF_MINUTE);
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
    }
     // main
    public static void main(String args[])   
    {
        Application.launch(TimeSpinnerExample.class, args);
    // TimeSpinnerExample timespinner = new TimeSpinnerExample();
    // int hour, minute, second;
    // hour = 6;
    // minute = 40;
    // second = 24;
    // System.out.println(hour);

    JFrame window = new JFrame();  
    Color c = new Color(118, 73, 190);  
    window.setBackground(c);  
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    window.setBounds(0, 0, 400, 400);  
    
    AnalogClock clock = new AnalogClock(hour, minute, second);
    window.getContentPane().add(clock);  
    window.setVisible(true);  
    clock.start();  
    }  
}
