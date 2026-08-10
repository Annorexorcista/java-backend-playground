package com.practica.assessment.map;

import java.util.HashMap;
import java.util.Map;

public class MapPractice {

    Map<Long, String> products = new HashMap<>();

    public void basicOperations() {

        Map<Long, String> products = new HashMap<>();

        products.put(1L, "Mouse");
        products.put(2L, "Keyboard");
        products.put(3L, "Monitor");

        System.out.println(products.get(2L));

        System.out.println(products.containsKey(3L));

        products.remove(1L);

        System.out.println(products);
    }
}

