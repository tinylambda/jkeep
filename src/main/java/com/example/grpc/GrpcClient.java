package com.example.grpc;


import java.util.concurrent.TimeUnit;

import com.example.grpc.gencode.HelloRequest;
import com.example.grpc.gencode.HelloResponse;
import com.example.grpc.gencode.HelloServiceGrpc;
import com.google.common.util.concurrent.ListenableFuture;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) throws Exception {
        ManagedChannel channel = null;
        try {
            channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
            HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);
            HelloServiceGrpc.HelloServiceFutureStub stub2 = HelloServiceGrpc.newFutureStub(channel);

            for (int i=0; i<100; i++) {
                HelloResponse response = stub.hello(HelloRequest.newBuilder().setFirstName("Pan").setLastName("Fei").build());
                System.out.println(response);
            }
            System.out.println("done 1");

            for (int i=0; i<10; i++) {
                ListenableFuture<HelloResponse> future = stub2.hello(HelloRequest.newBuilder().setFirstName("Pan").setLastName("Fei").build());
                System.out.println(future.get());
            }
            System.out.println("done 2");
        } finally {
            if (channel != null) {
                channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
            }
        }
    }
}
