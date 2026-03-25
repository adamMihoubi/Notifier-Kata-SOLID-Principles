package orchestrate.request;

import notifier.message.Message;
import notifier.user.User;

public record ImmediateRequest(User user, Message message) implements NotificationRequest {
}
