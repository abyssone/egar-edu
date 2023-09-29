package org.example.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dictionary {
    private List<Document> list;

    public Dictionary() {
        list = Arrays.asList(
            new Document(1, "Свидетельство о рождении"),
            new Document(2, "Паспорт"),
            new Document(3, "Военный билет"),
            new Document(4, "Временное удостоверение"),
            new Document(5, "Справка об освобождении")
        );
    }

    public List<Document> getList() {
        return list;
    }
}
