package com.toypwebchat.toyp_webchat;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.test.context.event.RecordApplicationEvents;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


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
                        context.publishEvent(new SomeEvent());
                        log.info("sideEffectCausedByEvent is : " + sideEffectCausedByEvent);
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

        @EventListener(SomeEvent.class)
        public void listen() {
            effect.effect();
        }
    }

    public static class SomeEvent {}

}
