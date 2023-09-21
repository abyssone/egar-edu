package com.absdev.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    @Test
    void whenTitleIsCorrect_thenGetTitleShouldBeReturnSame() {
        String title = "Some Company";
        Company company = new Company(title);
        assertEquals(title, company.getTitle());
    }

    @Test
    void whenTitleIsNull_thenExpectIllegalArgException() {
        String title = null;
        assertThrows(IllegalArgumentException.class, () -> new Company(title));
    }

    @Test
    void whenAddCorrectEmployee_thenCompanyShouldContainHim() {
        String expectedName = "name";
        String expectedEmail = "email";
        String expectedPosition = "position";

        Employee employee = new Employee(expectedName, expectedEmail, expectedPosition);
        Company company = new Company("Some Company");
        company.addEmployee(employee);

        List<Employee> actualEmployees = company.getEmployees();
        assertFalse(actualEmployees == null);
        assertFalse(actualEmployees.isEmpty());
        assertEquals(expectedName, actualEmployees.get(0).getName());
        assertEquals(expectedEmail, actualEmployees.get(0).getEmail());
        assertEquals(expectedPosition, actualEmployees.get(0).getPosition());
    }

    @Test
    void whenAddNullToEmployees_thenExpectedIllegalArgException() {
        assertThrows(IllegalArgumentException.class, () -> new Company("title").addEmployee(null));
    }

    @Test
    void whenEmployeesNotAdded_thenShouldBeReturnEmptyList() {
        Company company = new Company("title");

        assertTrue(company.getEmployees().isEmpty());
    }
}