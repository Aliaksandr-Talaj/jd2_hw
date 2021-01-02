package it.academy;

import java.util.List;

public interface AccountingDao {

    void create (Accounting accounting);

    public void addExpense(Accounting accounting);

    public void addContractor(Accounting accounting);

    void update (Accounting accounting);

    void delete (Accounting accounting);

    void print (Accounting accounting);

    public void printAll();

    public void printRecipients();

    public Accounting parseContractor(String newContractor);

    public Accounting parseContractor(String [] parts);

    public Accounting parseExpense(String newExpense);

    public Accounting parseExpense(String [] parts);

    public Accounting[] parseContractors(String[] newContractors);

    public Accounting[] parseExpenses(String[] newExpenses);

}
