package thread.practice;

public class Account {

    private Integer amount;

    public Account(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public Account add(Integer investmentResult) {
        return new Account(amount + investmentResult);
    }

    public boolean isAffordable(Integer investmentResult) {
        return amount > investmentResult;
    }

    public Account sub(Integer investmentResult) {
        return new Account(amount - Math.abs(investmentResult));
    }

    @Override
    public String toString() {
        return "Account{" +
                "amount=" + amount +
                '}';
    }
}
