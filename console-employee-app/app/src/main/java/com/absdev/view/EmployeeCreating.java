package com.absdev.view;

import com.absdev.model.Employee;
import com.absdev.storage.SessionState;

public class EmployeeCreating extends SubMenu {
    private final static EmployeeCreating instance = new EmployeeCreating();
    private EmployeeCreating() {

    }

    public static EmployeeCreating getInstance() {
        return instance;
    }

    @Override
    public void run() {
        this.print();
    }

    private void print() {
        String name, email, position;

        System.out.println("===== Добавление сотрудника =====\n");

        System.out.print("Введите имя: ");
        name = scanner.nextLine();

        System.out.print("Введите email: ");
        email = scanner.nextLine();

        System.out.print("Введите должность: ");
        position = scanner.nextLine();

        Employee newEmployee = new Employee(name, email, position);
        SessionState.getCurrentCompany().addEmployee(newEmployee);
        back();
    }
}
