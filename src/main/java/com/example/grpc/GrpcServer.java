package com.example.grpc;


import java.util.concurrent.Executors;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GrpcServer {
    public static void main(String[] args) throws Exception {
        int port = 50051;
        final Server server = ServerBuilder.forPort(port)
                .executor(Executors.newFixedThreadPool(8))
                .addService(new HelloServiceImpl()).build().start();
        log.info("server started, listening on " + port);
        server.awaitTermination();
    }
}
