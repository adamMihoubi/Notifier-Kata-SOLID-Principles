package notifier.push;

import api.push.PushDto;
import notifier.message.Message;

class PushMapper {
    private static final String PUSH_MESSAGE = "Push notification : updated Made";

    public PushDto toDto(Message message) {
        return new PushDto(PUSH_MESSAGE, message.receiver().phone());
    }
}
