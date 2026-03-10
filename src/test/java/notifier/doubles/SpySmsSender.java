package notifier.doubles;

import api.sms.SmsDto;
import api.sms.SmsSender;

public class SpySmsSender implements SmsSender {
    private SmsDto sms;

    @Override
    public void send(SmsDto sms) {
        this.sms = sms;
    }

    public SmsDto getSms() {
        return sms;
    }
}
