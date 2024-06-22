package factory_pattern;

import factory_pattern.factories.EmailNotificationFactory;
import factory_pattern.factories.NotificationFactory;
import factory_pattern.factories.NotificationFactory2;
import factory_pattern.factories.SMSNotificationFactory;
import factory_pattern.products.Notification;

public class Main {

    /*
    Problem Statement:

    Imagine you are developing a notification system that can send notifications via different channels such as
    email, SMS, and push notifications. Depending on the configuration or user preference, you might need to create
    different types of notification objects.

     */
    public static void main(String[] args) {

        NotificationFactory emailNotificationFactory = new EmailNotificationFactory();
        Notification emailNotification = emailNotificationFactory.createNotification();
        emailNotification.notifyUser();

        NotificationFactory smsNotificationFactory = new SMSNotificationFactory();
        Notification smsNotification = smsNotificationFactory.createNotification();
        smsNotification.notifyUser();

        // Different way to implement the same thing without creating concrete factories for each Notification.

        Notification emailNotification1 = NotificationFactory2.getEmailNotification();
        emailNotification1.notifyUser();


        Notification smsNotification1 = NotificationFactory2.getSMSNotification();
        smsNotification1.notifyUser();

    }
    /*
    Advantages:
    1. Open/Closed Principle: You can extend the behavior of objects without modifying their code.
    2. Promotes loose coupling.
     */
}
