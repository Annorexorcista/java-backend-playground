package com.practica.assessment;

import com.practica.assessment.list.ListPractice;
import com.practica.assessment.map.MapPractice;
import com.practica.assessment.set.SetPractice;

public class Main {

    public static void main(String[] args) {

        ListPractice practice = new ListPractice();
        SetPractice practice2 = new SetPractice();
        MapPractice practice3 = new MapPractice();


        //List Practice
//        practice.basicOperations();
//        practice.compareAccess();

        //Set Practice
//        practice2.basicOperations();

        //Map Practice
        practice3.basicOperations();


    }
}