package banking;

public class Account {

    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getAccount() {
        return balance;
    }

    /*public void deposit(double increase) {
        this.balance = this.balance + increase;
    }

    public void withdraw(double decrease) {
        if (this.balance - decrease < 0) {
            System.out.println("account doesn't have enough money");
        } else {
            this.balance = this.balance - decrease;
        }
    }*/
    public boolean deposit(double increase) {
        try {
            this.balance = this.balance + increase;
        } catch (ArithmeticException ex) {
            throw ex;
        }
        return true;
    }

    public boolean withdraw(double decrease) {
        if (this.balance - decrease < 0) {
            System.out.println("account doesn't have enough money");
            return false;
        } else {
            this.balance = this.balance - decrease;
            return true;
        }
    }
}
