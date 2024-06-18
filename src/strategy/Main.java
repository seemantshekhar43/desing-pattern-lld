package strategy;

public class Main {
    /*
    Problem statement:
        Imagine you are developing an e-commerce application. This application needs to support multiple payment methods such as credit cards, PayPal, and cryptocurrency.
        Each payment method has a different way of processing payments, and you want to design the system in a way that is easy to extend with new payment methods
        without modifying the existing code.
     */

    public static void main(String[] args) {
        Cart cart = new Cart();

        //Making payment using first payment strategy: UPI
        cart.setPaymentStrategy(new UPIPayment("qwerty@upi"));
        cart.checkout(200.50);


        //Making payment using second payment strategy: Card
        cart.setPaymentStrategy(new CardPayment("1234123412341234", "holder"));
        cart.checkout(100.00);


        /* Advantages:

        1. Flexibility: Easily switch between different algorithms (payment methods) at runtime.
        2. Maintainability: Adding new payment methods doesn't require changing existing code, reducing the risk of introducing bugs.
        3. Single Responsibility Principle: Each payment strategy class has a single responsibility, making the code easier to understand and maintain.
        4. Open/Closed Principle: The system is open for extension (adding new payment methods) but closed for modification (existing code remains unchanged).

         */
    }
}
