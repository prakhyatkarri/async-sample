package com.message.control.task.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Slf4j
@Service
@EnableScheduling
public class ScheduleService {

    @Autowired
    private TaskService taskService;

    @Scheduled(fixedRateString = "10000")
    public void runTaskPerSchedule() throws InterruptedException {
        log.debug("Running per Schedule");
        IntStream.rangeClosed(0, 10).parallel().forEach(id -> taskService.runTask(id));
        log.debug("Scheduled task complete");
        log.debug("###############");
    }
}
