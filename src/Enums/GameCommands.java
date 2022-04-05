package Enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum GameCommands {
    swipeRegex("^swipe (?<Y>\\d+) (?<X>\\d+) (?<direction>R|D|L|U)$"),
    activeLollipopHammerRegex("^active lollipop hammer (?<Y>\\d+) (?<X>\\d+)$"),
    activeColourBombBrushRegex("^active colour bomb brush (?<Y>\\d+) (?<X>\\d+)$"),
    activeWrappedCrushRegex("^active wrapped brush (?<Y>\\d+) (?<X>\\d+)$"),
    acteveStripedBrushRegex("^active striped brush (?<Y>\\d+) (?<X>\\d+) (?<direction>h|v)$"),
    activeFreeSwitchRegex("^active free switch (?<Y>\\d+) (?<X>\\d+) (?<direction>R|L|D|U)$"),
    activeExtraMoveRegex("^active extra moves$"),
    showBoardRegex("^show board$"),
    showBoostersRegex("^show boosters$")
    ;
    private String regex;

    GameCommands(String regex) {
        this.regex = regex;
    }

    public static Matcher getMatcher(String input, GameCommands command) {
        Matcher matcher = Pattern.compile(command.regex, Pattern.CASE_INSENSITIVE).matcher(input);
        if (matcher.matches()) {
            return matcher;
        }
        return null;
    }
}
