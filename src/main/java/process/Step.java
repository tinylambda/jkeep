package process;


import java.lang.reflect.Constructor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Step {
    private String name;

    Step() {
        this.name = getClass().getName();
    }

    @Override
    public String toString() {
        return "Step{" +
                "name='" + name + '\'' +
                '}';
    }

    public Step genStep() {
        try {
            Constructor<? extends Step> constructor = getClass().getDeclaredConstructor();
            Step step = constructor.newInstance();
            return step;
        } catch (Exception exception) {
            log.error("cannot create subclass from parent class", exception);
        }
        return null;
    }
}
