package it.academy;

public interface InputValidator {


    public boolean isId(String testString);

    public boolean isNotName(String testString);

    public boolean isDate(String testString);

    public boolean isAmount(String testString);

    public boolean isContractors(String[] testStrings);

    public boolean isExpenses(String[] testStrings);

    public boolean isContractorString(String testString);

    public boolean isContractor(String [] params);

    public boolean isExpenseString(String testString);

    public boolean isExpense(String [] params);

}
