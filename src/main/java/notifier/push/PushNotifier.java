package notifier.push;

import api.push.PushSender;
import notifier.Notifier;
import notifier.message.Message;
import notifier.result.Result;
import notifier.result.Status;

public class PushNotifier implements Notifier {
    private final PushSender pushSender;
    private final PushMapper pushMapper;

    public PushNotifier(PushSender pushSender) {
        this.pushSender = pushSender;
        pushMapper = new PushMapper();
    }

    @Override
    public Result notify(Message message) {
        pushSender.send(pushMapper.toDto(message));
        return new Result(Status.OK);
    }
}
