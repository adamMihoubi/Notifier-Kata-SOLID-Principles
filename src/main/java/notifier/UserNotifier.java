package notifier;

import notifier.message.Message;
import notifier.result.Result;
import notifier.user.User;

public class UserNotifier {
    private final CanalFactory canalFactory;

    public UserNotifier(CanalFactory canalFactory) {
        this.canalFactory = canalFactory;
    }

    public Result notify(User user, Message message) {
        return canalFactory.of(user.favoriteCanal()).notify(message);
    }
}
