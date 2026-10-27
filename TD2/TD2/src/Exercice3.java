public class Exercice3 {
    public static void main(String[] args) {
        new Thread(new letters()).start();
        new Thread(new numbers()).start();
        System.out.print('\n');
    }
}

class letters implements Runnable {
    @Override
    public void run() {
        for (char c = 'a'; c <='z'; c++) {
            System.out.print(c);
            System.out.print(" | ");
        }
    }
}

class numbers implements Runnable {
    @Override
    public void run() {
        for (int n = 1; n <= 26; n++) {
            System.out.print(n);
            System.out.print(" | ");
        }
    }
}