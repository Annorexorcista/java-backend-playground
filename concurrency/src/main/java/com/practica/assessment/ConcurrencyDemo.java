package com.practica.assessment;

import java.util.concurrent.CompletableFuture;

public class ConcurrencyDemo {

    public static void main(String[] args) {

        System.out.println("Main thread: " +
                Thread.currentThread().getName());

        CompletableFuture<Void> task1 =
                CompletableFuture.runAsync(() -> executeTask("Task 1"));

        CompletableFuture<Void> task2 =
                CompletableFuture.runAsync(() -> executeTask("Task 2"));

        CompletableFuture.allOf(task1, task2).join();

        System.out.println("All tasks completed");
    }

    private static void executeTask(String taskName) {

        System.out.println(
                taskName + " started in: " +
                        Thread.currentThread().getName()
        );

        try {
            Thread.sleep(2000);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }

        System.out.println(
                taskName + " finished in: " +
                        Thread.currentThread().getName()
        );
    }


    //Ejemplo encadenar operaciones
//    CompletableFuture
//            .supplyAsync(() -> obtenerUsuario())
//            .thenApply(usuario -> obtenerNombre(usuario))
//            .thenAccept(nombre -> System.out.println(nombre));
}