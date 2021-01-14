package it.academy.data;

import java.io.PrintWriter;
import java.util.List;

public interface AccountingDao {

    void create (Accounting accounting);

    public Accounting read (int paymentNumber);

    public void addExpense(Accounting accounting);

    public void addContractor(Accounting accounting);

    List<Accounting> readAll();

    void update (Accounting accounting);

    void delete (Accounting accounting);

    void print (Accounting accounting, PrintWriter printWriter);

    public void printAll(PrintWriter printWriter);

    public void printRecipients(PrintWriter printWriter);

    public List <Accounting> getAccountingList ();

    public List <Accounting> getAccountingList (PrintWriter printWriter);

}
