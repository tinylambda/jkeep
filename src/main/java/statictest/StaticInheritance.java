package statictest;

import static com.google.common.collect.Sets.newHashSet;

import java.util.Set;

public class StaticInheritance {
    private static final Set<String> EXCLUDE_PRIVATE = newHashSet("m", "n");
    protected static final Set<String> EXCLUDE = newHashSet("hello", "world");
    public static final Set<String> EXCLUDE_PUBLIC = newHashSet("a", "b");
}
