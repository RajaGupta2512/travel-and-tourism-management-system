package travel.management.system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Paytm extends JFrame implements ActionListener {

    JButton b1;

    Paytm () {

        this.setBounds(350, 150, 800, 600);

        JEditorPane j = new JEditorPane();
        j.setEditable(false);
        try {
            j.setPage("https://paytm.com");

        } catch (Exception e) {
            j.setContentType("text/html");
            j.setText("<html>Could not Load, ERROR 404</html>");
        }

        JScrollPane js = new JScrollPane(j);
        this.getContentPane().add(js);

        b1 = new JButton("Back");
        b1.setBounds(610, 20, 80, 40);
        b1.addActionListener(this);
        j.add(b1);
    }

    public void actionPerformed (ActionEvent ae) {
        this.setVisible(false);
        new Payment().setVisible(true);
    }

    public static void main(String[] args) {
        new Paytm().setVisible(true);
    }
}
