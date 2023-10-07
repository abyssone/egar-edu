package ru.absdev.document;

import java.time.LocalDate;

/**
 * Свидетельство о рождении
 */
public class BirthCert extends Document{
    private LocalDate birthDate;

    public BirthCert(String ownerName, LocalDate birthDate) {
        super(DocConst.BIRTH_CERT.getCode(), ownerName);
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
