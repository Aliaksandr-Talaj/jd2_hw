package it.academy;


import java.sql.SQLException;

public class Task4 {


    public static void main(String[] args) throws SQLException {


        DaoFactory daoFactory = new DaoFactory();
        AccountingDao accountingDao = null;


        try {
            accountingDao = daoFactory.getAccountingDao();
        } catch (SQLException e) {
            System.out.println("Connection failure");
            e.printStackTrace();
        }
        ArgsInputValidator argsInputValidator = new ArgsInputValidator();
        switch (args.length) {
            case 0: {

            }
            break;
            case 1: {
                if (args[0].equalsIgnoreCase("-recipients")) {
                    accountingDao.printRecipients();
                    break;
                } else {
                    String[] params1 = args[0].split("( +\")|(\" *)");
                    if (params1.length == 2
                            && argsInputValidator.isId(params1[0])
                            && !argsInputValidator.isNotName(params1[1])
                    ) {
                        //парсинг одной строки контрагента
                        //на входе два параметра в одном массиве
                        Accounting accounting = accountingDao.parseContractor(params1);
                        //добавление в таблицу контрагентов
                        accountingDao.addContractor(accounting);
                        accountingDao.printRecipients();

                        break;
                    }

                    String[] params = args[0].split(" +");

                    switch (params.length) {
                        case 2: { // один параметр из двух строк в общих кавычках
                            if (argsInputValidator.isId(params[0]) && !argsInputValidator.isNotName(params[1])) {
                                //парсинг одной строки контрагента
                                // на входе массив из двух строк по одному параметру
                                Accounting accounting = accountingDao.parseContractor(params);
                                //добавление в таблицу контрагентов
                                accountingDao.addContractor(accounting);
                                accountingDao.printRecipients();

                            } else {
                                System.out.println("Неправильный один параметр из двух строк в общих кавычках ");
                            }
                        }
                        break;
                        case 4: { // один параметр из четырех строк в общих кавычках
                            if (argsInputValidator.isId(params[0])
                                    && argsInputValidator.isDate(params[1])
                                    && argsInputValidator.isId(params[2])
                                    && argsInputValidator.isAmount(params[3])
                            ) {
                                //парсинг одной строки расхода
                                // на входе строка или массив из четырёх строк по одному параметру
                                Accounting accounting = accountingDao.parseExpense(params);
                                //добавление в таблицу расходов
                                accountingDao.addExpense(accounting);

                            } else {
                                System.out.println("Неправильный один параметр из 4 строк в общих кавычках ");
                            }
                        }
                        break;
                        default: {
                            System.out.println("Неправильный один параметр в общих кавычках ");
                        }

                    }
                }
            }

            break;
            case 2: { //массив из двух аргументов
                if (argsInputValidator.isContractor(args)) {
                    // парсинг одной строки контрагента
                    // на входе массив из двух строковых параметров
                    Accounting accounting = accountingDao.parseContractor(args);
                    //добавление в таблицу контрагентов
                    accountingDao.addContractor(accounting);
                    accountingDao.printRecipients();


                } else {
                    //проверка на несколько строк параметров contractors or expenses

                    for (String arg : args) { // два агрумента

                        if (argsInputValidator.isContractorString(arg)) {
                            //парсинг одной строки контрагента
                            //на входе строка из двух параметров
                            Accounting accounting = accountingDao.parseContractor(arg);
                            //добавление в таблицу контрагентов
                            accountingDao.addContractor(accounting);
                            accountingDao.printRecipients();

                        } else if (argsInputValidator.isExpenseString(arg)) {
                            //парсинг одной строки расхода
                            //на входе строка из 4 параметров
                            Accounting accounting = accountingDao.parseExpense(arg);
                            //добавление в таблицу расходов
                            accountingDao.addExpense(accounting);

                        } else {
                            System.out.println("Неправильный параметр из двух агрументов ");
                        }
                    }// конец цикла for
                }
            }
            break;
            case 4: { //массив из черырех аргументов
                if (argsInputValidator.isExpense(args)) {
                    // парсинг одной строки сделки
                    // на входе массив из 4 строковых параметров
                    Accounting accounting = accountingDao.parseExpense(args);
                    ///добавление в таблицу расходов
                    accountingDao.addExpense(accounting);


                } else {
                    //проверка на несколько строк параметров contractors or expenses


                    for (String arg : args) { // 4 агрумента

                        if (argsInputValidator.isContractorString(arg)) {
                            //парсинг одной строки контрагента
                            //на входе строка из двух параметров
                            Accounting accounting = accountingDao.parseContractor(arg);
                            //добавление в таблицу контрагентов
                            accountingDao.addContractor(accounting);
                            accountingDao.printRecipients();

                        } else if (argsInputValidator.isExpenseString(arg)) {
                            //парсинг одной строки расхода
                            //на входе строка из 4 параметров
                            Accounting accounting = accountingDao.parseExpense(arg);
                            //добавление в таблицу расходов
                            accountingDao.addExpense(accounting);

                        } else {
                            System.out.println("Неправильный параметр из 4 аргументов ");
                        }
                    }// конец цикла for
                }
            }
            break;

            default: { //массив из N аргументов
                for (String arg : args) {

                    if (argsInputValidator.isContractorString(arg)) {
                        //парсинг одной строки контрагента
                        //на входе строка из двух параметров
                        Accounting accounting = accountingDao.parseContractor(arg);
                        //добавление в таблицу контрагентов
                        accountingDao.addContractor(accounting);
                        accountingDao.printRecipients();

                    } else if (argsInputValidator.isExpenseString(arg)) {
                        //парсинг одной строки расхода
                        //на входе строка из 4 параметров
                        Accounting accounting = accountingDao.parseExpense(arg);
                        //добавление в таблицу расходов
                        accountingDao.addExpense(accounting);

                    } else {
                        System.out.println("Неправильный один параметр из множества аргументов "); //printWrongParameter();
                    }
                }// конец цикла for
            }

        }
        accountingDao.printAll();
    }

//

}



