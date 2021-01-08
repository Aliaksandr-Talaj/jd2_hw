package it.academy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements InputValidator{

    private static Pattern pattern = Pattern.compile("(\\w[\\w\\.\\_\\-]{2,})@(\\w+\\.)([a-z]{2,4})");

    @Override
    public boolean badInput(String testString) {
        if(testString==null||testString.equalsIgnoreCase("")){
            return true;
        }
        Matcher matcher = pattern.matcher(testString);
        return !(matcher.find());
    }
}
