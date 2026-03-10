package notifier.email;

import api.email.EmailDto;
import notifier.message.Message;

class EmailMapper {
    EmailDto toDto(Message message) {
        return new EmailDto(message.title(), message.value(), message.receiver().email());
    }
}
