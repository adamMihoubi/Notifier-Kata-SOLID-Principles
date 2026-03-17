package notifier.doubles;

import java.time.Instant;
import notifier.time.TimeProvider;

public class StubTimeProvider implements TimeProvider {
    private Instant instant;

    @Override
    public Instant now() {
        return instant;
    }

    public void setTime(Instant instant) {
        this.instant = instant;
    }
}
