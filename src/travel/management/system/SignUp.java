package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SignUp extends JFrame implements ActionListener {

    JButton b1, b2;
    JTextField t1, t2, t4;
    JPasswordField t3;
    Choice c1;

    SignUp () {

        super("Sign Up");

        this.setBounds(350, 100, 900, 360);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133, 193, 233));
        p1.setBounds(0, 0, 500, 400);
        p1.setLayout(null);

        this.add(p1);

        JLabel l1 = new JLabel("Username");
        l1.setBounds(50, 20, 100, 25);
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(l1);

        t1 = new JTextField();
        t1.setBounds(190, 20, 200, 25);
        t1.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t1);

        JLabel l2 = new JLabel("Name");
        l2.setBounds(50, 60, 100, 25);
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(l2);

        t2 = new JTextField();
        t2.setBounds(190, 60, 200, 25);
        t2.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t2);

        JLabel l3 = new JLabel("Password");
        l3.setBounds(50, 100, 100, 25);
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(l3);

        t3 = new JPasswordField();
        t3.setBounds(190, 100, 200, 25);
        t3.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t3);

        JLabel l4 = new JLabel("Security Question:");
        l4.setBounds(50, 140, 135, 25);
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(l4);

        c1 = new Choice();
        c1.add("What was your childhood nickname?");
        c1.add("What primary school did you attend?");
        c1.add("What school did you attend for sixth grade?");
        c1.add("What are the last five digits of your driver's license number?");
        c1.add("What time of the day were you born? (hh:mm)");
        c1.setBounds(190, 140, 250, 25);
        p1.add(c1);

        JLabel l5 = new JLabel("Answer:");
        l5.setBounds(50, 180, 100, 25);
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(l5);

        t4 = new JTextField();
        t4.setBounds(190, 180, 200, 25);
        t4.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t4);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l6 = new JLabel(i3);
        l6.setBounds(580, 30, 250, 250);
        this.add(l6);

        b1 = new JButton("Create");
        b1.setBounds(80, 250, 100, 30);
        b1.setFont(new Font("Tahoma", Font.BOLD, 14));
        b1.addActionListener(this);
        p1.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(290, 250, 100, 30);
        b2.setFont(new Font("Tahoma", Font.BOLD, 14));
        b2.addActionListener(this);
        p1.add(b2);
    }

    public void actionPerformed (ActionEvent ae) {

        if (ae.getSource() == b1) {
            String username = t1.getText();
            String name = t2.getText();
            String password = t3.getText();
            String security = c1.getSelectedItem();
            String answer = t4.getText();

            String query = "INSERT INTO account values ('"+username+"', '"+name+"', '"+password+"', '"+security+"', '"+answer+"')";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                this.setVisible(false);
                new Login().setVisible(true);

            } catch (SQLException e) {
                System.out.println("Something Went Wrong: " + e.getMessage());
            }

        } else if (ae.getSource() == b2) {
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new SignUp().setVisible(true);
    }
}
