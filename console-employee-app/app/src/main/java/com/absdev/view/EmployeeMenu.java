package com.absdev.view;

import com.absdev.model.Employee;
import com.absdev.model.report.Report;
import com.absdev.storage.SessionState;

import java.util.List;

public class EmployeeMenu extends SubMenu{

    private final static EmployeeMenu instance = new EmployeeMenu();
    private EmployeeMenu() {

    }

    public static EmployeeMenu getInstance() {
        return instance;
    }

    @Override
    public void run() {
        Employee employee = SessionState.getCurrentEmployee();
        int option;

        this.print(employee);
        option = waitNextInt();
        this.nextAction(option);
    }

    private void nextAction(int option) {
        switch (option) {
            case (-1):
                back();
                break;
            case (0):
                SessionState.setPrevMenu(this);
                ReportCreating.getInstance().run();
                break;
        }
    }

    private void print(Employee employee) {
        printHeader(employee.getName());
        List<Report> reports = employee.getReports();

        System.out.println("Отчеты:");
        for (Report report : reports) {
            System.out.println(" Дата:\t" + report.getDate());
            System.out.println(" Установлено часов:\t" + report.getWorkingHours());
            System.out.println(" Фактически работал:\t" + report.getActualHoursOfWorking());
            System.out.println(" Доп. инфо:\t" + report.getInformation());
        }

        System.out.println("0.\tДобавить отчет");
        System.out.println("-1.\tНазад");
    }
}
