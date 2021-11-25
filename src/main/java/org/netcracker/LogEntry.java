package org.netcracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogEntry {

    private LocalDateTime dateTime;
    private String deviceModelName;
    private String message;

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDeviceModelName() {
        return deviceModelName;
    }

    public String getMessage() {
        return message;
    }

    public static Builder builder() {
        return new LogEntry().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setDateTime(LocalDateTime dateTime) {
            LogEntry.this.dateTime = dateTime;
            return this;
        }

        public Builder setDeviceModelName(String deviceModelName) {
            LogEntry.this.deviceModelName = deviceModelName;
            return this;
        }

        public Builder setMessage(String message) {
            LogEntry.this.message = message;
            return this;
        }

        public LogEntry build() {
            return LogEntry.this;
        }

    }

    @Override
    public String toString() {
        return String.format(
                "Date: %s | model: %s | message: %s",
                getDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                getDeviceModelName(),
                getMessage()
        );
    }

}
