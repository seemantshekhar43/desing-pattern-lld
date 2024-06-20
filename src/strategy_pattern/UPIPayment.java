package strategy_pattern;

public class UPIPayment implements PaymentStrategy{
    private String upiID;

    public UPIPayment(String upiID) {
        this.upiID = upiID;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Payment mode: UPI. Paid amount: " + amount + " by upi id: " + upiID);
    }
}
