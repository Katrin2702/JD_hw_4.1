public class Main {

    public static void main(String[] args) {

        Ats ats = new Ats();
        Operator operator = new Operator(ats);
        int numberOfOperators = 10;

        new Thread(null, () -> {
            try {
                ats.calls();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "ATC").start();

        for (int i = 1; i <= numberOfOperators; i++) {
            new Thread(null, () -> operator.dataCalls(), "Operator " + i).start();
        }
    }
}
