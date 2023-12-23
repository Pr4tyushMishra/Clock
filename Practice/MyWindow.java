package Practice;

import javax.swing.*;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyWindow extends JFrame {

   private JLabel heading;
   private JLabel clockLabel;
   private Font font = new Font(" ",Font.BOLD,35);
   
   MyWindow(){
    super.setTitle("MyClock");
    super.setSize(400,400);
    super.setLocation(300,50);
    this.createGUI();
    super.setVisible(true);
    this.startClock();
   }

   public void createGUI(){
    //GUI
    heading = new JLabel("MyClock");
    clockLabel = new JLabel("Clock");

    heading.setFont(font);
    clockLabel.setFont(font);
    this.setLayout(new GridLayout(2,1));
    this.add(heading);
    this.add(clockLabel);
   }

   public void startClock(){
      //USE THIS PART OF CODE IF YOU DON'T WANT TO USE THREAD.
    /*Timer timer = new Timer(1000,new ActionListener() {
        @Override
       public void actionPerformed(ActionEvent e){
            Date d = new Date();
            SimpleDateFormat sfd = new SimpleDateFormat("hh:mm:ss");
            String dateTime = sfd.format(d);
            clockLabel.setText(dateTime);
        }
    } );*/

      //USING THREAD.
    Thread t = new Thread(){
    public void run(){
        try
        {
            while(true)
            {
                Date d = new Date();
                SimpleDateFormat sfd = new SimpleDateFormat("hh:mm:ss a");
                String dateTime = sfd.format(d);
                clockLabel.setText(dateTime);

                Thread.currentThread().sleep(1000);
                //Thread.sleep(1000)
            }
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    
    }
   };t.start();
   }
}
