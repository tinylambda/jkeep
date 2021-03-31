package process;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProcessManager {
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(8);
    private static final PriorityQueue<Process> runningProcesses = new PriorityQueue<>(new Comparator<Process>() {
        @Override
        public int compare(Process o1, Process o2) {
            return 0;
        }
    });

}
