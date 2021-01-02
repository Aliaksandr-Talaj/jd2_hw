package it.academy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArgsInputValidator implements InputValidator {

    Pattern patternId = Pattern.compile("^[\\d]{1,10}$");
    Pattern patternDate1 = Pattern.compile("^\\d{4}/([0][1-9]|[1-9]|1[0-2])/([0]?[1-9]|[12][0-9]|[3][01])$");
    Pattern patternDate2 = Pattern.compile("^\\d{4}-([0][1-9]|[1-9]|1[0-2])-([0]?[1-9]|[1-9]|[1|2][0-9]|[3][0|1])$");
    Pattern patternAmount = Pattern.compile("^[\\d]{1,20}[,|\\.]?[\\d]+$");
    Pattern patternNotName = Pattern.compile("^[-\\.\\!\\?\\;\\:\\*\\d]+[.\\w]*[\\,\\.]*[\\d]*$");



    @Override
    public boolean isId(String testString) {
        Matcher idMatcher = patternId.matcher(testString);
        if (idMatcher.find()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isNotName(String testString) {
        Matcher notNameMatcher = patternNotName.matcher(testString);
        if (notNameMatcher.find()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isDate(String testString) {
        Matcher dateMatcher1 = patternDate1.matcher(testString);
        Matcher dateMatcher2 = patternDate2.matcher(testString);
        if (dateMatcher1.find() || dateMatcher2.find()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isAmount(String testString) {
        Matcher amountMatcher = patternAmount.matcher(testString);
        if (amountMatcher.find()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isContractors(String[] testStrings) {

        int counter = 0;
        for (String testString : testStrings) {
            String[] params = testString.split(" +");


            if (params.length == 2) {

                Matcher idMatcher = patternId.matcher(params[0]);
                Matcher notNameMatcher = patternNotName.matcher(params[1]);

                if (idMatcher.find() && !notNameMatcher.find()) {
                    counter++;
                }

            }

            return false;
        }
        if (counter == testStrings.length) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isExpenses(String[] testStrings) {
        int counter = 0;
        for (String testString : testStrings) {
            String[] params = testString.split(" +");
            if (params.length == 4) {
                Matcher idMatcher1 = patternId.matcher(params[0]);
                Matcher dateMatcher1 = patternDate1.matcher(params[1]);
                Matcher dateMatcher2 = patternDate2.matcher(params[1]);
                Matcher idMatcher2 = patternId.matcher(params[2]);
                Matcher amountMatcher = patternAmount.matcher(params[3]);
                if (idMatcher1.find()
                        && dateMatcher1.find() || dateMatcher2.find()
                        && idMatcher2.find()
                        && amountMatcher.find()) {
                    counter++;
                }

            } else {
                return false;
            }
        }
        if (counter == testStrings.length) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isContractorString(String testString) {
        String[] params = testString.split(" +");
        return isContractor(params);

    }

    @Override
    public boolean isContractor(String[] params) {

        if (params.length != 2) {
            return false;
        }
        return (isId(params[0]) && !isNotName(params[1]));

    }

    @Override
    public boolean isExpenseString(String testString) {
        String[] params = testString.split(" +");
        return isExpense(params);
    }

    @Override
    public boolean isExpense(String[] params) {
        if (params.length != 4) {
            return false;
        }
        return (isId(params[0])
                && isDate(params[1])
                && isId(params[2])
                && isAmount(params[3])
        );
    }


}
