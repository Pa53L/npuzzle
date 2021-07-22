package Utils;

import java.nio.charset.StandardCharsets;

public class ColorPrint {
    public static final String RESET = "\u001b[0m";
    public static final String BLACK = "\u001b[30m";
    public static final String RED = "\u001b[31m";
    public static final String GREEN = "\u001b[32m";
    public static final String YELLOW = "\u001b[33m";
    public static final String BLUE = "\u001b[34m";
    public static final String PURPLE = "\u001b[35m";
    public static final String CYAN = "\u001b[36m";
    public static final String WHITE = "\u001b[37m";

    public static final String RIGHT = "\uD83E\uDC7A";
    public static final String LEFT = "\uD83E\uDC78";
    public static final String UP = "\uD83E\uDC79";
    public static final String DOWN = "\uD83E\uDC7B";

    public static void print(String color, String text, boolean newLine) {
        System.out.print(color + text + RESET);
        if (newLine)
            System.out.println();
    }
}

