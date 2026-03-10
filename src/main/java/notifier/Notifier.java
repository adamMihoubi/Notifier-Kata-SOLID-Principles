package notifier;

import notifier.message.Message;
import notifier.result.Result;

public interface Notifier {
    Result notify(Message message);
}
