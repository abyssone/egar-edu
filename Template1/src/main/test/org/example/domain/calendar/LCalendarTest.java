package org.example.domain.calendar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LCalendarTest {

    static List<LCalendar> listCalendar = new ArrayList<>();

    @BeforeAll
    public static void setup() {
        listCalendar.add(new LCalendar("2023-05-06", false));
        listCalendar.add(new LCalendar("2023-05-08", false));
    }

    @Test
    public void getDateW() {
        LCalendar lCalendar = listCalendar.get(1);

        assertEquals(false, lCalendar.getDayOff());
    }
}