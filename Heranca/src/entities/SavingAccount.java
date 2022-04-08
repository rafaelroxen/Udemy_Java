package entities;

public class SavingAccount extends Account{

  private Double interestRate;

  //Interest rate em português significa taxa de Juros, Balance significa saldo.
    public SavingAccount() {
    }

    public SavingAccount(Integer number, String holder, Double balance, Double interestRate) {
        super(number, holder, balance);
        this.interestRate = interestRate;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    //Interest rate em português significa taxa de Juros, Balance significa saldo.
    public void updateBalance(){
        balance += balance * interestRate;
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
    }
}
