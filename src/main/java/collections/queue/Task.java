package collections.queue;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class Task {
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

    public static void main(String[] args) {
        Task t1 = new Task(1, "t1");
        log.info("" + t1.getSeqNo() + ": " + Task.seq);
        Task t2 = new Task(1, "t2");
        log.info("" + t1.getSeqNo() + ": " + Task.seq);
        log.info("" + t2.getSeqNo() + ": " + Task.seq);
    }

}
