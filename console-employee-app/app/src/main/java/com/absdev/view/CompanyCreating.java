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

    @Override
    public void run() {
        this.print();
        this.addCompany();
    }

    private void print() {
        printHeader("Добавление компании");
        System.out.print("Введите название: ");
    }

    private void addCompany() {
        String input = scanner.nextLine();
        InMemoryStorage.saveCompany(new Company(input));
        back();
    }

}
