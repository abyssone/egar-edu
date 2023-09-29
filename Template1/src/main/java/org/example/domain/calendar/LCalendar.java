package org.example.domain.calendar;

public class LCalendar {

    private String dayR;
    private Boolean dayOff;

    public LCalendar(String dayR, Boolean dayOff) {
        this.dayR = dayR;
        this.dayOff = dayOff;
    }

    public String getDayR() {
        return dayR;
    }

    public void setDayR(String dayR) {
        this.dayR = dayR;
    }

    public Boolean getDayOff() {
        return dayOff;
    }

    public void setDayOff(Boolean dayOff) {
        this.dayOff = dayOff;
    }
}
