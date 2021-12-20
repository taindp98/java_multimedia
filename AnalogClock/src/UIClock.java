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
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;

public class UIClock extends JPanel implements Runnable  {
    Thread thread = null;

    SimpleDateFormat formatter = new SimpleDateFormat("s", Locale.getDefault());
    Date currentDate;
    int xcenter = 175, ycenter = 175;

    // inherit from Graphics class
    private void drawStructure(Graphics g) {
        g.setFont(new Font("Dialog", Font.BOLD, 30));

        // final ImageIcon icon = new ImageIcon("../uspn_square.jpg");
        // Image img = icon.getImage();
        Color bgcolor = Color.decode("0x050B2B");
        g.setColor(bgcolor);
        // g.drawImage(img, xcenter, ycenter, this);
        g.fillOval(xcenter - 150, ycenter - 150, 300, 300);
        Color strcolor = Color.decode("0xD4173F");
        // g.setColor(strcolor);
        // g.drawString("Java Multimedia", 113, 300);
        g.setColor(strcolor);
        g.drawString("9", xcenter - 145, ycenter + 10);
        g.drawString("3", xcenter + 135, ycenter + 10);
        g.drawString("12", xcenter - 20, ycenter - 120);
        g.drawString("6", xcenter - 10, ycenter + 145);
    }

    private int hour, minute, second;

    // Constructeur
    public UIClock(int inithour, int initminute, int initsecond) {
        this.hour = inithour;
        this.minute = initminute;
        this.second = initsecond;
    }

    public void paint(Graphics g)
    {
        int xhour, yhour, xminute, yminute, xsecond, ysecond;
        double anglesecond, angleminute, anglehour;


        drawStructure(g);


        xsecond = (int)(Math.cos(this.second * Math.PI / 30 - Math.PI / 2) * 120 + xcenter);
        ysecond = (int)(Math.sin(this.second * Math.PI / 30 - Math.PI / 2) * 120 + ycenter);
        xminute = (int)(Math.cos(this.minute * Math.PI / 30 - Math.PI / 2) * 80 + xcenter);
        yminute = (int)(Math.sin(this.minute * Math.PI / 30 - Math.PI / 2) * 80 + ycenter);
        xhour = (int)(Math.cos((this.hour * 30 + minute / 2) * Math.PI / 180 - Math.PI / 2) * 40 + xcenter);
        yhour = (int)(Math.sin((this.hour * 30 + minute / 2) * Math.PI / 180 - Math.PI / 2) * 40 + ycenter);

        Color scolor = Color.decode("0x1975CA");
        Color mcolor = Color.decode("0xFFFFFF");
        Color hcolor = Color.decode("0xFE0089");
        g.setColor(scolor);
        g.drawLine(xcenter, ycenter, xsecond, ysecond);
        g.setColor(mcolor);
        g.drawLine(xcenter, ycenter - 1, xminute, yminute);
        g.drawLine(xcenter - 1, ycenter, xminute, yminute);
        g.setColor(hcolor);
        g.drawLine(xcenter, ycenter - 1, xhour, yhour);
        g.drawLine(xcenter - 1, ycenter, xhour, yhour);

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
}   