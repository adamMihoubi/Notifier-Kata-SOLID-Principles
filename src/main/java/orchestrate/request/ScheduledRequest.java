package orchestrate.request;

import java.time.LocalDateTime;
import notifier.message.Message;
import notifier.user.User;

public record ScheduledRequest(User user, Message message, LocalDateTime scheduledTime)
    implements NotificationRequest {
}
