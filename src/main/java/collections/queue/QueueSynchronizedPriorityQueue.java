package collections.queue;


import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QueueSynchronizedPriorityQueue {

    synchronized static <T> void addToPriorityQueueSynchronized(PriorityQueue<T> queue, T element) {
        queue.add(element);
    }

    static <T> void addToPriorityQueueNoSynchronized(PriorityQueue<T> queue, T element) {
        queue.add(element);
    }

    public static void main(String[] args) throws InterruptedException {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        for (int i=0; i<100; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    int r = new Random().nextInt();
                    addToPriorityQueueNoSynchronized(priorityQueue, r);
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
        log.info("priorityQueue size should be 100, real value is: " + priorityQueue.size());


        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>();
        ExecutorService executorService2 = Executors.newFixedThreadPool(8);
        for(int i=0; i<100; i++) {
            executorService2.submit(new Runnable() {
                @Override
                public void run() {
                    int r = new Random().nextInt();
                    addToPriorityQueueSynchronized(priorityQueue2, r);
                }
            });
        }
        executorService2.shutdown();
        executorService2.awaitTermination(1, TimeUnit.MINUTES);
        log.info("priorityQueue size should be 100, real value is: " + priorityQueue2.size());
    }
}
