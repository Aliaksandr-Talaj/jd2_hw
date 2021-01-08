package it.academy.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {



    public DaoFactory(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver loading error");
            e.printStackTrace();
        }
    }

    public AccountingDao getAccountingDao(String url, String user, String password)throws SQLException {
        Connection  connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/expenses_accounting?serverTimezone=UTC",
                "root",
                "root");
        return new AccountingDaoImpl(connection);
    }

}
