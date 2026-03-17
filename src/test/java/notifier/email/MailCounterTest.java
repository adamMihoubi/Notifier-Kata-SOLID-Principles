package notifier.email;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import notifier.doubles.StubTimeProvider;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MailCounterTest {
    private final StubTimeProvider timeProvider = new StubTimeProvider();
    private final MailCounter mailCounter = new MailCounter(timeProvider);

    @Test
    void should_be_limited_if_it_has_been_triggered_more_than_a_hundred_time_in_an_hour() {
        final var startTime = Instant.now();
        timeProvider.setTime(startTime);

        assertThat(mailCounter.isLimited())
            .isFalse();

        var limited = false;
        for (int i = 0; i < 100; i++) {
            limited = mailCounter.isLimited();
        }
        assertThat(limited)
            .isTrue();

        timeProvider.setTime(startTime.plus(1, ChronoUnit.HOURS));

        assertThat(mailCounter.isLimited())
            .isFalse();
    }
}