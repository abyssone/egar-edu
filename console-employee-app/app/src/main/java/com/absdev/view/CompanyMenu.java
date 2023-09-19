package com.absdev.view;

import com.absdev.model.Company;
import com.absdev.model.Employee;
import com.absdev.storage.SessionState;

import java.util.List;

public class CompanyMenu extends SubMenu{
    private final static CompanyMenu instance = new CompanyMenu();
    private CompanyMenu() {

    }

    public static CompanyMenu getInstance() {
        return instance;
    }

    @Override
    public void print() {
        Company company = SessionState.getCurrentCompany();
        List<Employee> employees = company.getEmployees();

        System.out.println("=====" + company.getTitle() + "=====\n");

        if (employees != null && !employees.isEmpty()) {
            for (int i = 1; i <= employees.size(); i++) {
                Employee employee = employees.get(i - 1);

                System.out.println("Имя: " + employee.getName());
                System.out.println("Email: " + employee.getEmail());
                System.out.println("Должность: " + employee.getPosition() + "\n");
            }
        } else {
            System.out.println("Добавьте первого сотрудника\n");
        }


        System.out.println("99. Добавить сотрудника");
        System.out.println("0. Назад");

        int input = scanner.nextInt();
        switch (input) {
            case 0:
                back();
                break;
            case 99:
                SessionState.setPrevMenu(this);
                EmployeeCreating.getInstance().print();
        }
    }
}
