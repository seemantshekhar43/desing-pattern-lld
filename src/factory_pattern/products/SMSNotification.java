package factory_pattern.products;

public class SMSNotification implements Notification{

    @Override
    public void notifyUser() {
        System.out.println("Sending SMS Notification");
    }
}
