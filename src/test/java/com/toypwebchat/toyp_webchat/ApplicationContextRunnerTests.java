package com.toypwebchat.toyp_webchat;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.test.context.event.RecordApplicationEvents;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@EnableAsync
@Slf4j
@SpringBootTest
@RecordApplicationEvents
class ApplicationContextRunnerTests {

    private final ApplicationContextRunner runner = new ApplicationContextRunner();

    @Test
    public void happyPathSuccess() {
        AtomicBoolean sideEffectCausedByEvent = new AtomicBoolean(false);

        ObservableEffect effect = () -> sideEffectCausedByEvent.set(true);

        runner.withBean(SomeEventListener.class, effect)
                .run(
                    context -> {
                        log.info("before sideEffectCausedByEvent is : " + sideEffectCausedByEvent);
                        context.publishEvent(new SomeEvent("test publish event"));
                        Thread.sleep(3000);
                        log.info("after sideEffectCausedByEvent is : " + sideEffectCausedByEvent);
                        assertThat(sideEffectCausedByEvent.get()).isTrue();
                    });
    }

    public interface ObservableEffect {
        void effect();
    }

    @Component
    public static class SomeEventListener {

        private final ObservableEffect effect;

        public SomeEventListener(ObservableEffect effect) {
            this.effect = effect;
        }

        @Async
        @EventListener(SomeEvent.class)
        public void listen(SomeEvent event) {
            effect.effect();
            log.info("#listen event is : " + event.getMessage());
        }
    }

    public static class SomeEvent extends ApplicationEvent {
        private final String message;
        public SomeEvent(Object source) {
            super(source);
            this.message = (String) source;
        }

        public String getMessage() {
            return message;
        }
    }

}
