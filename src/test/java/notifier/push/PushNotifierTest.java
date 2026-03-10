package notifier.push;

import static org.assertj.core.api.Assertions.assertThat;

import api.push.PushDto;
import notifier.doubles.SpyPushSender;
import notifier.message.Message;
import notifier.message.Receiver;
import notifier.result.Result;
import notifier.result.Status;
import org.junit.jupiter.api.Test;

class PushNotifierTest {
    private final SpyPushSender pushSender = new SpyPushSender();
    private final PushNotifier pushNotifier = new PushNotifier(pushSender);

    @Test
    void should_push_notification() {
        final var result = pushNotifier.notify(
            new Message("title", "body", new Receiver("mail@gmail.com", "+33658547")));

        assertThat(result)
            .isEqualTo(new Result(Status.OK));
        assertThat(pushSender.getPush())
            .isEqualTo(new PushDto("Push notification : updated Made", "+33658547"));
    }
}
