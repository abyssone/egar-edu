package com.absdev.model;

import com.absdev.model.report.Report;
import com.absdev.util.Validator;

import java.util.ArrayList;
import java.util.List;

import static com.absdev.util.Validator.*;

public class Employee {
    private String name;
    private String email;
    private String position;
    private List<Report> reports;

    public Employee(String name, String email, String position) {
        if(isNullOrEmptyString(name)
            || isNullOrEmptyString(email)
            || isNullOrEmptyString(position)) {
            throw new IllegalArgumentException("Параметры не могут быть пустыми");
        }
        this.name = name;
        this.email = email;
        this.position = position;
        this.reports = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Довабление нового отчета, если отчета за указанную дату еще не добавлено.
     * @param report Новый отчет
     * @return true если отчет добавлен, иначе false
     */
    public boolean addReport(Report report) {
        if(report == null) throw new IllegalArgumentException("Report не может быть null");
        if (this.reports.stream().noneMatch(r -> r.getDate().isEqual(report.getDate()))) {
            this.reports.add(report);
            return true;
        } else return false;
    }

    public List<Report> getReports() {
        List<Report> copy = new ArrayList<>(this.reports);
        return copy;
    }
}
