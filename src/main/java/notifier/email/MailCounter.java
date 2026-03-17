package notifier.email;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;
import notifier.time.TimeProvider;

public class MailCounter {
    private static final int COUNT_LIMIT = 100;
    private static final int ONE_HOUR = 1;
    private final AtomicInteger counter = new AtomicInteger(0);
    private final TimeProvider timeProvider;
    private Instant windowStart;

    public MailCounter(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    boolean isLimited() {
        final var now = timeProvider.now();
        if (windowStart == null || Duration.between(windowStart, now).toHours() >= ONE_HOUR) {
            windowStart = now;
            counter.set(0);
        }
        final var triggered = counter.incrementAndGet();
        return triggered > COUNT_LIMIT;
    }
}
