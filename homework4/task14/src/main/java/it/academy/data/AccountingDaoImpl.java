package it.academy.data;

import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountingDaoImpl implements AccountingDao {

    private final Connection connection;


    public AccountingDaoImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(Accounting accounting) {

    }

    @Override
    public Accounting read(int paymentNumber) {
        Accounting accounting = new Accounting();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from expenses, contractors" +
                     "where payment_number = " + paymentNumber)) {
            accounting.setPaymentNumber(resultSet.getInt("payment_number"));
            accounting.setPaymentDate(resultSet.getDate("payment_date"));
            accounting.setRecipientId(resultSet.getInt("recipient_id"));
            accounting.setAmount(resultSet.getDouble("amount"));
            accounting.setEntityName(resultSet.getString("entity_name"));
            accounting.setRecipientId(resultSet.getInt("id"));
            accounting.setEntityName(resultSet.getString("entity_name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounting;
    }

    @Override
    public List<Accounting> readAll() {

        List<Accounting> accountings = new ArrayList<>();

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "select * from expenses, contractors where recipient_id = id; ")) {
            while (resultSet.next()) {
                Accounting accounting = new Accounting();
                accounting.setPaymentNumber(resultSet.getInt("payment_number"));
                accounting.setPaymentDate(resultSet.getDate("payment_date"));
                accounting.setRecipientId(resultSet.getInt("recipient_id"));
                accounting.setAmount(resultSet.getDouble("amount"));
                accounting.setEntityName(resultSet.getString("entity_name"));
                accounting.setRecipientId(resultSet.getInt("id"));
                accounting.setEntityName(resultSet.getString("entity_name"));
                accountings.add(accounting);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (accountings);

    }

    @Override
    public void addExpense(Accounting accounting) {


    }

    @Override
    public void addContractor(Accounting accounting) {

    }

    @Override
    public void update(Accounting accounting) {

    }

    @Override
    public void delete(Accounting accounting) {

    }

    @Override
    public void print(Accounting accounting, PrintWriter printWriter) {
        printWriter.println("Payment number " + accounting.getPaymentNumber()
                + ", payment date: " + accounting.getPaymentDate()
                + ", recipient ID: " + accounting.getRecipientId()
                + ", recipient: " + accounting.getEntityName()
                + ",\tamount of payment: " + accounting.getAmount());
    }


    @Override
    public void printAll(PrintWriter printWriter) {

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT " +
                             " payment_number," +
                             " payment_date," +
                             " id," +
                             " entity_name," +
                             " amount" +
                             " FROM" +
                             " expenses_accounting.expenses," +
                             " expenses_accounting.contractors" +
                             " WHERE recipient_id = contractors.id;")) {
            while (resultSet.next()) {
                printWriter.println("Payment number: " + resultSet.getInt("payment_number")
                        + ", payment date: " + resultSet.getDate("payment_date")
                        + ", recipient ID: " + resultSet.getInt("id")
                        + ", recipient: " + resultSet.getString("entity_name")
                        + ", \tamount of payment: " + resultSet.getDouble("amount")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void printRecipients(PrintWriter printWriter) {

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "select id, entity_name from contractors")) {
            while (resultSet.next()) {
                printWriter.println("Recipient ID: " + resultSet.getInt("id")
                        + ", recipient name: " + resultSet.getString("entity_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }


}
