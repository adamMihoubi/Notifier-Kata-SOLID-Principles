package notifier.doubles;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;
import notifier.CanalFactory;
import notifier.Notifier;
import notifier.email.EmailNotifier;
import notifier.push.PushNotifier;
import notifier.sms.SmsNotifier;
import notifier.user.Canal;

public class SpyCanalFactory extends CanalFactory {
    private static final Map<Canal, Class<? extends Notifier>> instances =
        Map.of(Canal.MAIL, EmailNotifier.class,
            Canal.PUSH, PushNotifier.class,
            Canal.SMS, SmsNotifier.class);
    private final Map<Canal, Notifier> notifiers = new EnumMap<>(Canal.class);

    public SpyCanalFactory() {
        super(new EmailNotifier(_ -> {
        }, _ -> {
        }), new PushNotifier(_ -> {
        }), new SmsNotifier(_ -> {
        }));
    }

    @Override
    public Notifier of(Canal canal) {
        final var notifier = super.of(canal);
        notifiers.put(canal, notifier);
        return notifier;
    }

    public boolean isNotifierCalledTypeOf(Canal canal) {
        return Optional.ofNullable(notifiers.get(canal))
            .map(notifier -> instances.get(canal).isInstance(notifier))
            .orElse(false);
    }
}
