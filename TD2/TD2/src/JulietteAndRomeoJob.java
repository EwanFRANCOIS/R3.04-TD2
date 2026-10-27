public class JulietteAndRomeoJob implements Runnable {
    private String name;
    private Account account;

    public JulietteAndRomeoJob() {
        this.name = "";
        this.account = null;
    }

    public JulietteAndRomeoJob(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void doWithdraw(int amount) throws InterruptedException {
        if (account.getBalance() >= amount) {
            System.out.println(name + " vérifie le compte : " + account.getBalance());
            Thread.sleep(500);
            account.withdraw(amount);
            System.out.println(name + " a retiré " + amount + " euro. Solde : " + account.getBalance());
        }
        else if (account.getBalance() < amount) {
            System.out.println(name + " : Solde insuffisant (" + account.getBalance() + ")");
        }
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                doWithdraw(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Account account = new Account(100);

        JulietteAndRomeoJob romeoJob = new JulietteAndRomeoJob("Romeo", account);
        JulietteAndRomeoJob julietteJob = new JulietteAndRomeoJob("Juliette", account);

        Thread romeo = new Thread(romeoJob);
        Thread juliette = new Thread(julietteJob);

        romeo.setName("Roméo");
        juliette.setName("Juliette");

        romeo.start();
        juliette.start();
    }
}
