package annotations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class AnnotationsJacksonJsonProperty {
    static class Inner {
        private final String keyOne;
        private final String keyTwo;

        @JsonCreator
        public Inner(String keyOne, String keyTwo) {
            this.keyOne = keyOne;
            this.keyTwo = keyTwo;
        }

        @JsonProperty("k1")
        public String getKeyOne() {
            return this.keyOne;
        }

        @JsonProperty("k2")
        public String getKeyTwo() {
            return this.keyTwo;
        }
    }

    @JsonProperty("name")
    private String trueName;
    @JsonProperty("inner")
    private Inner inner;

    @JsonCreator
    public AnnotationsJacksonJsonProperty() {}

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
        this.inner = new Inner("hello", "world");
    }

    public static void main(String[] args) throws JsonProcessingException {
        AnnotationsJacksonJsonProperty annotationsJacksonJsonProperty = new AnnotationsJacksonJsonProperty();
        annotationsJacksonJsonProperty.setTrueName("GetUp");
        System.out.println(new ObjectMapper().writeValueAsString(annotationsJacksonJsonProperty));
    }
}
