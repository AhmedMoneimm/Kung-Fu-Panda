package Controller;

import java.sql.*;

public class SingletonConnection {

    private static java.sql.Connection connection;

    static {
        String url = "jdbc:mysql://localhost:3306/final";
        String username = "root";
        String password = "1234";
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            //create connection
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("connected");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());

        }
    }

    public static Connection getCon() {
        return (Connection) connection;
    }
}
