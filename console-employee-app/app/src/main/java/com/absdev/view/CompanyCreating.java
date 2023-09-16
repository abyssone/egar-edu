package com.absdev.view;

import com.absdev.model.Company;
import com.absdev.storage.InMemoryStorage;

import java.util.Scanner;

public class CompanyCreating extends SubMenu {
    private final static CompanyCreating instance = new CompanyCreating();
    private CompanyCreating() {

    }

    public static CompanyCreating getInstance() {
        return instance;
    }


    public void print() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Добавление компании ===\n");
        System.out.print("Введите название: ");

        String input = scanner.nextLine();
        InMemoryStorage.saveCompany(new Company(input));
        back();
    }
}
