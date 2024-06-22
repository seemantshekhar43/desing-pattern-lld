package factory_pattern.factories;

import factory_pattern.products.EmailNotification;
import factory_pattern.products.Notification;
import factory_pattern.products.SMSNotification;

public class NotificationFactory2 {

    public static Notification getEmailNotification(){
        return new EmailNotification();
    }

    public static Notification getSMSNotification(){
        return new SMSNotification();
    }
}
