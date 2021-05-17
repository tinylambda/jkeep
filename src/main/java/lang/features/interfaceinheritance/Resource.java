package lang.features.interfaceinheritance;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Resource {
    private String name;

    public Resource(String name) {
        this.name = name;
    }
}
