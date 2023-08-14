package org.koreait.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BoardStat {
    @Scheduled(cron = "0 0 1 * * *")
    public void makeStat() {
        System.out.println("매일 새벽 1시 정각마다 실행");
    }
}
