package org.koreait.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BoardStat {
    @Scheduled(fixedRate = 5000)
    public void makeStat() {
        System.out.println("5초마다 실행");
    }
}
