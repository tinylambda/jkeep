package com.example.grpc;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.example.grpc.gencode.HelloRequest;
import com.example.grpc.gencode.HelloResponse;
import com.example.grpc.gencode.HelloServiceGrpc;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
    private int count = 0;
    private int randomInt = new Random().nextInt(1000);
    ExecutorService executorService = Executors.newFixedThreadPool(8);

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
//        synchronized (this) {
            count = count + 1;
            log.info("processing: " + count);
//        }
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
                .append(" threadId ")
                .append(Thread.currentThread().getId())
                .append(" -> ")
                .append(executorService.hashCode())
                .toString();
        HelloResponse response = HelloResponse.newBuilder().setGreeting(greeting).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
