package notifier.doubles;

import notifier.logger.Logger;

public class SpyLogger implements Logger {
    private String message;

    @Override
    public void log(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
