package Enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum MainCommands {
    RegisterRegex("^$");
    private String regex;

    MainCommands(String regex) {
        this.regex = regex;
    }

    public static Matcher getMatcher(String input, MainCommands command) {
        Matcher matcher = Pattern.compile(command.regex, Pattern.CASE_INSENSITIVE).matcher(input);
        if (matcher.matches()) {
            return matcher;
        }
        return null;
    }
}
