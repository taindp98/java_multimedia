import java.awt.Color;  
import java.awt.Font;  
import java.awt.Graphics;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Locale;  
import javax.swing.JFrame;  
import javax.swing.JPanel;  
import java.util.concurrent.TimeUnit;

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

public class AnalogClock extends JPanel implements Runnable  {  
    Thread thread = null;  
    
    SimpleDateFormat formatter = new SimpleDateFormat("s", Locale.getDefault());  
    Date currentDate;  
    int xcenter = 175, ycenter = 175, lastxs = 0, lastys = 0, lastxm = 0, lastym = 0, lastxh = 0, lastyh = 0;  

    // inherit from Graphics class
    private void drawStructure(Graphics g) {  
    g.setFont(new Font("TimesRoman", Font.BOLD, 20));  
    g.setColor(Color.black);  
    g.fillOval(xcenter - 150, ycenter - 150, 300, 300);  
    g.setColor(Color.blue);  
    g.drawString("Java Multimedia", 113, 300);  
    g.setColor(Color.green);  
    g.drawString("9", xcenter - 145, ycenter + 0);  
    g.drawString("3", xcenter + 135, ycenter + 0);  
    g.drawString("12", xcenter - 10, ycenter - 130);  
    g.drawString("6", xcenter - 10, ycenter + 145);  
    }  

    private int hour, minute, second;

    // Constructeur
    public AnalogClock(int inithour, int initminute, int initsecond) {
        this.hour = inithour;
        this.minute = initminute;
        this.second = initsecond;
        }

    public void paint(Graphics g)   
    {  
    int xhour, yhour, xminute, yminute, xsecond, ysecond;  

    drawStructure(g);  

    // currentDate = new Date();  
    // formatter.applyPattern("s");  
    // this.second = Integer.parseInt(formatter.format(currentDate));  
    // formatter.applyPattern("m");  
    // this.minute = Integer.parseInt(formatter.format(currentDate));  
    // formatter.applyPattern("h");  
    // this.hour = Integer.parseInt(formatter.format(currentDate));  
    // System.out.println(this.second);

    xsecond = (int)(Math.cos(this.second * 3.14 / 30 - 3.14 / 2) * 120 + xcenter);  
    ysecond = (int)(Math.sin(this.second * 3.14 / 30 - 3.14 / 2) * 120 + ycenter);  
    xminute = (int)(Math.cos(this.minute * 3.14 / 30 - 3.14 / 2) * 100 + xcenter);  
    yminute = (int)(Math.sin(this.minute * 3.14 / 30 - 3.14 / 2) * 100 + ycenter);  
    xhour = (int)(Math.cos((this.hour * 30 + minute / 2) * 3.14 / 180 - 3.14 / 2) * 80 + xcenter);  
    yhour = (int)(Math.sin((this.hour * 30 + minute / 2) * 3.14 / 180 - 3.14 / 2) * 80 + ycenter);  
    

    // Erase if necessary, and redraw    

    // g.setColor(Color.magenta);  
    // if (xsecond != lastxs || ysecond != lastys)   
    // {  
    // g.drawLine(xcenter, ycenter, lastxs, lastys);  
    // }  
    // if (xminute != lastxm || yminute != lastym)   
    // {  
    // g.drawLine(xcenter, ycenter - 1, lastxm, lastym);  
    // g.drawLine(xcenter - 1, ycenter, lastxm, lastym);  
    // }  
    // if (xhour != lastxh || yhour != lastyh)   
    // {  
    // g.drawLine(xcenter, ycenter - 1, lastxh, lastyh);  
    // g.drawLine(xcenter - 1, ycenter, lastxh, lastyh);  
    // }  
    g.setColor(Color.magenta);  
    g.drawLine(xcenter, ycenter, xsecond, ysecond);  
    g.setColor(Color.red);  
    g.drawLine(xcenter, ycenter - 1, xminute, yminute);  
    g.drawLine(xcenter - 1, ycenter, xminute, yminute);  
    g.setColor(Color.green);  
    g.drawLine(xcenter, ycenter - 1, xhour, yhour);  
    g.drawLine(xcenter - 1, ycenter, xhour, yhour);  
    // lastxs = xsecond;  
    // lastys = ysecond;  
    // lastxm = xminute;  
    // lastym = yminute;  
    // lastxh = xhour;  
    // lastyh = yhour;  

    if(this.second < 59){
        this.second++;
    }else{
        this.second = 0;
        if(this.minute < 59){
            this.minute++;
        }else{
            this.minute = 0;
            if(this.hour < 11){
                this.hour++;
            }else{
                this.hour = 0;
            }
        }
    }

    
    try   
        {  
        Thread.sleep(1000);  
        // System.out.println(this.minute);
        }catch (InterruptedException e) {}  

    }  

    public void start()   
        {  
        if (thread == null){  
        thread = new Thread(this);  
        // make the hour, minute and second
        thread.start();  
            }  
        }  
    public void stop()   
        {  
            thread = null;  
        }  
    public void run()   
        {  
            while (thread != null){  
            try   
            {  
            Thread.sleep(0);  
            }   
            catch (InterruptedException e) {}  
            repaint();  
            }  
            thread = null;  
        }
    
    public void update(Graphics g)   
        {  
            paint(g);  
        }  

//  // main
//  public static void main(String args[])   
//  {  
//   JFrame window = new JFrame();  
//   Color c = new Color(118, 73, 190);  
//   window.setBackground(c);  
//   window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
//   window.setBounds(0, 0, 400, 400);  
//   AnalogClock clock = new AnalogClock();  
//   window.getContentPane().add(clock);  
//   window.setVisible(true);  
//   clock.start();  
//  }  
}   