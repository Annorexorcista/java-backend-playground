package com.practica.assessment.grpc.client;

import com.practica.assessment.grpc.GetProductRequest;
import com.practica.assessment.grpc.ProductResponse;
import com.practica.assessment.grpc.ProductServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ProductGrpcClient {

    private final ManagedChannel channel;
    private final ProductServiceGrpc.ProductServiceBlockingStub stub;

    public ProductGrpcClient(String host, int port) {
        this.channel = ManagedChannelBuilder
                .forAddress(host, port)
                .usePlaintext()
                .build();

        this.stub = ProductServiceGrpc.newBlockingStub(channel);
    }

    public ProductResponse getProduct(long productId) {

        GetProductRequest request = GetProductRequest.newBuilder()
                .setId(productId)
                .build();

        return stub.getProduct(request);
    }

    public void shutdown() {
        channel.shutdown();
    }

    public static void main(String[] args) {

        ProductGrpcClient client =
                new ProductGrpcClient("localhost", 9090);

        try {
            ProductResponse response = client.getProduct(1L);

            System.out.println("Producto recibido:");
            System.out.println("ID: " + response.getId());
            System.out.println("Nombre: " + response.getName());
            System.out.println("Precio: " + response.getPrice());

        } finally {
            client.shutdown();
        }
    }
}
