package notifier.email;

import api.email.EmailSender;
import notifier.Notifier;
import notifier.logger.Logger;
import notifier.message.Message;
import notifier.result.Result;
import notifier.result.Status;

public class EmailNotifier implements Notifier {
    private final Logger logger;
    private final EmailSender emailSender;
    private final EmailMapper emailMapper;
    private final MailCounter mailCounter;

    public EmailNotifier(Logger logger,
                         EmailSender emailSender,
                         MailCounter mailCounter) {
        this.logger = logger;
        this.emailSender = emailSender;
        this.mailCounter = mailCounter;
        emailMapper = new EmailMapper();
    }

    @Override
    public Result notify(Message message) {
        boolean limited = mailCounter.isLimited();
        if (limited) {
            logger.log("email has been delayed because of the limit of 100 mails per hour");
            return new Result(Status.CANCELED);
        }
        emailSender.send(emailMapper.toDto(message));
        logger.log(String.format("email has been sent to %s", message.receiver().email()));
        return new Result(Status.OK);
    }
}
