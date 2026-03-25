package orchestrate;

import notifier.UserNotifier;
import notifier.plan.UserPlanifier;
import notifier.result.Result;
import orchestrate.request.NotificationRequest;

public class NotificationOrchestrator {
    private final UserNotifier userNotifier;
    private final UserPlanifier userPlanifier;

    public NotificationOrchestrator(UserNotifier userNotifier, UserPlanifier userPlanifier) {
        this.userNotifier = userNotifier;
        this.userPlanifier = userPlanifier;
    }

    public Result orchestrate(NotificationRequest immediateRequest) {
        return null;
    }
}
