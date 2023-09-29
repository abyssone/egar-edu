package org.example.exception;

import org.example.domain.card.Card;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DisplayName("ТЕстирование моего класса")
class MyExceptionTest {

    @DisplayName("Мой тест")
    @Test
    void exceptionTest() throws MyException {
        Card card = new Card("name", 15l);
        List<String> list = Arrays.asList("one", "two");
        boolean bol = list.contains("one");
        System.out.println(bol);

        try{
            card.setName("");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

}