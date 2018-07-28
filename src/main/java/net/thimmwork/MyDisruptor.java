package net.thimmwork;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.Executors;

class MyDisruptor extends Disruptor<EventWrapper> {
    MyDisruptor() {
        super(EventWrapper::new, 1024, Executors.defaultThreadFactory(), ProducerType.SINGLE, new SleepingWaitStrategy());
        init();
    }

    private void init() {
        handleEventsWith(new Handle1())
                .and(
                        handleEventsWith(new Process1(), new Process2())
                ).then(new HandleJoin())
        .then(new Clean());
    }

    private class Handle1 implements EventHandler<EventWrapper> {
        public void onEvent(EventWrapper event, long sequence, boolean endOfBatch) {
        }
    }


    private class Process1 implements EventHandler<EventWrapper> {
        public void onEvent(EventWrapper event, long sequence, boolean endOfBatch) {
        }
    }

    private class Process2 implements EventHandler<EventWrapper> {
        public void onEvent(EventWrapper event, long sequence, boolean endOfBatch) {
        }
    }

    private class HandleJoin implements EventHandler<EventWrapper> {
        public void onEvent(EventWrapper event, long sequence, boolean endOfBatch) {
        }
    }

    private class Clean implements EventHandler<EventWrapper> {
        public void onEvent(EventWrapper event, long sequence, boolean endOfBatch) {
        }
    }
}
