package travel.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {

    Connection c;
    Statement s;

    public Conn () {
        try {
            c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Raja Gupta\\IdeaProjects\\" +
                    "Travel Management System\\src\\travel\\management\\system\\tms.db");
            s = c.createStatement();

        } catch (SQLException e) {
            System.out.println("Something Went Wrong: " + e.getMessage());
        }
    }
}
