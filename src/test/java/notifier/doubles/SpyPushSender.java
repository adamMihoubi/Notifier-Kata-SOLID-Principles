package notifier.doubles;

import api.push.PushDto;
import api.push.PushSender;

public class SpyPushSender implements PushSender {
    private PushDto push;

    @Override
    public void send(PushDto push) {
        this.push = push;
    }

    public PushDto getPush() {
        return push;
    }
}
