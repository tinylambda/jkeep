package log;

import com.example.grpc.gencode.HelloRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogPB {
    public static void main(String[] args) {
        HelloRequest helloRequest = HelloRequest.newBuilder()
                .setFirstName("Pan")
                .setLastName("Felix")
                .build();
        log.info("{}", helloRequest);
    }
}
