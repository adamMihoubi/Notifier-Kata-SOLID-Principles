package notifier.sms;

import api.sms.SmsSender;
import notifier.Notifier;
import notifier.message.Message;
import notifier.result.Result;
import notifier.result.Status;

public class SmsNotifier implements Notifier {
    private final SmsSender smsSender;
    private final SmsMapper smsMapper;

    public SmsNotifier(SmsSender smsSender) {
        this.smsSender = smsSender;
        smsMapper = new SmsMapper();
    }

    @Override
    public Result notify(Message message) {
        smsSender.send(smsMapper.toDto(message));
        return new Result(Status.OK);
    }
}
