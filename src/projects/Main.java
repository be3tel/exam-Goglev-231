package projects;

import java.sql.SQLException;
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Sql db = new Sql();
        db.isConnection();
//        db.createTable("Sql");
//        db.addTable("Sql", 1, "bobr", 10000);
//        db.addTable("Sql", 2, "bobr", 2890);
//        db.addTable("Sql", 3, "bobr", 50001);
//        db.addTable("Sql", 4, "bobr", 1222);
//        db.addTable("Sql", 5, "bobr", 500000);
//        db.addTable("Sql", 6, "bobr", 10000);
//        db.addTable("Sql", 7, "bobr", 3987);
//        db.addTable("Sql", 8, "bobr", 34567);
//        db.addTable("Sql", 9, "bobr", 100000);
     //  db.addTable("Sql", 10, "bobr", 23456)
        db.selectTable();
        db.selecteTable1("sql");
    }
}
