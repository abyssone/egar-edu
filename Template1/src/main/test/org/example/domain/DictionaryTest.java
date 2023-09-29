package org.example.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryTest {

    @Test
    void test() {
        Dictionary doc = new Dictionary();
        List<Document> list = doc.getList();

        Map<Integer, Document> map = list.stream().collect(Collectors.toMap(item -> item.code, item -> item));

        assertEquals("Паспорт", map.get(2).name);
    }

}