package notifier.email;

import notifier.Notifier;
import notifier.message.Message;
import notifier.message.Receiver;
import notifier.result.Result;
import notifier.result.Status;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EmailNotifierTest {
    private static String capturedMessage;
    private final Notifier emailNotifier = new EmailNotifier(message -> capturedMessage = message);

    @Test
    void should_notify_by_mail() {
        final var result = emailNotifier.notify(
            new Message("title", "my message", new Receiver("johndoe@gmail.com")));

        assertThat(result)
            .isEqualTo(new Result(Status.OK));
    }

    @Test
    void should_log_data_emailed() {
        emailNotifier.notify(
            new Message("title", "my message", new Receiver("johndoe@gmail.com")));

        assertThat(capturedMessage)
            .isEqualTo("email has been sent to johndoe@gmail.com");
    }
}
