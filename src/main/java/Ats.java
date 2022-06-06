import java.util.Random;
import java.util.concurrent.*;

public class Ats {
    private static final int NUMBEROFCALLS = 60;
    private static final int NUMBEROFCYCLES = 3;
    private ConcurrentLinkedQueue<String> queueCalls = new ConcurrentLinkedQueue<>();
    private static final int PHONELENGHT = 10;
    private static final int TIMEOUT = 1000;

    Random random = new Random();

    public void calls() throws InterruptedException {
        for (int j = 0; j < NUMBEROFCYCLES; j++) {
            for (int i = 0; i < NUMBEROFCALLS; i++) {
                queueCalls.add(newCall());
            }
            Thread.sleep(TIMEOUT);
        }
    }

    public ConcurrentLinkedQueue<String> getQueueCall() {
        return queueCalls;
    }

    public String newCall() {
        StringBuilder sb = new StringBuilder();
        sb.append("+7");
        for (int i = 0; i < PHONELENGHT; i++) {
            sb.append(random.nextInt(9));
        }
        return sb.toString();
    }

}
