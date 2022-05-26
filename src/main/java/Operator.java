public class Operator {

    private Ats ats;
    private static final int timeWork = 3000;

    public Operator(Ats ats) {
        this.ats = ats;
    }

    public void dataCalls() {
        while (!ats.getQueueCall().isEmpty()) {
            System.out.printf("Оператор %s принял вызов %s\n", Thread.currentThread().getName(),
                    ats.getQueueCall().poll());
            try {
                Thread.sleep(timeWork);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
