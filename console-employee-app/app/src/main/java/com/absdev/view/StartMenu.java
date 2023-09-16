package com.absdev.view;

import com.absdev.model.Company;
import com.absdev.storage.GlobalState;
import com.absdev.storage.InMemoryStorage;

import java.util.List;
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
        GlobalState.setPrevMenu(this);
        List<Company> companies = InMemoryStorage.findAllCompanies();

        System.out.println("===== Главное меню =====\n");

        if (!companies.isEmpty()) {
            for (int i = 1; i <= companies.size(); i++) {
                System.out.println(i + ". " + companies.get(i - 1).getTitle());
            }
        } else {
            System.out.println("Добавьте первую копманию");
        }

        System.out.println("\n0 for exit");
        System.out.println("99 for create company");

        waitForNextInput(companies);
    }

    private void waitForNextInput(List<Company> companies) {
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();
        if (input == 0) {
            System.out.println("Bye");
        } else if (input == 99) {
            GlobalState.setPrevMenu(this);
            CompanyCreating.getInstance().print();
        } else {
            GlobalState.setPrevMenu(this);
            GlobalState.setCurrentCompany(companies.get(input - 1));
            CompanyMenu.getInstance().print();
        }
    }
}
