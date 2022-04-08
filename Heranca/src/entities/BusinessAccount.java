package entities;

public class BusinessAccount extends Account {

    private double loanLimit;

    public BusinessAccount() {
    }

    public BusinessAccount(Integer number, String holder, Double balance, double loanLimit) {
        super(number, holder, balance);
        this.loanLimit = loanLimit;
    }

    public double getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(double loanLimit) {
        this.loanLimit = loanLimit;
    }

    //entidade de empréstimo
    public void loan (double amount){
        if ( amount <= loanLimit){
            balance += amount;
        }
    }

    @Override
    public void withdraw(double amount) {
        this.balance -= amount;
    }
}
