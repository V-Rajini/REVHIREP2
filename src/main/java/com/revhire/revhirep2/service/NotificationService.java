package com.revhire.revhirep2.service;

import com.revhire.revhirep2.entity.Notification;
import java.util.List;

public interface NotificationService {

    Notification createNotification(Notification notification);

    void markAsRead(Long notificationId);

    List<Notification> getUserNotifications(Long userId);
}