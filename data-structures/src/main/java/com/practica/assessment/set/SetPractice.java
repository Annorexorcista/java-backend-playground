package com.practica.assessment.set;

import java.util.HashSet;
import java.util.Set;

public class SetPractice {

    public void basicOperations() {

        Set<String> products = new HashSet<>();

        products.add("Mouse");
        products.add("Keyboard");
        products.add("Mouse");
        products.add("Monitor");

        System.out.println(products.size());
        System.out.println(products.contains("Mouse"));
        products.remove("Keyboard");

        System.out.println(products);
    }
}
