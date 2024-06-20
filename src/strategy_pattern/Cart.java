package strategy_pattern;

public class Cart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(double amount){
        this.paymentStrategy.pay(amount);
    }
}
