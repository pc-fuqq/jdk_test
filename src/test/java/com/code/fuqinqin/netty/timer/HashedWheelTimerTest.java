package com.code.fuqinqin.netty.timer;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * netty时间轮例子
 *
 * 疑问：netty的时间轮和jdk自带的Timer有何优劣势
 *
 * @author fuqinqin3
 * @date 2020-09-02
 * */
@Slf4j
public class HashedWheelTimerTest {
    private HashedWheelTimer timer = new HashedWheelTimer(
            new NameThreadFactory(),
            1000,
            TimeUnit.MILLISECONDS,
            5);

    @Test
    public void test(){
        start(10);

//        new Timer().schedule(new java.util.TimerTask() {
//            @Override
//            public void run() {
//                log.info("java.util.Timer...");
//            }
//        }, 1000, 2000);

        synchronized (HashedWheelTimerTest.class){
            try {
                HashedWheelTimerTest.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void start(int count){
        for (int i = 0; i < count; i++) {
            final int index = i;
            timer.newTimeout(new TimerTask() {
                int count = 0;
                @Override
                public void run(Timeout timeout) throws Exception {
                    log.info("{}-时间轮执行了{}", index, count++);
                    timer.newTimeout(this, index*1000, TimeUnit.MILLISECONDS);
                }
            }, 2 * 1000, TimeUnit.MILLISECONDS);
        }
    }
}
