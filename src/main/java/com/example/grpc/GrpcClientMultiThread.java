package com.example.grpc;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.example.grpc.gencode.HelloRequest;
import com.example.grpc.gencode.HelloResponse;
import com.example.grpc.gencode.HelloServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GrpcClientMultiThread {
    public static void main(String[] args) throws Exception {
        ManagedChannel channel = null;
        try {
            channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
            HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);
            HelloServiceGrpc.HelloServiceFutureStub stub2 = HelloServiceGrpc.newFutureStub(channel);

            ExecutorService executorService = Executors.newFixedThreadPool(8);
            for (int i=0; i<100; i++) {
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        HelloResponse response = stub.hello(HelloRequest.newBuilder().setFirstName("Pan").setLastName("Fei").build());
                        log.info(response.getGreeting());
                    }
                });
            }
            executorService.shutdown();
            boolean result = executorService.awaitTermination(5, TimeUnit.MINUTES);
            log.info("done with " + result);
        } finally {
            if (channel != null) {
                channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
            }
        }
    }
}
