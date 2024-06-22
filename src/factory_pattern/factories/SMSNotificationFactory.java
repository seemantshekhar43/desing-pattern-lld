package factory_pattern.factories;

import factory_pattern.products.Notification;
import factory_pattern.products.SMSNotification;

public class SMSNotificationFactory implements NotificationFactory{
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}
