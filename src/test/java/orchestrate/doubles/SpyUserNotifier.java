package orchestrate.doubles;

import notifier.UserNotifier;
import notifier.message.Message;
import notifier.result.Result;
import notifier.result.Status;
import notifier.user.User;

public class SpyUserNotifier extends UserNotifier {
    public SpyUserNotifier() {
        super(null);
    }

    @Override
    public Result notify(User user, Message message) {
        return new Result(Status.OK);
    }
}
