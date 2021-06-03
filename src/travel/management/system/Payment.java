package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Payment extends JFrame implements ActionListener {

    JButton b1, b2;

    Payment () {

        this.setBounds(350, 150, 800, 600);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l = new JLabel(i3);
        l.setBounds(0, 0, 800, 600);
        this.add(l);

        b1 = new JButton("Pay");
        b1.setBounds(300, 0, 80, 40);
        b1.addActionListener(this);
        l.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(450, 0, 80, 40);
        b2.addActionListener(this);
        l.add(b2);
    }

    public void actionPerformed (ActionEvent ae) {
        if (ae.getSource() == b1) {
            this.setVisible(false);
            new Paytm().setVisible(true);
        } else if (ae.getSource() == b2){
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Payment().setVisible(true);
    }
}
