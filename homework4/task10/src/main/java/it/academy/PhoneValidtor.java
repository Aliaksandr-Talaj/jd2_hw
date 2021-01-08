package it.academy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidtor implements InputValidator{

    private static Pattern pattern = Pattern.compile("(\\+375|80)[\\s\\-]?\\(?(29|24|25|44|33|17)\\)?[\\s\\-]?(\\d{3})[\\s\\-]?(\\d{2})[\\s\\-]?(\\d{2})");

    @Override
    public boolean badInput(String testString) {
        if(testString==null||testString.equalsIgnoreCase("")){
            return true;
        }
        Matcher matcher = pattern.matcher(testString);
        return !(matcher.find());
    }
}
