package it.academy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidator implements InputValidator{

    Pattern badName = Pattern.compile("^[-\\.\\!\\?\\;\\:\\*\\d]+[.\\w]*[\\,\\.]*[\\d]*$");

    @Override
    public boolean badInput(String testString) {
        if(testString==null||testString.equalsIgnoreCase("")){
            return true;
        }
        Matcher notNameMatcher = badName.matcher(testString);
        return notNameMatcher.find();
    }
}
