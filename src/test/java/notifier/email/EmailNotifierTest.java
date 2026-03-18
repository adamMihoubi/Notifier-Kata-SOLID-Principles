package notifier.email;

import static org.assertj.core.api.Assertions.assertThat;

import api.email.EmailDto;
import java.time.Instant;
import notifier.Notifier;
import notifier.doubles.SpyEmailSender;
import notifier.doubles.SpyLogger;
import notifier.message.Message;
import notifier.message.Receiver;
import notifier.result.Result;
import notifier.result.Status;
import org.junit.jupiter.api.Test;

class EmailNotifierTest {
    private static final String MAIL_TITLE = "title";
    private static final String MAIL_BODY = "my message";
    private static final String EMAIL = "johndoe@gmail.com";
    private final SpyLogger logger = new SpyLogger();
    private final SpyEmailSender emailSender = new SpyEmailSender();
    private final Notifier emailNotifier =
        new EmailNotifier(logger, emailSender, new MailCounter(Instant::now));

    @Test
    void should_notify_by_mail() {
        final var result = emailNotifier.notify(
            new Message(MAIL_TITLE, MAIL_BODY, new Receiver(EMAIL, "+338574")));

        assertThat(result)
            .isEqualTo(new Result(Status.OK));
        assertThat(emailSender.getSent())
            .isEqualTo(new EmailDto(MAIL_TITLE, MAIL_BODY, EMAIL));
        assertThat(logger.getMessage())
            .isEqualTo("email has been sent to johndoe@gmail.com");
    }

    @Test
    void should_limit_mailing_to_undred_per_hour() {
        for (
            int i = 0; i < 100; i++
        ) {
            final var result = emailNotifier.notify(
                new Message(MAIL_TITLE, MAIL_BODY, new Receiver(EMAIL, "+338574")));

            assertThat(result)
                .isEqualTo(new Result(Status.OK));
        }

        final var callAfterLimit = emailNotifier.notify(
            new Message(MAIL_TITLE, MAIL_BODY, new Receiver(EMAIL, "+338574")));

        assertThat(callAfterLimit)
            .isEqualTo(new Result(Status.CANCELED));
    }
}
