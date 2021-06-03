package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {

    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15;
    String username;

    Dashboard (String username) {

        this.username = username;

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0, 1950, 60);
        p1.setBackground(new Color(0, 0, 102));
        this.add(p1);

        JLabel l3 = new JLabel("Dashboard");
        l3.setBounds(40, 10, 300, 40);
        l3.setFont(new Font("Tahoma", Font.BOLD, 30));
        l3.setForeground(Color.WHITE);
        p1.add(l3);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(0, 60, 230, 1000);
        p2.setBackground(new Color(0, 0, 102));
        this.add(p2);

        b1 = new JButton("Add Personal Details");
        b1.setBackground(new Color(0, 0, 102));
        b1.setForeground(Color.WHITE);
        b1.setMargin(new Insets(0, 0, 0, 150));
        b1.setBounds(0, 0, 300, 50);
        b1.addActionListener(this);
        p2.add(b1);

        b2 = new JButton("Update Personal Details");
        b2.setBackground(new Color(0, 0, 102));
        b2.setForeground(Color.WHITE);
        b2.setMargin(new Insets(0, 0, 0, 140));
        b2.setBounds(0, 50, 300, 50);
        b2.addActionListener(this);
        p2.add(b2);

        b3 = new JButton("View Details");
        b3.setBackground(new Color(0, 0, 102));
        b3.setForeground(Color.WHITE);
        b3.setMargin(new Insets(0, 0, 0, 205));
        b3.setBounds(0, 100, 300, 50);
        b3.addActionListener(this);
        p2.add(b3);

        b4 = new JButton("Delete Personal Details");
        b4.setBackground(new Color(0, 0, 102));
        b4.setForeground(Color.WHITE);
        b4.setMargin(new Insets(0, 0, 0, 140));
        b4.setBounds(0, 150, 300, 50);
        b4.addActionListener(this);
        p2.add(b4);

        b5 = new JButton("Check Package");
        b5.setBackground(new Color(0, 0, 102));
        b5.setForeground(Color.WHITE);
        b5.setMargin(new Insets(0, 0, 0, 190));
        b5.setBounds(0, 200, 300, 50);
        b5.addActionListener(this);
        p2.add(b5);

        b6 = new JButton("Book Package");
        b6.setBackground(new Color(0, 0, 102));
        b6.setForeground(Color.WHITE);
        b6.setMargin(new Insets(0, 0, 0, 195));
        b6.setBounds(0, 250, 300, 50);
        b6.addActionListener(this);
        p2.add(b6);

        b7 = new JButton("View Package");
        b7.setBackground(new Color(0, 0, 102));
        b7.setForeground(Color.WHITE);
        b7.setMargin(new Insets(0, 0, 0, 195));
        b7.setBounds(0, 300, 300, 50);
        b7.addActionListener(this);
        p2.add(b7);

        b8 = new JButton("Check Hotels");
        b8.setBackground(new Color(0, 0, 102));
        b8.setForeground(Color.WHITE);
        b8.setMargin(new Insets(0, 0, 0, 200));
        b8.setBounds(0, 350, 300, 50);
        b8.addActionListener(this);
        p2.add(b8);

        b9 = new JButton("Book Hotel");
        b9.setBackground(new Color(0, 0, 102));
        b9.setForeground(Color.WHITE);
        b9.setMargin(new Insets(0, 0, 0, 210));
        b9.setBounds(0, 400, 300, 50);
        b9.addActionListener(this);
        p2.add(b9);

        b10 = new JButton("View Booked Hotel");
        b10.setBackground(new Color(0, 0, 102));
        b10.setForeground(Color.WHITE);
        b10.setMargin(new Insets(0, 0, 0, 170));
        b10.setBounds(0, 450, 300, 50);
        b10.addActionListener(this);
        p2.add(b10);

        b11 = new JButton("Destinations");
        b11.setBackground(new Color(0, 0, 102));
        b11.setForeground(Color.WHITE);
        b11.setMargin(new Insets(0, 0, 0, 200));
        b11.setBounds(0, 500, 300, 50);
        b11.addActionListener(this);
        p2.add(b11);

        b12 = new JButton("Payment");
        b12.setBackground(new Color(0, 0, 102));
        b12.setForeground(Color.WHITE);
        b12.setMargin(new Insets(0, 0, 0, 220));
        b12.setBounds(0, 550, 300, 50);
        b12.addActionListener(this);
        p2.add(b12);

        b13 = new JButton("Calculator");
        b13.setBackground(new Color(0, 0, 102));
        b13.setForeground(Color.WHITE);
        b13.setMargin(new Insets(0, 0, 0, 210));
        b13.setBounds(0, 600, 300, 50);
        b13.addActionListener(this);
        p2.add(b13);

        b14 = new JButton("Notepad");
        b14.setBackground(new Color(0, 0, 102));
        b14.setForeground(Color.WHITE);
        b14.setMargin(new Insets(0, 0, 0, 215));
        b14.setBounds(0, 650, 300, 50);
        b14.addActionListener(this);
        p2.add(b14);

        b15 = new JButton("About");
        b15.setBackground(new Color(0, 0, 102));
        b15.setForeground(Color.WHITE);
        b15.setMargin(new Insets(0, 0, 0, 225));
        b15.setBounds(0, 700, 300, 50);
        b15.addActionListener(this);
        p2.add(b15);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 0, 1950, 1000);
        this.add(l1);

        JLabel l4 = new JLabel("Travel and Tourism Management");
        l4.setBounds(500, 60, 1000, 70);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Tahoma", Font.PLAIN, 55));
        l1.add(l4);
    }

    public void actionPerformed (ActionEvent ae) {
        if (ae.getSource() == b1) {
            new AddCustomer(username).setVisible(true);
        }
        else  if (ae.getSource() == b2) {
            new UpdateCustomer(username).setVisible(true);
        }
        else  if (ae.getSource() == b3) {
            new ViewCustomer(username).setVisible(true);
        }
        else  if (ae.getSource() == b4) {
            new DeleteCustomer(username).setVisible(true);
        }
        else  if (ae.getSource() == b5) {
            new CheckPackage().setVisible(true);
        }
        else  if (ae.getSource() == b6) {
            new BookPackage(username).setVisible(true);
        }
        else  if (ae.getSource() == b7) {
            new ViewPackage(username).setVisible(true);
        }
        else  if (ae.getSource() == b8) {
            new CheckHotels().setVisible(true);
        }
        else  if (ae.getSource() == b9) {
            new BookHotel(username).setVisible(true);
        }
        else  if (ae.getSource() == b10) {
            new ViewBookedHotel(username).setVisible(true);
        }
        else  if (ae.getSource() == b11) {
            new Destinations().setVisible(true);
        }
        else  if (ae.getSource() == b12) {
            new Payment().setVisible(true);
        }
        else  if (ae.getSource() == b13) {
            try {
               Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.getMessage();
            }
        }
        else  if (ae.getSource() == b14) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.getMessage();
            }
        }
        else  if (ae.getSource() == b15) {
            new About().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Dashboard("Anonymous").setVisible(true);
    }
}
