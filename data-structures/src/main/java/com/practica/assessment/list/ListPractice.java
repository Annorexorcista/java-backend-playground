package com.practica.assessment.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPractice {

    public void basicOperations() {

        List<String> products = new ArrayList<>();

        products.add("Mouse");
        products.add("Mouse");
        products.add("Mouse");
        products.add("Keyboard");
        products.add("Monitor");

        products.remove("Monitor");

        System.out.println(products.get(3));

        System.out.println(products);


        System.out.println(products.contains("Mouse"));
    }

    public void compareAccess() {

        //Cambiar ArrayList poor LinkedList y viceversa para ver los tiempos de respuesta.

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 100_000; i++) {
            numbers.add(i);
        }

        System.out.println(numbers.get(50_000));
    }
}
