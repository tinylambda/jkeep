package collections.queue;


import java.util.Comparator;
import java.util.PriorityQueue;


public class QueuePriorityQueue {
    static class Task {
        private static long seq = 0;

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        private int priority;
        private String name;

        public long getSeqNo() {
            return seqNo;
        }

        public void setSeqNo(long seqNo) {
            this.seqNo = seqNo;
        }

        private long seqNo;

        private synchronized void increaseSeq() {
            seq++;
        }

        public Task(int priority, String name) {
            this.priority = priority;
            this.name = name;
            this.seqNo = seq;
            increaseSeq();
        }

        @Override
        public String toString() {
            return "Task{" +
                    "priority=" + priority +
                    ", name='" + name + '\'' +
                    ", seqNo=" + seqNo +
                    '}';
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Task> priorityQueue = new PriorityQueue(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Task t1 = (Task) o1;
                Task t2 = (Task) o2;
                int priorityOne = t1.getPriority();
                int priorityTwo = t2.getPriority();
                int result = priorityOne - priorityTwo;
                long seqDelta = t1.getSeqNo() - t2.getSeqNo();
                if (result > 0) {
                    return 1;
                } else if (result < 0) {
                    return -1;
                } else {
                    if (seqDelta > 0) {
                        return 1;
                    } else if (seqDelta < 0) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });

        priorityQueue.add(new Task(10, "task 10"));
        priorityQueue.add(new Task(3, "task 3"));
        priorityQueue.add(new Task(1, "task 1.0"));
        priorityQueue.add(new Task(1, "task 1.1"));
        priorityQueue.add(new Task(1, "task 1.2"));
        priorityQueue.add(new Task(1, "task 1.3"));
        priorityQueue.add(new Task(1, "task 1,4"));
        priorityQueue.add(new Task(1, "task 1.5"));
        priorityQueue.add(new Task(1, "task 1.6"));
        priorityQueue.add(new Task(1, "task 1.7"));
        priorityQueue.add(new Task(1, "task 1.8"));
        priorityQueue.add(new Task(1, "task 1.3"));
        priorityQueue.add(new Task(1, "task 1,4"));
        priorityQueue.add(new Task(1, "task 1.5"));
        priorityQueue.add(new Task(1, "task 1.6"));
        priorityQueue.add(new Task(1, "task 1.7"));
        priorityQueue.add(new Task(1, "task 1.8"));
        priorityQueue.add(new Task(0, "task 0"));

        System.out.println(priorityQueue.size());
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }
}
