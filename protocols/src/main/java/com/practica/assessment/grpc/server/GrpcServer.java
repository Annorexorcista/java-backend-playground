package com.practica.assessment.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {

    private final Server server;

    public GrpcServer(int port) {
        this.server = ServerBuilder
                .forPort(port)
                .addService(new ProductGrpcService())
                .build();
    }

    public void start() throws IOException {
        server.start();

        System.out.println(
                "gRPC server iniciado en puerto: " + server.getPort()
        );

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Apagando servidor gRPC...");
            GrpcServer.this.stop();
        }));
    }

    public void stop() {
        server.shutdown();
    }

    public void awaitTermination() throws InterruptedException {
        server.awaitTermination();
    }

    public static void main(String[] args)
            throws IOException, InterruptedException {

        GrpcServer server = new GrpcServer(9090);

        server.start();
        server.awaitTermination();
    }
}
