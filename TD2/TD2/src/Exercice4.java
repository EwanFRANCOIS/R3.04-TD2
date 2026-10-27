public class Exercice4 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new work());
        Thread t2 = new Thread(new work());
        Thread t3 = new Thread(new work());

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}

class work implements  Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            int randomNumber = (int) (Math.random() * 201);
            try {
                Thread.sleep(randomNumber);
                System.out.println("Nom du Thread : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}