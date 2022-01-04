import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DisplayClock extends JPanel implements Runnable  {
    Thread thread = null;
    private static final int spacing = 35;
    private int size;
    private int centerX;
    private int centerY;
    private int hour, minute, second;
    private static final float radPerSecMin = (float)(Math.PI / 30.0);
    private static final float radPerNum = (float)(Math.PI/ -6);
    Color colorSecond,colorMHour,colorNumber;

    // Constructeur
    public DisplayClock(int inithour, int initminute, int initsecond) {
        this.hour = inithour;
        this.minute = initminute;
        this.second = initsecond;
    }

    /*-------------Clock Face----------------*/
    private void drawClockFace(Graphics g) {
        // TODO Auto-generated method stub

        // tick marks
        for (int sec = 0; sec<60; sec++) {
            int ticStart;
            if (sec%5 == 0) {
                ticStart = size/2-10;
            }else{
                ticStart = size/2-5;
            }
            drawRadius(g, centerX, centerY, radPerSecMin*sec, ticStart-20, size/2-20,colorNumber.BLACK);
        }
    }

    private void drawRadius(Graphics g, int x, int y, double angle,
        int minRadius, int maxRadius, Color colorNumber) {
        float sine = (float)Math.sin(angle);
        float cosine = (float)Math.cos(angle);
        int dxmin = (int)(minRadius * sine);
        int dymin = (int)(minRadius * cosine);
        int dxmax = (int)(maxRadius * sine);
        int dymax = (int)(maxRadius * cosine);
        g.setColor(colorNumber);
        g.drawLine(x+dxmin, y+dymin, x+dxmax, y+dymax);
    }

    private void drawNumberClock(Graphics g) {
        // TODO Auto-generated method stub
        for(int num=12;num>0;num--){
            drawnum(g,radPerNum*num,num);
        }
    }

    private void drawnum(Graphics g, float angle,int n) {
        // TODO Auto-generated method stub
        float sine = (float)Math.sin(angle);
        float cosine = (float)Math.cos(angle);
        int dx = (int)((size/2-20-25) * -sine);
        int dy = (int)((size/2-20-25) * -cosine);

        g.drawString(""+n,dx+centerX-5,dy+centerY+5);
    }

    private void drawHands(Graphics g, int hour, int minute, int second, Color colorSecond, Color colorMHour) {
        // TODO Auto-generated method stub
        double rsecond = (second*6)*(Math.PI)/180;
        double rminute = ((minute + (second / 60)) * 6) * (Math.PI) / 180;
        double rhours = ((hour + (minute / 60)) * 30) * (Math.PI) / 180;

        int Asecond = 120;
        int Aminute = 80;
        int Ahour = 60;

        g.setColor(colorSecond);
        g.drawLine(centerX, centerY, centerX + (int) (Asecond * Math.cos(rsecond - (Math.PI / 2))), centerY + (int) (Asecond * Math.sin(rsecond - (Math.PI / 2))));
        g.setColor(colorMHour);
        g.drawLine(centerX, centerY, centerX + (int) (Aminute * Math.cos(rminute - (Math.PI / 2))), centerY + (int) (Aminute * Math.sin(rminute - (Math.PI / 2))));
        g.drawLine(centerX, centerY, centerX + (int) (Ahour * Math.cos(rhours - (Math.PI / 2))), centerY + (int) (Ahour * Math.sin(rhours - (Math.PI / 2))));
    }

    public void paint(Graphics g)
    {
        size = 400 -spacing;
        centerX = 400/2;
        centerY = 400/2+10;

        g.setColor(Color.BLACK);
        g.fillOval(25, spacing, 350, 350);
        g.setColor(Color.WHITE);
        g.fillOval(35, spacing+10, 330, 330);

        //To draw the Clock face
        drawClockFace(g);
        //To draw the number on the Clock face
        drawNumberClock(g);
        //To draw the hands of the Clock
        drawHands(g,this.hour,this.minute,this.second,colorSecond.RED,colorMHour.BLACK);
        //To draw the center point of the Clock
        g.setColor(Color.BLACK);
        g.fillOval(centerX-5, centerY-5, 10, 10);
        g.setColor(Color.RED);
        g.fillOval(centerX-3, centerY-3, 6, 6);
        //To calculate the coordinate of the hands of the Clock
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