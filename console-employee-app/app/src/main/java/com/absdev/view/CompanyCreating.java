package com.absdev.view;

import java.util.Scanner;

public class CompanyCreating extends SubMenu {
    private final static CompanyCreating instance = new CompanyCreating();
    private CompanyCreating() {

    }

    public static CompanyCreating getInstance() {
        return instance;
    }

    public void print(Menu prevMenu, String companyName) {
        System.out.println("===" + companyName + "===");
        System.out.println(" 0 for back");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == 0) {
            back(prevMenu);
        }
    }
}
