package com.absdev.model.report;

import com.absdev.exception.OutOfRangeException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

class ReportTest {

    @Test
    void whenCorrectParams_thenReportShouldBeCreated() {
        String date = "2020-07-23";
        int wHours = 8;
        int awHours = 4;
        String info = "info";
        Report report = new Report(date, wHours, awHours, info);
        assertEquals(LocalDate.parse(date), report.getDate());
        assertEquals(wHours, report.getWorkingHours());
        assertEquals(awHours, report.getActualHoursOfWorking());
        assertEquals(info, report.getInformation());
    }

    @Test
    void whenMoreThan24Hours_thenExpectOutOfRangeException () {
        assertThrows(OutOfRangeException.class, () -> new Report("2000-01-01",
                25,
                3,
                "info"));
        assertThrows(OutOfRangeException.class, () -> new Report("2000-01-01",
                3,
                25,
                "info"));
    }

    @Test
    void whenLessThan0Hours_thenExpectOutOfRangeException () {
        assertThrows(OutOfRangeException.class, () -> new Report("2000-01-01",
                -1,
                3,
                "info"));
        assertThrows(OutOfRangeException.class, () -> new Report("2000-01-01",
                3,
                -1,
                "info"));
    }

    @Test
    void whenInvalidDateFormat_thenExpect () {
        assertThrows(DateTimeParseException.class, () ->
                new Report("01.01.2000", 3, 3, "info"));
        assertThrows(DateTimeParseException.class, () ->
                new Report("00000", 3, 3, "info"));
        assertThrows(DateTimeParseException.class, () ->
                new Report("2000.01.01", 3, 3, "info"));
        assertThrows(DateTimeParseException.class, () ->
                new Report("01-01-2000", 3, 3, "info"));

    }

}