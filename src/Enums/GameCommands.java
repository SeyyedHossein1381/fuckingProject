package Enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum GameCommands {
    swipeRegex("^swipe (?<X>\\d+) (?<Y>\\d+) (?<direction>R|D|L|U)$"),
    activeLollipopHammerRegex("^active lollipop hammer (?<X>\\d+) (?<Y>\\d+)$"),
    activeColourBombBrushRegex("^active colour bomb brush (?<X>\\d+) (?<Y>\\d+)$"),
    activeWrappedCrushRegex("^active wrapped brush (?<X>\\d+) (?<Y>\\d+)$"),
    acteveStripedBrushRegex("^active striped brush (?<X>\\d+) (?<Y>\\d+) (?<direction>h|v)$"),
    activeFreeSwitchRegex("^active free switch (?<X>\\d+) (?<Y>\\d+) (?<direction>R|L|D|U)$"),
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
