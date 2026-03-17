package notifier;

import static org.assertj.core.api.Assertions.assertThat;

import notifier.doubles.SpyCanalFactory;
import notifier.message.Message;
import notifier.message.Receiver;
import notifier.result.Result;
import notifier.result.Status;
import notifier.user.Canal;
import notifier.user.User;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class UserNotifierTest {
    private final SpyCanalFactory canalFactory = new SpyCanalFactory();
    private final UserNotifier userNotifier = new UserNotifier(canalFactory);

    @ParameterizedTest
    @EnumSource(Canal.class)
    void should_notify_user_with_depending_on_his_favorite_canal(Canal canal) {
        final var result =
            userNotifier.notify(new User(canal), new Message("my title", "my message",
                new Receiver("johnDoe@gmail.com", "+6632547")));

        assertThat(result)
            .isEqualTo(new Result(Status.OK));
        assertThat(canalFactory.isNotifierCalledTypeOf(canal))
            .isTrue();
    }
}
