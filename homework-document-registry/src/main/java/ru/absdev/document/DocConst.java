package ru.absdev.document;

import java.util.Optional;

public enum DocConst {
    PASSPORT(1000, "Паспорт"),
    BIRTH_CERT(1001, "Свидетельство о рождении"),
    DRIVER_LICENSE(1010, "Водительское удостоверение"),
    MILITARY_ID(1011, "Военный билет");
    private final int code;

    private final String name;
    private DocConst(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static Optional<DocConst> findByCode(int code) {
        for (DocConst docConst : DocConst.values()) {
            if (code == docConst.getCode()) return Optional.of(docConst);
        }
        return Optional.empty();
    }
}
