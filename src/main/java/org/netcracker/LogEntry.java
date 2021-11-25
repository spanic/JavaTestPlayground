package org.netcracker;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class LogEntry implements Comparable<LogEntry> {

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

        // code it yourself
        public Builder setDateTime(String dateTimeStr) {
            LogEntry.this.dateTime = Instant.ofEpochSecond(Long.parseLong(dateTimeStr))
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
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
    public int compareTo(LogEntry o) {
        if (getDateTime().isBefore(o.getDateTime())) {
            return -1;
        } else if (getDateTime().isAfter(o.getDateTime())) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        LogEntry logEntry = (LogEntry) other;
        return getDateTime().equals(logEntry.getDateTime())
                && getDeviceModelName().equals(logEntry.getDeviceModelName())
                && Objects.equals(getMessage(), logEntry.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDateTime(), getDeviceModelName(), getMessage());
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
