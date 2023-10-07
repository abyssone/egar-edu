package ru.absdev.registry;

import ru.absdev.document.DocStatus;

import java.time.LocalDate;
import java.util.List;

/**
 * Описывает все необходимые для реестра поля из всех подтипов Document
 */
public class RegistryEntry {

    private int docCode;
    private String documentName;
    private DocStatus status;
    private String ownerName;
    private LocalDate birthDate;
    private String citizenship;
    private Long PassportSeriesAndNumber;
    private String nameOfMilitaryUnit;
    private LocalDate MilitaryIDIssueDate;
    private List<String> drivingCategories;
    private LocalDate driverLicenseIssueDate;
    private LocalDate driverLicenseExpirationDate;

    public RegistryEntry(int docCode, String documentName, DocStatus status, String ownerName) {
        this.docCode = docCode;
        this.documentName = documentName;
        this.status = status;
        this.ownerName = ownerName;
    }

    public int getDocCode() {
        return docCode;
    }

    public String getDocumentName() {
        return documentName;
    }

    public DocStatus getStatus() {
        return status;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public Long getPassportSeriesAndNumber() {
        return PassportSeriesAndNumber;
    }

    public String getNameOfMilitaryUnit() {
        return nameOfMilitaryUnit;
    }

    public LocalDate getMilitaryIDIssueDate() {
        return MilitaryIDIssueDate;
    }

    public List<String> getDrivingCategories() {
        return drivingCategories;
    }

    public LocalDate getDriverLicenseIssueDate() {
        return driverLicenseIssueDate;
    }

    public LocalDate getDriverLicenseExpirationDate() {
        return driverLicenseExpirationDate;
    }

    public void setStatus(DocStatus status) {
        this.status = status;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public void setPassportSeriesAndNumber(Long passportSeriesAndNumber) {
        PassportSeriesAndNumber = passportSeriesAndNumber;
    }

    public void setNameOfMilitaryUnit(String nameOfMilitaryUnit) {
        this.nameOfMilitaryUnit = nameOfMilitaryUnit;
    }

    public void setMilitaryIDIssueDate(LocalDate militaryIDIssueDate) {
        MilitaryIDIssueDate = militaryIDIssueDate;
    }

    public void setDrivingCategories(List<String> drivingCategories) {
        this.drivingCategories = drivingCategories;
    }

    public void setDriverLicenseIssueDate(LocalDate driverLicenseIssueDate) {
        this.driverLicenseIssueDate = driverLicenseIssueDate;
    }

    public void setDriverLicenseExpirationDate(LocalDate driverLicenseExpirationDate) {
        this.driverLicenseExpirationDate = driverLicenseExpirationDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}