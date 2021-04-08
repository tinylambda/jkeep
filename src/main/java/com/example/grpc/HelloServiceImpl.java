package com.example.grpc;

import java.util.Random;

import com.example.grpc.gencode.HelloRequest;
import com.example.grpc.gencode.HelloResponse;
import com.example.grpc.gencode.HelloServiceGrpc;

import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
    private int count = 0;
    private int randomInt = new Random().nextInt(1000);

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        synchronized (this) {
            count += 1;
        }
        String greeting = new StringBuilder().append("Hello, ")
                .append(request.getFirstName())
                .append(" ")
                .append(request.getLastName())
                .append(" -> ")
                .append(count)
                .append(" -> ")
                .append(randomInt)
                .append(" -> ")
                .append(this.hashCode())
                .toString();
        HelloResponse response = HelloResponse.newBuilder().setGreeting(greeting).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
