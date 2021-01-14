package it.academy.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

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
        Properties connectionProperties = new Properties();
        connectionProperties.put("user", user);
        connectionProperties.put("password", password);
        connectionProperties.put("charSet", "utf8");
        Connection  connection = DriverManager.getConnection(url, connectionProperties);

        return new AccountingDaoImpl(connection);
    }

}
