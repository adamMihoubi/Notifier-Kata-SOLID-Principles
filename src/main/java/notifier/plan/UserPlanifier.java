package notifier.plan;

import static notifier.result.Status.OK;

import java.time.LocalDateTime;
import notifier.message.Message;
import notifier.result.Result;
import notifier.user.User;

public class UserPlanifier {
    public Result plan(User user, Message message, LocalDateTime scheduledTime) {
        return new Result(OK);
    }
}
