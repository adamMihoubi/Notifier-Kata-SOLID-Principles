package notifier;

import notifier.email.EmailNotifier;
import notifier.push.PushNotifier;
import notifier.sms.SmsNotifier;
import notifier.user.Canal;

public class CanalFactory {
    private final EmailNotifier emailNotifier;
    private final PushNotifier pushNotifier;
    private final SmsNotifier smsNotifier;

    public CanalFactory(EmailNotifier emailNotifier,
                        PushNotifier pushNotifier,
                        SmsNotifier smsNotifier) {
        this.emailNotifier = emailNotifier;
        this.pushNotifier = pushNotifier;
        this.smsNotifier = smsNotifier;
    }

    public Notifier of(Canal canal) {
        return switch (canal) {
            case PUSH -> pushNotifier;
            case SMS -> smsNotifier;
            case MAIL -> emailNotifier;
        };
    }
}
