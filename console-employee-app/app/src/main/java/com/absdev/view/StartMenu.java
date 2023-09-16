package com.absdev.view;

import java.util.Scanner;

public class StartMenu extends Menu {

    private final static StartMenu instance = new StartMenu();
    private StartMenu() {

    }

    public static StartMenu getInstance() {
        return instance;
    }

    @Override
    public void print() {
        String[] params = {"sefsef", "sefsef", "sssewtwet"};

        System.out.println("===== HELLO ====");
        for (String line : params) {
            System.out.println(line);
        }
        System.out.println("0 for exit");
        System.out.println("1 for create company");

        waitNextInput();
    }

    private void waitNextInput() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == 0) {
            System.out.println("Bye");
        } else if (input == 1) {
            CompanyCreating.getInstance().print(this, "sefsef");
        }
    }
}
