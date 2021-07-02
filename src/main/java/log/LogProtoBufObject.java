package log;

import com.example.grpc.gencode.ExtraProfile;
import com.example.grpc.gencode.HelloRequest;
import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogProtoBufObject {
    public static void main(String[] args) {
        ExtraProfile profile = ExtraProfile.newBuilder()
                .setAge(35)
                .addAllTags(Lists.newArrayList("programmer", "father", "male"))
                .build();
        HelloRequest request = HelloRequest.newBuilder()
                .setFirstName("Pan")
                .setLastName("Felix")
                .setProfile(profile)
                .build();
        log.info("{}", request);
    }
}
