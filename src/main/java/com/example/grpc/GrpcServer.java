package com.example.grpc;


import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {
    public static void main(String[] args) throws Exception {
        int port = 50051;
        final Server server = ServerBuilder.forPort(port)
                .addService(new HelloServiceImpl()).build().start();
        System.out.println("server started, listening on " + port);
        server.awaitTermination();
    }
}
