package com.absdev.view;

import com.absdev.storage.GlobalState;

import java.util.Scanner;

public class CompanyMenu extends SubMenu{
    private final static CompanyMenu instance = new CompanyMenu();
    private CompanyMenu() {

    }

    public static CompanyMenu getInstance() {
        return instance;
    }

    @Override
    public void print() {
        System.out.println("===" + GlobalState.getCurrentCompany().getTitle() + "===\n");
        System.out.println("Добавьте первого сотрудника");
        System.out.println("\n0. Назад");

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == 0) {
            back();
        }
    }
}
