package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookHotel extends JFrame implements ActionListener {

    Choice c1, c2, c3;
    JTextField t1, t2;
    JLabel l21, l81, l91, l101, l111;
    JButton b1, b2, b3;

    BookHotel (String username) {

        this.setBounds(300, 150, 1100, 600);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(null);

        JLabel l1 = new JLabel("BOOK HOTEL");
        l1.setFont(new Font("Tahoma", Font.BOLD, 24));
        l1.setBounds(100, 0, 300, 30);
        this.add(l1);

        JLabel l2 = new JLabel("Username: ");
        l2.setBounds(20, 70, 100, 30);
        this.add(l2);

        l21 = new JLabel();
        l21.setBounds(250, 70, 150, 30);
        this.add(l21);

        JLabel l3 = new JLabel("Select Hotel: ");
        l3.setBounds(20, 110, 100, 30);
        this.add(l3);

        c1 = new Choice();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM hotels");
            while (rs.next())  {
                c1.add(rs.getString("name"));
            }

        } catch (SQLException e)  {
            e.getMessage();
        }
        c1.setBounds(250, 110, 185, 30);
        this.add(c1);

        JLabel l4 = new JLabel("Select Persons: ");
        l4.setBounds(20, 150, 100, 30);
        this.add(l4);

        t1 = new JTextField();
        t1.setBounds(250, 150, 150, 25);
        this.add(t1);

        JLabel l5 = new JLabel("No. of Days: ");
        l5.setBounds(20, 190, 100, 30);
        this.add(l5);

        t2 = new JTextField("1");
        t2.setBounds(250, 190, 150, 25);
        this.add(t2);

        JLabel l6 = new JLabel("AC / Non-AC: ");
        l6.setBounds(20, 230, 100, 30);
        this.add(l6);

        c2 = new Choice();
        c2.add("Yes");
        c2.add("No");
        c2.setBounds(250, 230, 190, 30);
        this.add(c2);

        JLabel l7 = new JLabel("Food Included: ");
        l7.setBounds(20, 270, 100, 30);
        this.add(l7);

        c3 = new Choice();
        c3.add("Yes");
        c3.add("No");
        c3.setBounds(250, 270, 190, 30);
        this.add(c3);

        JLabel l8 = new JLabel("ID: ");
        l8.setBounds(20, 310, 100, 30);
        this.add(l8);

        l81 = new JLabel();
        l81.setBounds(250, 310, 150, 30);
        this.add(l81);

        JLabel l9 = new JLabel("Number: ");
        l9.setBounds(20, 350, 100, 30);
        this.add(l9);

        l91 = new JLabel();
        l91.setBounds(250, 350, 150, 30);
        this.add(l91);

        JLabel l10 = new JLabel("Phone: ");
        l10.setBounds(20, 390, 100, 30);
        this.add(l10);

        l101 = new JLabel();
        l101.setBounds(250, 390, 150, 30);
        this.add(l101);

        JLabel l11 = new JLabel("Total Price: ");
        l11.setBounds(20, 430, 100, 30);
        this.add(l11);

        l111 = new JLabel();
        l111.setForeground(Color.RED);
        l111.setBounds(250, 430, 170, 30);
        this.add(l111);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM customer WHERE username = '"+username+"'");
            while (rs.next())  {
                l21.setText(rs.getString("username"));
                l81.setText(rs.getString("id"));
                l91.setText(rs.getString("number"));
                l101.setText(rs.getString("phone"));
            }

        } catch (SQLException e) {
            e.getMessage();
        }

        b1 = new JButton("Check Price");
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.setBounds(50, 490, 120, 30);
        b1.addActionListener(this);
        this.add(b1);

        b2 = new JButton("Book Price");
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        b2.setBounds(200, 490, 120, 30);
        b2.addActionListener(this);
        this.add(b2);

        b3 = new JButton("Back");
        b3.setBackground(Color.BLUE);
        b3.setForeground(Color.WHITE);
        b3.setBounds(350, 490, 120, 30);
        b3.addActionListener(this);
        this.add(b3);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(500, 50, 600, 400);
        this.add(l12);
    }

    public void actionPerformed (ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("SELECT * FROM hotels WHERE name = '"+c1.getSelectedItem()+"'");
                while (rs.next()) {
                    int cost = Integer.parseInt(rs.getString("cost_per_day"));
                    int food = Integer.parseInt(rs.getString("food_charges"));
                    int ac = Integer.parseInt(rs.getString("ac_charges"));

                    int persons = Integer.parseInt(t1.getText());
                    int days = Integer.parseInt(t2.getText());

                    String acPrice = c2.getSelectedItem();
                    String foodPrice = c3.getSelectedItem();

                    if (persons * days > 0) {
                        int total = 0;
                        total += acPrice.equals("Yes") ? ac : 0;
                        total += foodPrice.equals("Yes") ? food : 0;
                        total += cost;
                        total = total * persons * days;
                        l111.setText("Rs. " + ""+total);
                    } else {
                        l111.setText("Please Enter a Valid Number");
                    }
                }

            } catch (SQLException e) {
                e.getMessage();
            }
        }
        else if (ae.getSource() == b2) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("INSERT INTO bookHotel VALUES ('"+l21.getText()+"', '"+c1.getSelectedItem()+"'," +
                        "'"+t1.getText()+"', '"+t2.getText()+"', '"+c2.getSelectedItem()+"', '"+c3.getSelectedItem()+"'," +
                        "'"+l81.getText()+"', '"+l91.getText()+"', '"+l101.getText()+"', '"+l111.getText()+"')");

                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");

                this.setVisible(false);

            } catch (SQLException e) {
                e.getMessage();
            }
        }
        else  if (ae.getSource() == b3) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookHotel("Anonymous").setVisible(true);
    }
}
