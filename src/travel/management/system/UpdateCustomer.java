package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateCustomer extends JFrame implements ActionListener {

    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9;
    JComboBox c1;
    JRadioButton r1, r2;
    JButton b1, b2;

    UpdateCustomer (String username) {

        this.setBounds(350, 150, 850, 550);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(null);

        JLabel heading = new JLabel("UPDATE CUSTOMER DETAILS");
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        heading.setBounds(50, 0, 300, 25);
        this.add(heading);

        JLabel l1 = new JLabel("Username : ");
        l1.setBounds(30, 50, 150, 25);
        this.add(l1);

        t1 = new JTextField();
        t1.setBounds(180, 50, 200, 25);
        this.add(t1);

        JLabel l2 = new JLabel("ID : ");
        l2.setBounds(30, 90, 150, 25);
        this.add(l2);

        t8 = new JTextField();
        t8.setBounds(180, 90, 200, 25);
        this.add(t8);

        JLabel l3 = new JLabel("ID Number : ");
        l3.setBounds(30, 130, 150, 25);
        this.add(l3);

        t2 = new JTextField();
        t2.setBounds(180, 130, 200, 25);
        this.add(t2);

        JLabel l4 = new JLabel("Name : ");
        l4.setBounds(30, 170, 150, 25);
        this.add(l4);

        t3 = new JTextField();
        t3.setBounds(180, 170, 200, 25);
        this.add(t3);

        JLabel l5 = new JLabel("Gender : ");
        l5.setBounds(30, 210, 150, 25);
        this.add(l5);

        t9 = new JTextField();
        t9.setBackground(Color.WHITE);
        t9.setBounds(180, 210, 200, 25);
        this.add(t9);

        JLabel l6 = new JLabel("Country : ");
        l6.setBounds(30, 250, 150, 25);
        this.add(l6);

        t4 = new JTextField();
        t4.setBounds(180, 250, 200, 25);
        this.add(t4);

        JLabel l7 = new JLabel("Address : ");
        l7.setBounds(30, 290, 150, 25);
        this.add(l7);

        t5 = new JTextField();
        t5.setBounds(180, 290, 200, 25);
        this.add(t5);

        JLabel l8 = new JLabel("Phone : ");
        l8.setBounds(30, 330, 150, 25);
        this.add(l8);

        t6 = new JTextField();
        t6.setBounds(180, 330, 200, 25);
        this.add(t6);

        JLabel l9 = new JLabel("E-Mail : ");
        l9.setBounds(30, 370, 150, 25);
        this.add(l9);

        t7 = new JTextField();
        t7.setBounds(180, 370, 200, 25);
        this.add(t7);

        b1 = new JButton("Update");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(70, 430, 100, 25);
        b1.addActionListener(this);
        this.add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(220, 430, 100, 25);
        b2.addActionListener(this);
        this.add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l10 = new JLabel(i3);
        l10.setBounds(400, 40, 400, 400);
        this.add(l10);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM account WHERE username = '"+username+"'");
            while (rs.next()) {
                t1.setText(rs.getString("username"));
                t2.setText(rs.getString("id"));
                t3.setText(rs.getString("number"));
                t4.setText(rs.getString("name"));
                t5.setText(rs.getString("gender"));
                t6.setText(rs.getString("country"));
                t7.setText(rs.getString("address"));
                t7.setText(rs.getString("phone"));
                t9.setText(rs.getString("email"));
            }

        } catch (SQLException e) {
            System.out.println("Something Went Wrong: " + e.getMessage());
        }
    }

    public void actionPerformed (ActionEvent ae) {

        String username = t1.getText();
        String id = t2.getText();
        String number = t3.getText();
        String name = t4.getText();
        String gender = t5.getText();
        String country = t6.getText();
        String address = t7.getText();
        String phone = t8.getText();
        String email = t9.getText();

        if (ae.getSource() == b1) {

            String q = "UPDATE customer set username = '"+username+"', id = '"+id+"', number = '"+number+"'," +
                    "name = '"+name+"', gender = '"+gender+"', country = '"+country+"', address = '"+address+"'," +
                    "phone = '"+phone+"', email = '"+email+"')";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(q);

                JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
                this.setVisible(false);

            } catch (SQLException e) {
                System.out.println("Something Went Wrong: " + e.getMessage());
            }

        } else if (ae.getSource() == b2) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateCustomer("Anonymous").setVisible(true);
    }
}
