package notifier.sms;

import api.sms.SmsDto;
import notifier.message.Message;

class SmsMapper {
    public SmsDto toDto(Message message) {
        String formattedMessage = """
                %s
                %s""".formatted(message.title(), message.value());
        return new SmsDto(formattedMessage, message.receiver().phone());
    }
}
