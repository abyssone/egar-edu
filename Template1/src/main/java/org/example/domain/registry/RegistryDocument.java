package org.example.domain.registry;

import org.example.domain.input.InputObject;

public class RegistryDocument {

    String id;
    String field1;
    String field2;
    String field3;
    String field4;
    String field5;

    public RegistryDocument(String id,
                            String field1,
                            String field2,
                            String field3,
                            String field4,
                            String field5,
                            InputObject inputObject) {
        this.id = id;
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
        this.field5 = field5;
    }
}
