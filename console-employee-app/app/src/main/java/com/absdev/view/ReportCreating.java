package com.absdev.view;

import com.absdev.model.Employee;
import com.absdev.model.report.LeavingReport;
import com.absdev.model.report.Report;
import com.absdev.storage.SessionState;

import java.time.LocalDate;

public class ReportCreating extends SubMenu{
    private final static ReportCreating instance = new ReportCreating();
    private ReportCreating() {

    }

    public static ReportCreating getInstance() {
        return instance;
    }
    @Override
    public void run() {
        Employee employee = SessionState.getCurrentEmployee();
        int option = 0;

        printHeader(employee.getName());
        printTypeReportChoise();
        while (option != 1 && option != 2)
            option = waitNextInt();
        createReport(option, employee);
        back();
    }

    private void printTypeReportChoise() {
        System.out.println("\tТип отчета:\n" +
                            "1.\tО присутствии\n" +
                            "2.\tОб отсутсвии\n");
    }

    private void createReport(int option, Employee employee) {
        String date, information;
        String absenceReason = "";
        int workingHours,  actualHoursOfWorking;

        System.out.print("Дата (yyyy-mm-dd): ");
        date = scanner.nextLine();

        System.out.print("Часов по плану: ");
        workingHours = waitNextInt();

        if (option == 1) {
            System.out.print("Часов присутствовал: ");
            actualHoursOfWorking = waitNextInt();

        } else {
            actualHoursOfWorking = 0;
            System.out.println("Причина отсутствия: ");
            absenceReason = scanner.nextLine();
        }
        System.out.println("Доп. информация: ");
        information = scanner.nextLine();

        employee.addReport(option == 1
                            ? new Report(date, workingHours, actualHoursOfWorking, information)
                            : new LeavingReport(date, workingHours, information, absenceReason));
    }
}
