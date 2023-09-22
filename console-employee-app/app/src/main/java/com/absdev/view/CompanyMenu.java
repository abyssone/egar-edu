package com.absdev.view;

import com.absdev.model.Company;
import com.absdev.model.Employee;
import com.absdev.storage.SessionState;
import com.absdev.util.Validator;

import java.util.List;

public class CompanyMenu extends SubMenu{
    private final static CompanyMenu instance = new CompanyMenu();
    private CompanyMenu() {

    }

    public static CompanyMenu getInstance() {
        return instance;
    }

    @Override
    public void run() {
        Company company = SessionState.getCurrentCompany();
        List<Employee> employees = company.getEmployees();
        int option;

        this.print(company, employees);
        option = waitNextInt();
        this.nextAction(option, employees);
    }

    private void print(Company company, List<Employee> employees) {
        printHeader(company.getTitle());

        if (employees != null && !employees.isEmpty()) {
            for (int i = 1; i <= employees.size(); i++) {
                Employee employee = employees.get(i - 1);
                System.out.printf("%s\n", employeeStringFormat(i, employee));
            }
        } else {
            System.out.println("Добавьте первого сотрудника\n");
        }

        System.out.println("0.\tДобавить сотрудника");
        System.out.println("-1.\tНазад");
    }

    private void nextAction(int option, List<Employee> employees) {
        switch (option) {
            case (-1):
                back();
                break;
            case (0):
                SessionState.setPrevMenu(this);
                EmployeeCreating.getInstance().run();
                break;
            default:
                if (option > 0 && option <= employees.size()) {
                    SessionState.setPrevMenu(this);
                    SessionState.setCurrentEmployee(employees.get(option - 1));
                    EmployeeMenu.getInstance().run();
                }
                break;
        }
    }

    private String employeeStringFormat(int order, Employee employee) {
        return (order + ".\tИмя:\t\t" + employee.getName() +
                        "\n\tEmail:\t\t" + employee.getEmail() +
                        "\n\tДолжность:\t" + employee.getPosition() + "\n");
    }
}
