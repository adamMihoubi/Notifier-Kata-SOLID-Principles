package orchestrate.doubles;

import java.time.LocalDateTime;
import notifier.message.Message;
import notifier.plan.UserPlanifier;
import notifier.result.Result;
import notifier.result.Status;
import notifier.user.User;

public class SpyUserPlanifier extends UserPlanifier {
    @Override
    public Result plan(User user, Message message, LocalDateTime scheduledTime) {
        return new Result(Status.PLANNED);
    }
}
