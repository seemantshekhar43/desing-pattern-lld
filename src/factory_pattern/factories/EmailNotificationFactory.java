package factory_pattern.factories;

import factory_pattern.products.EmailNotification;
import factory_pattern.products.Notification;

public class EmailNotificationFactory implements NotificationFactory{
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
