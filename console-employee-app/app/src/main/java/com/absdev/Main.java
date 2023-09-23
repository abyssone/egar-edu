package com.absdev;

import com.absdev.model.Company;
import com.absdev.model.Employee;
import com.absdev.storage.InMemoryStorage;
import com.absdev.view.StartMenu;

public class Main {
    public static void main(String[] args) {

        Employee e1 = new Employee("Oleg", "oleg@mail.ru", "dev");
        Employee e2 = new Employee("Ivan", "iv@mail.ru", "qa");
        Employee e3 = new Employee("Irina", "irina@mail.ru", "dev");
        Employee e4 = new Employee("Alex", "alex000@mail.ru", "hr");
        Employee e5 = new Employee("Maxim", "mx@mail.ru", "pm");
        Employee e6 = new Employee("Sergey", "serj@mail.ru", "dev");

        Company c = new Company("Google");
        c.addEmployee(e1);
        c.addEmployee(e2);
        c.addEmployee(e3);
        c.addEmployee(e4);
        c.addEmployee(e5);
        c.addEmployee(e6);

        InMemoryStorage.saveCompany(c);

        StartMenu.getInstance().run();
    }
}