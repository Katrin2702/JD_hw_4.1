import java.util.Random;
import java.util.concurrent.*;

public class Ats {
    private static final int numberOfCalls = 60;
    private static final int numberOfCycles = 3;
    private ConcurrentLinkedQueue<String> queueCalls = new ConcurrentLinkedQueue<>();
    private static final int phoneLenght = 10;
    private static final int timeOut = 1000;

    Random random = new Random();

    public void calls() throws InterruptedException {
        for (int j = 0; j < numberOfCycles; j++) {
            for (int i = 0; i < numberOfCalls; i++) {
                queueCalls.add(newCall());
            }
            Thread.sleep(timeOut);
        }
    }

    public ConcurrentLinkedQueue<String> getQueueCall() {
        return queueCalls;
    }

    public String newCall() {
        StringBuilder sb = new StringBuilder();
        sb.append("+7");
        for (int i = 0; i < phoneLenght; i++) {
            sb.append(random.nextInt(9));
        }
        return sb.toString();
    }

}
