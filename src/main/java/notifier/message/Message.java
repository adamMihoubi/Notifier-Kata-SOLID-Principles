package notifier.message;

public record Message(String title, String value, Receiver receiver) {
}
