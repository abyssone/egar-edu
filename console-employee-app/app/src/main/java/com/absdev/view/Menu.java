package com.absdev.view;

import com.absdev.util.Validator;

import java.util.Arrays;
import java.util.Scanner;

public abstract class Menu{
    protected final Scanner scanner = new Scanner(System.in);
    public abstract void run();
    protected int waitNextInt() {
        String input = null;

        while (!Validator.isNumericString(input)) {
            input = scanner.nextLine();
        }

        return Integer.parseInt(input);
    }

    /**
     * Метод для вывода на экран заголовка в виде: ===== header =====
     * @param headerText Текст заголовка
     */
    protected void printHeader(String headerText) {
        int totalChars = 30;
        char[] decorLine;
        char decorChar = '=';
        StringBuilder result = new StringBuilder();

        if (headerText.length() > totalChars - 3) {
            System.out.println(headerText.substring(0, totalChars - 3) + "...\n");
            return;
        }
        decorLine = new char[Math.round((totalChars - headerText.length()) / 2)];
        Arrays.fill(decorLine, decorChar);
        result.append(decorLine).append(" " + headerText + " ").append(decorLine);

        System.out.println(result + "\n");
    }
}
