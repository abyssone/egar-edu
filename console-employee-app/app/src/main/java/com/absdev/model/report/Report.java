package com.absdev.model.report;

import com.absdev.exception.OutOfRangeException;

import java.text.DateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;

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


    public Report(String dateFormat, Integer workingHours, Integer actualHoursOfWorking, String information) {
        if(workingHours < 0 || workingHours > 24 ||
            actualHoursOfWorking < 0 || actualHoursOfWorking > 24) {
            throw new OutOfRangeException();
        }

        this.date = LocalDate.parse(dateFormat);
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
