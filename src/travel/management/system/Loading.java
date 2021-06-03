package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable {

    JProgressBar pb;
    Thread t;
    String username;

    public void run () {
        try {
            for (int i = 1; i <= 101; i++) {
                int max = pb.getMaximum();
                int curr = pb.getValue();
                if (curr < max) {
                    pb.setValue(pb.getValue() + 1);
                } else {
                    i = 101;
                    this.setVisible(false);
                    new Dashboard(username).setVisible(true);
                }
                Thread.sleep(50);
            }

        } catch (Exception e) {
            e.getMessage();
        }
    }

    Loading (String user) {

        this.username = user;
        t = new Thread(this);

        this.setBounds(450, 200, 650, 400);
        this.getContentPane().setBackground(Color.WHITE);
        this.setUndecorated(true);
        this.setLayout(null);

        JLabel l1 = new JLabel("Travel and Tourism Application");
        l1.setBounds(90, 20, 600, 40);
        l1.setFont(new Font("Raleway", Font.BOLD, 30));
        l1.setForeground(Color.BLUE);
        this.add(l1);

        pb = new JProgressBar();
        pb.setBounds(170, 100, 300, 25);
        pb.setForeground(Color.BLACK);
        pb.setStringPainted(true);
        this.add(pb);

        JLabel l2 = new JLabel("Please Wait...");
        l2.setBounds(255, 130, 120, 25);
        l2.setFont(new Font("Tahoma", Font.BOLD, 16));
        l2.setForeground(Color.RED);
        this.add(l2);

        JLabel l3 = new JLabel("Welcome " + username);
        l3.setBounds(20, 350, 400, 25);
        l3.setFont(new Font("Tahoma", Font.BOLD, 16));
        l3.setForeground(Color.RED);
        this.add(l3);

        t.start();
    }

    public static void main(String[] args) {
        new Loading("Anonymous").setVisible(true);
    }
}
