package me.jimmy.advanced.trace.treadlocal;

import lombok.extern.slf4j.Slf4j;
import me.jimmy.advanced.trace.treadlocal.code.FieldService;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTest {

    private FieldService sut = new FieldService();

    @Test
    void filed() {
        log.info("main start");
        Runnable userA = () -> sut.logic("userA");

        Runnable userB = () -> sut.logic("userB");

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
        // sleep(2000); // 동시성 문제 발생 X
        sleep(100); // 동시성 문제 발생 O
        threadB.start();
        sleep(3000);
        log.info("main exit");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
