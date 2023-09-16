package com.absdev.storage;

import com.absdev.model.Company;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStorage {
    private static final List<Company> companyStorage = new ArrayList<>();

    public static List<Company> findAllCompanies() {
        return companyStorage;
    }

    public static void saveCompany (Company company) {
        companyStorage.add(company);
    }
}
