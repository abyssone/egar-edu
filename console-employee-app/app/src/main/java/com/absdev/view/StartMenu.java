package com.absdev.view;

import com.absdev.model.Company;
import com.absdev.storage.SessionState;
import com.absdev.storage.InMemoryStorage;
import com.absdev.util.Validator;

import java.util.List;

public class StartMenu extends Menu {

    private final static StartMenu instance = new StartMenu();
    private StartMenu() {

    }

    public static StartMenu getInstance() {
        return instance;
    }

    @Override
    public void print() {
        SessionState.setPrevMenu(this);
        List<Company> companies = InMemoryStorage.findAllCompanies();

        printHeader("Главное меню");

        if (!companies.isEmpty()) {
            for (int i = 1; i <= companies.size(); i++) {
                System.out.println(i + ". " + companies.get(i - 1).getTitle());
            }
        } else {
            System.out.println("Добавьте первую копманию");
        }

        System.out.println("\n0 - Создать компанию");
        System.out.println("-1 - Выход");

        waitForNextInput(companies);
    }

    private void waitForNextInput(List<Company> companies) {
        String input = null;
        int option;

        while (!Validator.isNumericString(input)) {
            input = scanner.nextLine();
        }

        option = Integer.parseInt(input);

        switch (option) {
            case (-1):
                System.out.println("Bye");
                break;
            case (0):
                SessionState.setPrevMenu(this);
                CompanyCreating.getInstance().print();
                break;
            default:
                if (option > 0 && option <= companies.size()) {
                    SessionState.setPrevMenu(this);
                    SessionState.setCurrentCompany(companies.get(option - 1));
                    CompanyMenu.getInstance().print();
                }
                break;
        }
    }
}
