package playground.dfa;

import static com.google.common.collect.Maps.newHashMap;

import java.util.Map;
import java.util.function.Supplier;

public enum State {
    INIT,
    DATA_SYNCED,
    DATA_ATTACHED,
    ;
    private Map<String, String> context;

    State() {
    }
}
