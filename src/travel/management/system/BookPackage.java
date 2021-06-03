package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookPackage extends JFrame implements ActionListener {

    Choice c1;
    JLabel l11, l12, l13, l14, l15;
    JTextField t1;
    JButton b1, b2, b3;

    BookPackage (String username) {

        this.setBounds(300, 150, 1100, 500);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l16= new JLabel(i3);
        l16.setBounds(550, 50, 500, 300);
        this.add(l16);

        JLabel l1 = new JLabel("BOOK PACKAGE");
        l1.setFont(new Font("Yu Mincho", Font.BOLD, 20));
        l1.setBounds(100, 10, 200, 30);
        this.add(l1);

        JLabel l2 = new JLabel("Username: ");
        l2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l2.setBounds(40, 70, 100, 30);
        this.add(l2);

        l11 = new JLabel();
        l11.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l11.setBounds(250, 70, 250, 30);
        this.add(l11);

        JLabel l3 = new JLabel("Select Package: ");
        l3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l3.setBounds(40, 110, 150, 30);
        this.add(l3);

        c1 = new Choice();
        c1.add("Gold Package");
        c1.add("Silver Package");
        c1.add("Bronze Package");
        c1.setBounds(250, 110, 250, 30);
        this.add(c1);

        JLabel l4 = new JLabel("Total Persons: ");
        l4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l4.setBounds(40, 150, 150, 30);
        this.add(l4);

        t1 = new JTextField("1");
        t1.setBounds(250, 150, 200, 25);
        this.add(t1);

        JLabel l5 = new JLabel("ID: ");
        l5.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l5.setBounds(40, 190, 100, 30);
        this.add(l5);

        l12 = new JLabel();
        l12.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l12.setBounds(250, 190, 250, 30);
        this.add(l12);

        JLabel l6 = new JLabel("Number: ");
        l6.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l6.setBounds(40, 230, 100, 30);
        this.add(l6);

        l13 = new JLabel();
        l13.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l13.setBounds(250, 230, 250, 30);
        this.add(l13);

        JLabel l7 = new JLabel("Phone: ");
        l7.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l7.setBounds(40, 270, 100, 30);
        this.add(l7);

        l14 = new JLabel();
        l14.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l14.setBounds(250, 270, 250, 30);
        this.add(l14);

        JLabel l8 = new JLabel("Total Price: ");
        l8.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l8.setBounds(40, 310, 100, 30);
        this.add(l8);

        l15 = new JLabel();
        l15.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l15.setForeground(Color.RED);
        l15.setBounds(250, 310, 250, 30);
        this.add(l15);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM customer WHERE username = '"+username+"'");
            while (rs.next()) {
                l11.setText(rs.getString("username"));
                l12.setText(rs.getString("id"));
                l11.setText(rs.getString("number"));
                l11.setText(rs.getString("phone"));
            }

        } catch (SQLException e) {
            e.getMessage();
        }

        b1 = new JButton("Check Price");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(60, 380, 120, 25);
        b1.addActionListener(this);
        this.add(b1);

        b2 = new JButton("Book Package");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(200, 380, 120, 25);
        b2.addActionListener(this);
        this.add(b2);

        b3 = new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(340, 380, 120, 25);
        b3.addActionListener(this);
        this.add(b3);
    }

    public void actionPerformed (ActionEvent ae) {
        if (ae.getSource() == b1) {

            String p = c1.getSelectedItem();

            int price  = 0;

            if (p.equals("Gold Package")) {
                price += 12000;
            } else if (p.equals("Silver Package")) {
                price += 25000;
            } else if (p.equals("Bronze Package")) {
                price += 32000;
            }

            int persons = Integer.parseInt(t1.getText());
            price *= persons;

            l15.setText("Rs. " + price);

        } else if (ae.getSource() == b2) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("INSERT INTO bookPackage values ('"+l11.getText()+"', '"+c1.getSelectedItem()+"'," +
                        "'"+t1.getText()+"', '"+l12.getText()+"', '"+l13.getText()+"', '"+l14.getText()+"'," +
                        "'"+l15.getText()+"')");
                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                this.setVisible(false);

            } catch (SQLException e) {
                e.getMessage();
            }
        } else if (ae.getSource() == b3) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookPackage("Anonymous").setVisible(true);
    }
}
