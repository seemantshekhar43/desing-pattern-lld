package factory_pattern.factories;

import factory_pattern.products.Notification;

public interface NotificationFactory {
    Notification createNotification();
}
