package notifier.sms;

import api.sms.SmsDto;
import notifier.doubles.SpySmsSender;
import notifier.message.Message;
import notifier.message.Receiver;
import notifier.result.Result;
import notifier.result.Status;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SmsNotifierTest {
    private final SpySmsSender smsSender = new SpySmsSender();
    private final SmsNotifier smsNotifier = new SmsNotifier(smsSender);

    @Test
    void should_notify_by_sms() {
        final var result = smsNotifier.notify(
            new Message("title", "my message", new Receiver("jondoe@gmail.com", "+338574")));

        assertThat(result)
            .isEqualTo(new Result(Status.OK));
        assertThat(smsSender.getSms())
            .isEqualTo(new SmsDto("title\nmy message", "+338574"));
    }
}
