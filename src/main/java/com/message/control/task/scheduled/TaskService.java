package com.message.control.task.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableAsync
public class TaskService {

    @Async
    public void runTask(int id) {
        try {
            log.debug("Running runTask Asynchronously for id {}", id);
            Thread.sleep(2000);
            log.debug("Async complete for id {}", id);
        } catch (Exception e) {
            log.error("Exception in runTask for id {}: {}", id, e);
        }
    }
}
