package notifier.doubles;

import java.time.Instant;
import java.util.Map;
import java.util.Optional;
import notifier.CanalFactory;
import notifier.Notifier;
import notifier.email.EmailNotifier;
import notifier.email.MailCounter;
import notifier.push.PushNotifier;
import notifier.sms.SmsNotifier;
import notifier.user.Canal;

public class SpyCanalFactory extends CanalFactory {
    private static final Map<Canal, Class<? extends Notifier>> instances =
        Map.of(Canal.MAIL, EmailNotifier.class,
            Canal.PUSH, PushNotifier.class,
            Canal.SMS, SmsNotifier.class);
    private static final Map<Canal, Notifier> notifiers =
        Map.of(Canal.MAIL, new EmailNotifier(_ -> {
            }, _ -> {
            }, new MailCounter(Instant::now)),
            Canal.PUSH, new PushNotifier(_ -> {
            }), Canal.SMS, new SmsNotifier(_ -> {
            }));

    public SpyCanalFactory() {
        super(notifiers);
    }

    public boolean isNotifierCalledTypeOf(Canal canal) {
        return Optional.ofNullable(notifiers.get(canal))
            .map(notifier -> instances.get(canal).isInstance(notifier))
            .orElse(false);
    }
}
