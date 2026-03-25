package notifier;

import java.util.Map;
import java.util.Optional;
import notifier.user.Canal;

public class CanalFactory {
    private final Map<Canal, Notifier> notifiers;

    public CanalFactory(Map<Canal, Notifier> notifiers) {
        this.notifiers = notifiers;
    }

    public Notifier of(Canal canal) {
        return Optional.ofNullable(notifiers.get(canal))
            .orElseThrow(() -> new IllegalArgumentException("No notifier found for canal " + canal));
    }
}
