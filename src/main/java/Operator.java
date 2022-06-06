public class Operator {

    private Ats ats;
    private static final int TIMEWORK = 3000;

    public Operator(Ats ats) {
        this.ats = ats;
    }

    public void dataCalls() {
        while (!ats.getQueueCall().isEmpty()) {
            String phone = ats.getQueueCall().poll();
            if (phone != null) {
                System.out.printf("Оператор %s принял вызов %s\n", Thread.currentThread().getName(), phone);
                try {
                    Thread.sleep(TIMEWORK);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                break;
            }
        }
    }
}



