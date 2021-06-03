package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ForgetPassword extends JFrame implements ActionListener {

    JTextField t1, t2, t3, t4,t5;
    JButton b1, b2, b3;

    ForgetPassword () {

        super("Forget Password");

        this.setBounds(350, 100, 850, 380);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l6 = new JLabel(i3);
        l6.setBounds(580, 70, 200, 200);
        this.add(l6);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBounds(30, 25, 500, 280);
        p.setBackground(new Color(133, 193, 233));
        this.add(p);

        JLabel l1 = new JLabel("Username");
        l1.setBounds(40, 20, 100, 25);
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        p.add(l1);

        t1 = new JTextField();
        t1.setBounds(200, 25, 160, 25);
        t1.setBorder(BorderFactory.createEmptyBorder());
        p.add(t1);

        b1 = new JButton("Search");
        b1.setBounds(380, 25, 100, 25);
        b1.setBackground(Color.DARK_GRAY);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        p.add(b1);

        JLabel l2 = new JLabel("Name");
        l2.setBounds(40, 60, 100, 25);
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        p.add(l2);

        t2 = new JTextField();
        t2.setBounds(200, 65, 160, 25);
        t2.setBorder(BorderFactory.createEmptyBorder());
        p.add(t2);

        JLabel l3 = new JLabel("Security Question:");
        l3.setBounds(40, 100, 170, 25);
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        p.add(l3);

        t3 = new JTextField();
        t3.setBounds(200, 105, 280, 25);
        t3.setBorder(BorderFactory.createEmptyBorder());
        p.add(t3);

        JLabel l4 = new JLabel("Answer:");
        l4.setBounds(40, 140, 210, 25);
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        p.add(l4);

        t4 = new JTextField();
        t4.setBounds(200, 150, 160, 25);
        t4.setBorder(BorderFactory.createEmptyBorder());
        p.add(t4);

        b2 = new JButton("Retrieve");
        b2.setBounds(380, 150, 100, 25);
        b2.setBackground(Color.DARK_GRAY);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        p.add(b2);

        JLabel l5 = new JLabel("Password");
        l5.setBounds(40, 180, 210, 25);
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        p.add(l5);

        t5 = new JTextField();
        t5.setBounds(200, 195, 160, 25);
        t5.setBorder(BorderFactory.createEmptyBorder());
        p.add(t5);

        b3 = new JButton("Back");
        b3.setBounds(150, 250, 100, 25);
        b3.setBackground(Color.DARK_GRAY);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        p.add(b3);
    }

    public void actionPerformed (ActionEvent ae) {

        Conn c = new Conn();

        if (ae.getSource() == b1) {
            try {
                String sql = "SELECT * FROM account WHERE username = '"+t1.getText()+"'";
                ResultSet rs = c.s.executeQuery(sql);
                while (rs.next()) {
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("security"));
                }

            } catch (SQLException e) {
                System.out.println("Something Went Wrong: " + e.getMessage());
            }
        } else if (ae.getSource() == b2) {
            try {
                String sql = "SELECT * FROM account WHERE answer = '"+t4.getText()+"' AND username = '" + t1.getText() + "'";
                ResultSet rs = c.s.executeQuery(sql);
                while (rs.next()) {
                    t5.setText(rs.getString("password"));
                }

            } catch (SQLException e) {
                System.out.println("Something Went Wrong: " + e.getMessage());
            }
        } else if (ae.getSource() == b3) {
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new ForgetPassword().setVisible(true);
    }
}
