package org.example;

import org.example.domain.card.Card;
import org.example.exception.MyException;

public class Main {
    public static void main(String[] args) throws MyException {
        Card card = new Card(null, 14l);

        card.setName("");
    }
}