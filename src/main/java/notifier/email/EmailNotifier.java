package notifier.email;

import notifier.Notifier;
import notifier.logger.Logger;
import notifier.message.Message;
import notifier.result.Result;
import notifier.result.Status;

public class EmailNotifier implements Notifier {
    private final Logger logger;

    public EmailNotifier(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Result notify(Message message) {
        logger.log(String.format("email has been sent to %s", message.receiver().email()));
        return new Result(Status.OK);
    }
}
