package ru.absdev.document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DriverLicense extends Document {

    private List<String> categories;
    private LocalDate issueDate;
    private LocalDate expirationDate;

    public DriverLicense(String ownerName, List<String> categories, LocalDate issueDate, LocalDate expirationDate) {
        super(DocConst.DRIVER_LICENSE.getCode(), ownerName);
        this.categories = categories;
        this.issueDate = issueDate;
        this.expirationDate = expirationDate;
    }

    public DriverLicense(String ownerName, String category, LocalDate issueDate, LocalDate expirationDate) {
        super(DocConst.DRIVER_LICENSE.getCode(), ownerName);
        categories = new ArrayList<>();
        categories.add(category);
        this.issueDate = issueDate;
        this.expirationDate = expirationDate;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public void addCategory(String category) {
        categories.add(category);
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
