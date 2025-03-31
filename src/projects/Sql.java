package projects;

import  java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Sql {
    private  final  String host = "localhost";
    private  final  String port = "5432";
    private final  String  dbName = "231";
    private final  String login = "postgres";
    private final String password = "bg71007BO";

    private Connection dbCon;  //подключение дб

    private Connection getDBConnection() throws ClassNotFoundException, SQLException {
            String str = "jdbc:postgresql://" + host + ":" + port + "/" + dbName;
            Class.forName("org.postgresql.Driver");
            dbCon = DriverManager.getConnection(str, login, password);
        return dbCon;
    }

    public  void isConnection() throws SQLException, ClassNotFoundException {
        dbCon = getDBConnection();
        System.out.println(dbCon.isValid(1000));
    }

    public void createTable(String tableName) throws SQLException, ClassNotFoundException {
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (id INT PRIMARY KEY, zacaz_name VARCHAR(50), cymma INT)";
        Statement statment = getDBConnection().createStatement();
        statment.executeUpdate(sql);
    }
    public void addTable(String table, int id, String zacaz_name, int cymma) throws ClassNotFoundException {
    try {
        Statement statement = getDBConnection().createStatement();
        int rows = statement.executeUpdate("INSERT INTO " + table +
                " (id, zacaz_name, cymma)" +
               " VALUES (" + id + ", '" + zacaz_name + "', '" + cymma + "');" );
        System.out.println("Добавлена строчка " + rows);
    } catch (SQLException e) {
        System.out.println("Ошибка");
    }
    }

    public void selecteTable1(String table) throws SQLException, ClassNotFoundException{
        try {
            Statement statement = getDBConnection().createStatement();
            ResultSet resultatSet = statement.executeQuery("SELECT * FROM " + table);
            while (resultatSet.next()) {
                int id = resultatSet.getInt(1);
                String zacaz_name = resultatSet.getString(2);
                int cymma = resultatSet.getInt(3);
                System.out.printf("%d. %s. %s \n", id, zacaz_name, cymma);
            }
        } catch (SQLException e) {
            System.out.println("ошибка");
        }
    }
    public void selectTable() throws SQLException, ClassNotFoundException{
        Statement statement = getDBConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM sql WHERE cymma > 50000");
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String zacaz_name = resultSet.getString(2);
            int cymma = resultSet.getInt(3);
            System.out.printf("%d. %s. %s \n", id, zacaz_name, cymma);
        }
    }
}