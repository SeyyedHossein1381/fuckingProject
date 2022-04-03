package Enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum MainCommands {
    registerRegex("^register u (?<username>[\\S]+) p (?<password>[\\S]+) n (?<nickname>.+)$"),
    loginRegex("^login u (?<username>[\\S]+) p (?<password>[\\S]+)$"),
    listOfUsersRegex("^list of users$"),
    startNewGameRegex("^start new game (?<seed>\\d+) (?<moves>\\d+)$"),
    enterMenuRegex("^enter (?<menuName>(Profile)|(Shop)) menu$"),
    logoutRegex("^[\\s]{0,}logout[\\s]{0,}$"),
    showScoreboardRegex("^show scoreboard$"),
    exitRegex("^exit$"),
    showMoneyRegex("^show money$"),
    showInventoryRegex("^show inventory$"),
    buyBoosterRegex("^buy (?<boosterName>[a-z_]+) (?<count>\\d+)$"),
    changePasswordRegex("^change password (?<oldPassword>[\\S]+) (?<newPassword>[\\S]+)$"),
    specialCharactersRegex("^([*]|[.]|[!]|[@]|[$]|[%]|[\\^]|[&]|[(]|[)]|[{]|[}]|[[]|[]]|[:]|[;]|[<]|[>]|[,]|[?]|[\\/]|[~]|[_]|[+]|[-]|[=]|[|])+$"),
    backRegex("^back$"),
    showInformationRegex("^show information$"),
    removeAccountRegex("^remove account (?<currentPassword>[\\S]+)$"),
    showMenuRegex("^show current menu$")
    ;
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
