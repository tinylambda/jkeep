package collections.queue;


import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.jetbrains.annotations.NotNull;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QueueDelayQueue {

    @Data
    static class Message implements Delayed {
        private int id;
        private String body;
        private long executeTime;

        public Message(int id, String body, long delayTime) {
            this.id = id;
            this.body = body;
            this.executeTime = TimeUnit.NANOSECONDS.convert(delayTime, TimeUnit.MILLISECONDS) + System.nanoTime();
        }

        @Override
        public long getDelay(@NotNull TimeUnit unit) {
            return unit.convert(this.executeTime - System.nanoTime(), TimeUnit.NANOSECONDS);
        }

        @Override
        public int compareTo(@NotNull Delayed o) {
            Message msg = (Message) o;
            Integer thisId = this.id;
            Integer thatId = msg.id;
            return thisId.compareTo(thatId);
        }
    }

    static class Consumer implements Runnable {
        private DelayQueue<Message> queue;

        public Consumer(DelayQueue<Message> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Message take = queue.take();
                    log.info("consumer id: {}, body: {}", take.getId(), take.getBody());
                } catch (InterruptedException e) {
                    log.error("", e);
                }
            }
        }
    }

    public static void main(String[] args) {
        DelayQueue<Message> queue = new DelayQueue<>();
        Message m1 = new Message(1, "world", 3000);
        Message m2 = new Message(2, "hello", 10000);
        queue.offer(m2);
        queue.offer(m1);

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(new Consumer(queue));
        executorService.shutdown();
    }
}
