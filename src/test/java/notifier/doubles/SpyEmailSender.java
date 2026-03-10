package notifier.doubles;

import api.email.EmailDto;
import api.email.EmailSender;

public class SpyEmailSender implements EmailSender {
    private EmailDto email;

    public EmailDto getSent() {
        return email;
    }

    @Override
    public void send(EmailDto email) {
        this.email = email;
    }
}
