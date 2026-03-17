package notifier;

import notifier.message.Message;
import notifier.result.Result;
import notifier.user.User;

public class UserNotifier {
    private final CanalFactory notifier;

    public UserNotifier(CanalFactory notifier) {
        this.notifier = notifier;
    }

    public Result notify(User user, Message message) {
        return notifier.of(user.favoriteCanal()).notify(message);
    }
}
