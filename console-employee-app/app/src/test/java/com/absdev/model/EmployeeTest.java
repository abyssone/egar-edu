package com.absdev.model;

import com.absdev.model.report.Report;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void WhenNameIsNullOrEmpty_thenExpectIllegalArgException() {
        String email = "email";
        String position = "position";
        assertThrows(IllegalArgumentException.class, () -> new Employee(null, email, position));
        assertThrows(IllegalArgumentException.class, () -> new Employee("", email, position));
    }

    @Test
    void WhenPositionIsNullOrEmpty_thenExpectIllegalArgException() {
        String name = "name";
        String email = "email";
        assertThrows(IllegalArgumentException.class, () -> new Employee(name, email, null));
        assertThrows(IllegalArgumentException.class, () -> new Employee(name, email, ""));
    }

    @Test
    void WhenEmailIsNullOrEmpty_thenExpectIllegalArgException() {
        String name = "name";
        String position = "position";
        assertThrows(IllegalArgumentException.class, () -> new Employee(name, null, position));
        assertThrows(IllegalArgumentException.class, () -> new Employee(name, "", position));
    }

    @Test
    void WhenCorrectParameters_thenGetMethodsShouldReturnThem () {
        String name1 = "name";
        String name2 = "sees23";
        String name3 = "se0sef23f";
        String email1 = "email";
        String email2 = "sees2seg3";
        String email3 = "se0sef23segsgf";
        String position1 = "position";
        String position2 = "see3";
        String position3 = "se0sesfsef23f";
        Employee employee1 = new Employee(name1, email1, position1);
        Employee employee2 = new Employee(name2, email2, position2);
        Employee employee3 = new Employee(name3, email3, position3);
        assertEquals(name1, employee1.getName());
        assertEquals(name2, employee2.getName());
        assertEquals(name3, employee3.getName());
        assertEquals(email1, employee1.getEmail());
        assertEquals(email2, employee2.getEmail());
        assertEquals(email3, employee3.getEmail());
        assertEquals(position1, employee1.getPosition());
        assertEquals(position2, employee2.getPosition());
        assertEquals(position3, employee3.getPosition());
    }

    @Test
    void whenUseSetMethods_shouldReturnNewValue() {
        Employee employee = new Employee("name", "email", "position");
        String newName = "newname";
        String newEmail = "newemail";
        String newPos = "newPos";
        employee.setName(newName);
        employee.setEmail(newEmail);
        employee.setPosition(newPos);
        assertEquals(newName, employee.getName());
        assertEquals(newEmail, employee.getEmail());
        assertEquals(newPos, employee.getPosition());
    }

    @Test
    void whenAddNullAsReport_thenExpectIllegalArgException() {
        Employee employee = new Employee("sef", "esfs", "esff");
        assertThrows(IllegalArgumentException.class, () -> employee.addReport(null));
    }

    @Test
    void whenAddCorrectReport_thenItShouldBeAdded() {
        Report rep1 = new Report("2000-02-02", 8, 8, "info");
        Report rep2 = new Report("2000-02-15", 8, 8, "info2");
        Employee employee = new Employee("name", "email", "pos");
        employee.addReport(rep1);
        employee.addReport(rep2);
        List<Report> reps = employee.getReports();
        assertTrue(reps.contains(rep1));
        assertTrue(reps.contains(rep2));
    }
}