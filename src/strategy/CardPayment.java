package strategy;

public class CardPayment implements PaymentStrategy{
    private String cardNumber;
    private String cardHolderName;

    public CardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Payment Mode: Card Payment. Paid amount: " + amount + " by card number: " + cardNumber + " of card holder: " + cardHolderName);
    }
}
