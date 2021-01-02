package it.academy;

import java.sql.*;

public class AccountingDaoImpl implements AccountingDao {

    private final Connection connection;


    public AccountingDaoImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(Accounting accounting) {

    }

    @Override
    public void addExpense(Accounting accounting) {
        try (Statement statement = connection.createStatement(); ResultSet resultSet2 = statement.executeQuery(
                "select id from  contractors")) {
            int counter = 0;
            while (resultSet2.next()) {
                if (resultSet2.getInt("id") == accounting.getRecipientId()) {
                    System.out.println("Table \"expenses\" already has such payment number! ");
                    counter++;

                }
            }
            if (counter == 0) {
                System.out.println("Table \"contractors\" has no such recipient ID! ");
                printRecipients();
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO expenses_accounting.expenses VALUES (?, ?, ?, ?)");
                Statement statement = connection.createStatement();
             ResultSet resultSet1 = statement.executeQuery(
                     "select payment_number from expenses")
        ) {
            while (resultSet1.next()) {
                if (resultSet1.getInt("payment_number") == accounting.getPaymentNumber()) {
                    System.out.println("Table \"expenses\" already has such payment number! ");
                    return;
                }
            }
            preparedStatement.setInt(1,accounting.getPaymentNumber());
            preparedStatement.setDate(2,accounting.getPaymentDate());
            preparedStatement.setInt(3,accounting.getRecipientId());
            preparedStatement.setDouble(4, accounting.getAmount());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addContractor(Accounting accounting) {

        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO expenses_accounting.contractors VALUES (?, ?)");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "select id from contractors")) {
            while (resultSet.next()) {
                if (resultSet.getInt("id") == accounting.getRecipientId()) {
                    System.out.println("Table \"contractors\" already has such recipient ID! ");
                    printRecipients();
                    return;
                }
            }
            preparedStatement.setInt(1, accounting.getRecipientId());
            preparedStatement.setString(2, accounting.getEntityName());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void update(Accounting accounting) {

    }

    @Override
    public void delete(Accounting accounting) {

    }

    @Override
    public void print(Accounting accounting) {
        System.out.println("Payment number " + accounting.getPaymentNumber()
                + ", payment date: " + accounting.getPaymentDate()
                + ", recipient ID: " + accounting.getRecipientId()
                + ", recipient: " + accounting.getEntityName()
                + ",\tamount of payment: " + accounting.getAmount());
    }

    @Override
    public void printAll() {

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
                System.out.println("Payment number: " + resultSet.getInt("payment_number")
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
    public void printRecipients() {

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "select id, entity_name from contractors")) {
            while (resultSet.next()) {
                System.out.println("Recipient ID: " + resultSet.getInt("id")
                        + ", recipient name: " + resultSet.getString("entity_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    public Accounting parseContractor(String newContractor) {
        Accounting accounting = new Accounting();
        String[] parts = newContractor.split("( +\")|(\" *)");
        if (parts.length == 2) {
            accounting.setRecipientId(Integer.parseInt(parts[0]));
            accounting.setEntityName(parts[1]);
            return accounting;
        } else {
            System.err.println("Contractor parsing error!");
            return null;
        }
    }

    @Override
    public Accounting parseContractor(String[] parts) {
        Accounting accounting = new Accounting();
        if (parts.length == 2) {
            accounting.setRecipientId(Integer.parseInt(parts[0]));
            accounting.setEntityName(parts[1]);
            return accounting;
        } else {
            System.err.println("Contactors parsing error! ");
            return null;
        }
    }

    @Override
    public Accounting parseExpense(String newExpense) {
        Accounting accounting = new Accounting();
        String[] parts = newExpense.split(" +");
        if (parts.length == 4) {
            accounting.setPaymentNumber(Integer.parseInt(parts[0]));
            accounting.setPaymentDate(Date.valueOf(parts[1]));
            accounting.setRecipientId(Integer.parseInt(parts[2]));
            accounting.setAmount(Double.parseDouble(parts[3]));
            return accounting;
        } else {
            System.err.println("Expense parsing error!");
            return null;
        }
    }

    @Override
    public Accounting parseExpense(String[] parts) {
        Accounting accounting = new Accounting();
        if (parts.length == 4) {
            accounting.setPaymentNumber(Integer.parseInt(parts[0]));
            accounting.setPaymentDate(Date.valueOf(parts[1]));
            accounting.setRecipientId(Integer.parseInt(parts[2]));
            accounting.setAmount(Double.parseDouble(parts[3]));
            return accounting;
        } else {
            System.err.println("Expenses parsing error!");
            return null;
        }

    }

    @Override
    public Accounting[] parseContractors(String[] newContractors) {

        Accounting[] accountings = new Accounting[newContractors.length];
        for (int i = 0; i < newContractors.length; i++) {
            accountings[i] = parseContractor(newContractors[i]);
        }
        return accountings;
    }

    @Override
    public Accounting[] parseExpenses(String[] newExpenses) {

        Accounting[] accountings = new Accounting[newExpenses.length];
        for (int i = 0; i < newExpenses.length; i++) {
            accountings[i] = parseContractor(newExpenses[i]);
        }
        return accountings;
    }

}
