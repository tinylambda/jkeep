package json;


import com.example.grpc.gencode.ExtraProfile;
import com.example.grpc.gencode.HelloRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.hubspot.jackson.datatype.protobuf.ProtobufModule;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JSONFromGRPC {
    public static void main(String[] args) throws JsonProcessingException {
        ExtraProfile profile = ExtraProfile.newBuilder()
                .setAge(35)
                .addAllTags(Lists.newArrayList("programmer", "father", "male"))
                .build();
        HelloRequest request = HelloRequest.newBuilder()
                .setFirstName("Pan")
                .setLastName("Felix")
                .setProfile(profile)
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.registerModule(new ProtobufModule());
        log.info("{}", request);
        log.info("{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(profile));
    }
}
