package com.absdev.model.report;

import java.time.LocalDate;

/**
 * <p>Отчет о проведенном на рабочем месте времени.</p>
 * <p>workingHours - установленное количество рабочих часов</p>
 * <p>actualHoursOfWorking - фактически отработано часов сотрудником</p>
 * <p>information - дополнительная инфармация (причина отсутствия)</p>
 * <p>date - дата отчета</p>
 */
public class Report {
    protected LocalDate date;
    protected Integer workingHours;
    protected Integer actualHoursOfWorking;
    protected String information;


    public Report(LocalDate date, Integer workingHours, Integer actualHoursOfWorking, String information) {
        this.date = date;
        this.workingHours = workingHours;
        this.actualHoursOfWorking = actualHoursOfWorking;
        this.information = information;
    }

    public Integer getWorkingHours() {
        return workingHours;
    }

    public Integer getActualHoursOfWorking() {
        return actualHoursOfWorking;
    }

    public String getInformation() {
        return information;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
