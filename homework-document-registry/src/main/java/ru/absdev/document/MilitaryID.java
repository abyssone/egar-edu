package ru.absdev.document;

import java.time.LocalDate;

/**
 * Военный билет
 */
public class MilitaryID extends Document {

    private LocalDate issueDate;
    private String nameOfMilitaryUnit;
    public MilitaryID(String ownerName, LocalDate issueDate, String nameOfMilitaryUnit) {
        super(DocConst.MILITARY_ID.getCode(), ownerName);
        this.issueDate = issueDate;
        this.nameOfMilitaryUnit = nameOfMilitaryUnit;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public String getNameOfMilitaryUnit() {
        return nameOfMilitaryUnit;
    }

    public void setNameOfMilitaryUnit(String nameOfMilitaryUnit) {
        this.nameOfMilitaryUnit = nameOfMilitaryUnit;
    }
}
