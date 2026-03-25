package orchestrate.request;

public sealed interface NotificationRequest permits ImmediateRequest, ScheduledRequest {
}
