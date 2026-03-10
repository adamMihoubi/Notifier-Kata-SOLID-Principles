package notifier.email;

import api.email.EmailSender;
import notifier.Notifier;
import notifier.logger.Logger;
import notifier.message.Message;
import notifier.result.Result;
import notifier.result.Status;

public class EmailNotifier implements Notifier {
    private final Logger logger;
    private final EmailSender  emailSender;
    private final EmailMapper emailMapper;

    public EmailNotifier(Logger logger, EmailSender emailSender) {
        this.logger = logger;
        this.emailSender = emailSender;
        emailMapper = new EmailMapper();
    }

    @Override
    public Result notify(Message message) {
        emailSender.send(emailMapper.toDto(message));
        logger.log(String.format("email has been sent to %s", message.receiver().email()));
        return new Result(Status.OK);
    }
}
