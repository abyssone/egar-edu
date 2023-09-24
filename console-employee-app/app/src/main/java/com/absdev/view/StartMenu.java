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
    public void run() {
        List<Company> companies = InMemoryStorage.findAllCompanies();
        int option;

        SessionState.setPrevMenu(this);
        this.print(companies);
        option = waitNextInt();
        this.nextAction(option, companies);
    }

    private void print(List<Company> companies) {

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
    }

    private void nextAction(int option, List<Company> companies) {

        switch (option) {
            case (-1):
                System.out.println("Bye");
                break;
            case (0):
                SessionState.setPrevMenu(this);
                CompanyCreating.getInstance().run();
                break;
            default:
                if (option > 0 && option <= companies.size()) {
                    SessionState.setPrevMenu(this);
                    SessionState.setCurrentCompany(companies.get(option - 1));
                    CompanyMenu.getInstance().run();
                }
                break;
        }
    }
}
