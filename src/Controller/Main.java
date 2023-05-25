package Controller;

import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Main {

    public void ViewPlayers(JTable jTable1) {

        try {

            Connection connection = (Connection) SingletonConnection.getCon();
            Statement st = connection.createStatement();
            String sql = "select * from players order by score desc";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String name = rs.getString("name");
                String score = String.valueOf(rs.getDouble("score"));
                String level = rs.getString("level");

                String tbData[] = {name, score, level};
                DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
                tblModel.addRow(tbData);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void HighScore(JTable jTable1) {
        try {

            Connection connection = (Connection) SingletonConnection.getCon();
            Statement st = connection.createStatement();
            String sql = "select * from players where score=(select MAX(score) from players)";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String name = rs.getString("name");
                String score = String.valueOf(rs.getDouble("score"));
                String level = rs.getString("level");

                String tbData[] = {name, score, level};
                DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
                tblModel.addRow(tbData);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void addItemInDB(String name, int score, String level) {

        try {
            Connection connection = (Connection) SingletonConnection.getCon();
            String sql = "INSERT INTO `players` ( `name`, `score`,`level`) VALUES (?, ?, ?);";
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, name);
            p.setDouble(2, score);
            p.setString(3, level);
            p.execute();
            System.out.println("added successfuly");
            //CTDB.close();
        } catch (Exception e) {
            System.out.println("Error while adding");
            e.printStackTrace();

        }
    }
}
