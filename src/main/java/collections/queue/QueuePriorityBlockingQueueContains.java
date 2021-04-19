package collections.queue;

import java.util.Comparator;
import java.util.Objects;
import java.util.concurrent.PriorityBlockingQueue;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QueuePriorityBlockingQueueContains {
    static class Task {

        public Integer getId() {
            return id;
        }

        private Integer id;

        public Task(Integer id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "id=" + id +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Task task = (Task) o;
            return Objects.equals(id, task.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    public static void main(String[] args) {
        PriorityBlockingQueue<Task> priorityBlockingQueue = new PriorityBlockingQueue<>(8, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if (o1.getId() > o2.getId()) {
                    return 1;
                } else if (o1.getId() < o2.getId()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        Task t1 = new Task(100);
        Task t2 = new Task(77);
        Task t3 = new Task(7);

        priorityBlockingQueue.add(t1);
        priorityBlockingQueue.add(t2);
        priorityBlockingQueue.add(t3);

        log.info(String.valueOf(priorityBlockingQueue.contains(t1)));
        log.info(String.valueOf(priorityBlockingQueue.contains(t2)));
        log.info(String.valueOf(priorityBlockingQueue.contains(new Task(7))));
        log.info(String.valueOf(priorityBlockingQueue.contains(new Task(77))));
        log.info(String.valueOf(priorityBlockingQueue.contains(new Task(888))));

        while (!priorityBlockingQueue.isEmpty()) {
            Task t = priorityBlockingQueue.poll();
            log.info(t.toString());
        }
    }
}
