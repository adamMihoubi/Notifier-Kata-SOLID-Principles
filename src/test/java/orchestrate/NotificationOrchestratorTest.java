package orchestrate;

import static notifier.result.Status.OK;
import static org.assertj.core.api.Assertions.assertThat;

import notifier.message.Message;
import notifier.message.Receiver;
import notifier.result.Result;
import notifier.user.Canal;
import notifier.user.User;
import orchestrate.doubles.SpyUserNotifier;
import orchestrate.doubles.SpyUserPlanifier;
import orchestrate.request.ImmediateRequest;
import org.junit.jupiter.api.Test;

class NotificationOrchestratorTest {
    private final NotificationOrchestrator notificationOrchestrator =
        new NotificationOrchestrator(new SpyUserNotifier(), new SpyUserPlanifier());

    @Test
    void should_orchestrate_notifications() {
        final var result =
            notificationOrchestrator.orchestrate(new ImmediateRequest(new User(Canal.MAIL),
                new Message("my title", "my message", new Receiver("mail", "tel"))));

        assertThat(result)
            .isEqualTo(new Result(OK));
    }
}