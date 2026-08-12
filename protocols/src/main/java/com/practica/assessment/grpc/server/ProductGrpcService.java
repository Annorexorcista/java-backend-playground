package com.practica.assessment.grpc.server;

import com.practica.assessment.grpc.GetProductRequest;
import com.practica.assessment.grpc.ProductResponse;
import com.practica.assessment.grpc.ProductServiceGrpc;
import io.grpc.stub.StreamObserver;

public class ProductGrpcService extends ProductServiceGrpc.ProductServiceImplBase {

    @Override
    public void getProduct(
            GetProductRequest request,
            StreamObserver<ProductResponse> responseObserver) {

        System.out.println("Request recibida. Product ID: " + request.getId());

        ProductResponse response = ProductResponse.newBuilder()
                .setId(request.getId())
                .setName("Mouse")
                .setPrice(50.99)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
