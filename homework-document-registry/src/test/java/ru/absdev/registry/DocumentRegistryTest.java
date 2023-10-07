package ru.absdev.registry;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.absdev.document.BirthCert;
import ru.absdev.document.MilitaryID;
import ru.absdev.document.Passport;
import ru.absdev.view.RegistryView;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DocumentRegistryTest {

    DocumentRegistry registry = new DocumentRegistry();
    Passport passport = new Passport(
            "Мельников Андрей",
            1234567890l,
            "Russian Federation");
    BirthCert birthCert = new BirthCert(
            "Кузнецов Андрей",
            LocalDate.parse("2010-01-01"));
    MilitaryID militaryID = new MilitaryID(
            "Иванов Иван",
            LocalDate.parse("2020-02-01"),
            "ВЧ 4321");

    @BeforeAll
    void init() {
        registry.addDocument(passport);
        registry.addDocument(birthCert);
        registry.addDocument(militaryID);
    }

    @Test
    void displayTest() {
        RegistryView.print(registry.getRegistry());
    }

    @Test
    void addEntry() {
        String name = "Максимов Андрей";
        String cz = "РФ";
        Long sn = 1234567890l;

        Passport passport = new Passport(
                name,
                sn,
                cz);
        registry.addDocument(passport);

        RegistryView.print(registry.getRegistry());
        RegistryEntry lastEntry = registry.getLastDocument().get();

        assertEquals(name, lastEntry.getOwnerName());
        assertEquals(cz, lastEntry.getCitizenship());
        assertEquals(sn, lastEntry.getPassportSeriesAndNumber());
    }
}