package io.pivotal.singapore;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SomeEvent {
    private String name;
    private String timestamp;

    public SomeEvent() { }

    @JsonCreator
    public SomeEvent(@JsonProperty("name") String name,
                     @JsonProperty("timestamp") String timestamp) {
        this.name = name;
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "SomeEvent{" +
                "name='" + name + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
