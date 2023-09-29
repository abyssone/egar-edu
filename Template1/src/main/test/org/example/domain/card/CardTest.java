package org.example.domain.card;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class CardTest {

    @ParameterizedTest
    @CsvFileSource(resources = "./data.csv")
    void test1(String name, String value) {
        System.out.println(name + value);
    }
}