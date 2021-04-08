package com.example.grpc;


import java.util.concurrent.TimeUnit;

import com.example.grpc.gencode.HelloRequest;
import com.example.grpc.gencode.HelloResponse;
import com.example.grpc.gencode.HelloServiceGrpc;
import com.google.common.util.concurrent.ListenableFuture;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GrpcClient {
    public static void main(String[] args) throws Exception {
        ManagedChannel channel = null;
        try {
            channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
            HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);
            HelloServiceGrpc.HelloServiceFutureStub stub2 = HelloServiceGrpc.newFutureStub(channel);

            for (int i=0; i<100; i++) {
                HelloResponse response = stub.hello(HelloRequest.newBuilder().setFirstName("Pan").setLastName("Fei").build());
                log.info(response.getGreeting());
            }

            log.info("done");
        } finally {
            if (channel != null) {
                channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
            }
        }
    }
}
