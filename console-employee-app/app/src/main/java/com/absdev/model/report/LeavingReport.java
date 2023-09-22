package com.absdev.model.report;

import java.time.LocalDate;

public class LeavingReport extends Report{

    private String absenceReason;
    public LeavingReport(LocalDate date, Integer workingHours, String information, String absenceReason) {
        super(date, workingHours, 0, information);
        this.absenceReason = absenceReason;
    }

    @Override
    public String getInformation() {
        return String.format("Отсутствовал по причине: %s\n%s", absenceReason, super.getInformation());
    }
}
