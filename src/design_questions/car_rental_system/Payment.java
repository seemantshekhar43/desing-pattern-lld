package design_questions.car_rental_system;

import design_questions.car_rental_system.payment_method.PaymentStrategy;

import java.util.UUID;

public class Payment {
    private final String paymentId;
    private final  PaymentStrategy paymentStrategy;
    private final  Bill bill;

    public Payment(PaymentStrategy paymentStrategy, Bill bill) {
        this.paymentId = UUID.randomUUID().toString();
        this.paymentStrategy = paymentStrategy;
        this.bill = bill;
    }

    public void payBill(){
        this.paymentStrategy.pay(this.bill.getAmount());
        this.bill.updateBillStatus(true);
        System.out.println("Payment Successful of amount: " + bill.getAmount() + ". Bill paid Status for bill Id: "+ bill.getBillId() +" is: " + bill.isPaid());
    }

    public String getPaymentId() {
        return paymentId;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public Bill getBill() {
        return bill;
    }
}
