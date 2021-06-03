package travel.management.system;

import javax.imageio.spi.ImageWriterSpi;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteCustomer extends JFrame implements ActionListener {

    JButton b1, b2;
    String username;

    DeleteCustomer (String user) {

        this.username = user;

        this.setBounds(350, 150, 850, 550);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(null);

        JLabel heading = new JLabel("DELETE CUSTOMER DETAILS");
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        heading.setForeground(Color.RED);
        heading.setBounds(110, 10, 300, 30);
        this.add(heading);

        JLabel l1 = new JLabel("Username: ");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l1.setBounds(30, 70, 200, 16);
        this.add(l1);

        JLabel l11 = new JLabel();
        l11.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l11.setBounds(250, 70, 200, 16);
        this.add(l11);

        JLabel l2 = new JLabel("Name: ");
        l2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l2.setBounds(30, 110, 200, 16);
        this.add(l2);

        JLabel l12 = new JLabel();
        l12.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l12.setBounds(250, 110, 200, 16);
        this.add(l12);

        JLabel l3 = new JLabel("ID: ");
        l3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l3.setBounds(30, 150, 200, 16);
        this.add(l3);

        JLabel l13 = new JLabel();
        l13.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l13.setBounds(250, 150, 200, 16);
        this.add(l13);

        JLabel l4 = new JLabel("Number: ");
        l4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l4.setBounds(30, 190, 200, 16);
        this.add(l4);

        JLabel l14 = new JLabel();
        l14.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l14.setBounds(250, 190, 200, 16);
        this.add(l14);

        JLabel l5 = new JLabel("Gender: ");
        l5.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l5.setBounds(30, 230, 200, 16);
        this.add(l5);

        JLabel l15 = new JLabel();
        l15.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l15.setBounds(250, 230, 200, 16);
        this.add(l15);

        JLabel l6 = new JLabel("Country: ");
        l6.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l6.setBounds(30, 270, 200, 16);
        this.add(l6);

        JLabel l16 = new JLabel();
        l16.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l16.setBounds(250, 270, 200, 16);
        this.add(l16);

        JLabel l7 = new JLabel("Address: ");
        l7.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l7.setBounds(30, 310, 200, 16);
        this.add(l7);

        JLabel l17 = new JLabel();
        l17.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l17.setBounds(250, 310, 200, 16);
        this.add(l17);

        JLabel l8 = new JLabel("Phone: ");
        l8.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l8.setBounds(30, 350, 200, 16);
        this.add(l8);

        JLabel l18 = new JLabel();
        l18.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l18.setBounds(250, 350, 200, 16);
        this.add(l18);

        JLabel l9 = new JLabel("E-Mail: ");
        l9.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l9.setBounds(30, 390, 200, 16);
        this.add(l9);

        JLabel l19 = new JLabel();
        l19.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l19.setBounds(250, 390, 200, 16);
        this.add(l19);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM customer WHERE username = '"+username+"'");
            while (rs.next()) {
                l11.setText(rs.getString("username"));
                l12.setText(rs.getString("name"));
                l13.setText(rs.getString("id"));
                l14.setText(rs.getString("number"));
                l15.setText(rs.getString("gender"));
                l16.setText(rs.getString("country"));
                l17.setText(rs.getString("address"));
                l18.setText(rs.getString("phone"));
                l19.setText(rs.getString("email"));
            }

        } catch (SQLException e) {
            e.getMessage();
        }

        b1 = new JButton("Delete");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(80, 450, 120, 25);
        b1.addActionListener(this);
        this.add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(250, 450, 120, 25);
        b2.addActionListener(this);
        this.add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l = new JLabel(i3);
        l.setBounds(500, 100, 300, 300);
        this.add(l);
    }

    public void actionPerformed (ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("DELETE FROM account WHERE username = '"+username+"'");
                c.s.executeUpdate("DELETE FROM bookHotel WHERE username = '"+username+"'");
                c.s.executeUpdate("DELETE FROM bookPackage WHERE username = '"+username+"'");
                c.s.executeUpdate("DELETE FROM cutomer WHERE username = '"+username+"'");

                JOptionPane.showMessageDialog(null, "Customer Details Deleted Successfully");

                System.exit(0);

            } catch (SQLException e) {
                e.getMessage();
            }
        } else if (ae.getSource() == b2) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new DeleteCustomer("Anonymous").setVisible(true);
    }
}
