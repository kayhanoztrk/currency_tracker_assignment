package com.currencytracker.assignment.currencytracker.scheduler;

import com.currencytracker.assignment.currencytracker.entity.Alert;
import com.currencytracker.assignment.currencytracker.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class SchedulerTask {

    private Logger logger = LoggerFactory.getLogger(SchedulerTask.class);
    private final NotificationService notificationService;

    public SchedulerTask(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    @Scheduled(fixedRate = 30000)
    public void job() {
        List<Alert> alertList = notificationService.logNotification();
        if (!alertList.isEmpty()) {
            for (Alert alert : alertList) {
                logger.info("targetPrice Reached" + alert);
                notificationService.notifiedNotification(alert);
            }
        }

        logger.info("Job Current Time" + new Date());
    }
}
