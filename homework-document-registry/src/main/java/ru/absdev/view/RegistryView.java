package ru.absdev.view;

import ru.absdev.registry.RegistryEntry;

import java.util.Map;

public class RegistryView {

    public static void print(Map<Long, RegistryEntry> registry) {
        for (Long key : registry.keySet()) {
            RegistryEntry entry = registry.get(key);

            System.out.printf("%d. %s(%s). Status: %s\n", key, entry.getDocumentName(), entry.getDocCode(), entry.getStatus());
            System.out.println(entry.getOwnerName() + "\n");
            System.out.println("Дата рождения: " + entry.getBirthDate());
            System.out.println("Гражданство: " + entry.getCitizenship());
            System.out.println("Серия и номер паспорта: " + entry.getPassportSeriesAndNumber());
            System.out.println("Военная часть: " + entry.getNameOfMilitaryUnit());
            System.out.println("Дата получения военного билета: " + entry.getMilitaryIDIssueDate());
            System.out.println("Категории прав: " + entry.getDrivingCategories());
            System.out.println("Дата получения водительских прав: " + entry.getDriverLicenseIssueDate());
            System.out.println("Дата и.с.д. водительских прав: " + entry.getBirthDate());
            System.out.println("========================================\n");
        }
    }
}
