package org.example.domain.card;

import org.example.exception.MyException;

public class Card {
    private String name;
    private Long id;
    private boolean isActive;

    public Card(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws MyException {
        if (name == null || name.length() == 0) {
            throw new MyException("Имя не может быть пустым");
        }
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
