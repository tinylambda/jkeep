package process;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import lombok.extern.slf4j.Slf4j;

/**
 * Factory of process instances
 * */
@Slf4j
public class Process implements Callable<Boolean> {
    private List<String> executionMarks = new ArrayList<>();
    private List<Class<? extends Step>> processLayout = new ArrayList<>();

    public void addStep(Class<? extends Step> stepClass) {
        this.processLayout.add(stepClass);
    }

    public List<Step> newProcessInstance() {
        List<Step> processSteps = new ArrayList<>();

        for(Class<? extends Step> stepClass : processLayout) {
            try {
                Method method = stepClass.getMethod("genStep");
                Step step = (Step) method.invoke(stepClass.newInstance());
                processSteps.add(step);
            } catch (NoSuchMethodException exception) {
                log.error("no method to create Step instance", exception);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException exception) {
                log.error("invocation exception", exception);
            }
        }
        return processSteps;
    }

    @Override
    public Boolean call() throws Exception {
        return null;
    }

    public static void main(String[] args) {
        Process process = new Process();
        process.addStep(StepA.class);
        process.addStep(StepB.class);

        List<Step> steps = process.newProcessInstance();
        for(Step step : steps) {
            log.info(step.toString());
        }
    }
}
